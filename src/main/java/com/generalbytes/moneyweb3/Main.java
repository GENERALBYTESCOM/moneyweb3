package com.generalbytes.moneyweb3;

import com.generalbytes.moneyweb3.xml.EncodedXML;
import com.generalbytes.moneyweb3.xml.SystemInfo;
import jakarta.xml.bind.DatatypeConverter;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import org.apache.commons.io.IOUtils;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.zip.ZipInputStream;

public class Main {
    private static String AES_DECRYPTION_PASSWORD = "cPE7gDVDeRbr27U4u_Rot%~:QGw8GmJvoHs##4yHZApJpkCQD7G1Ac:Ca.BUXHzB";
    private static String SYSTEM_INFO_DECRYPTION_PASSWORD = "ne5jujw2v8tiu546";

    public static void main(String[] args) throws NoSuchAlgorithmException {
        System.out.println("MoneyWeb3 decoder 20220521");
        if (args.length != 1) {
            System.out.println("Invalid argument");

            System.out.println("Usage:");
            System.out.println(" MoneyWeb3Decoder encrypted_message.xml");
            System.out.println();
            System.exit(1);
        }
        try {
            String fileName = args[0];
            if (! new File(fileName).exists()) {
                System.out.println("File " + fileName + " doesn't exist.");
                System.exit(1);
            }
            //parse file
            EncodedXML xml = unmarshallFile(fileName);

            //Currently, only decryption of messages with 0FB3 is supported
            if (xml.getSenderKey().equalsIgnoreCase("0FB3") && xml.getRecipientKey().equalsIgnoreCase("0FB3")) {

                String encData = xml.getEncData(); //encrypted data in batch
                String encPublicKey = xml.getEncPublicKey(); // this field contains public key but in case of 0FB3 contains systemInfo

                //decode system info
                String systemInfo = decryptSystemInfo(encPublicKey, SYSTEM_INFO_DECRYPTION_PASSWORD);
                //parse decoded system info from XML format
                SystemInfo si = unmarshallSystemInfo(systemInfo);


                //check hash SHA1 of the message
                String expectedDecodedMessageHash = si.getEncDataSHA1();
                MessageDigest sha1 = MessageDigest.getInstance("SHA1");
                String decodedMessageHash = DatatypeConverter.printHexBinary(sha1.digest(encData.getBytes())).toLowerCase();

                if (decodedMessageHash.equals(expectedDecodedMessageHash)) {
                    MessageDigest sha256 = MessageDigest.getInstance("SHA-256");
                    sha256.update(AES_DECRYPTION_PASSWORD.getBytes());
                    byte[] aesKey = sha256.digest(); //sha256 hash of the encryption password is used as key
                    byte[] iv = Base64.getDecoder().decode(si.getComputerID()); //computer id is used as input vector

                    //Let's decrypt the encoded message
                    String result = decryptAES256Base64Message(encData, aesKey, iv);
                    System.out.println("Decrypted message:---------------------------");
                    System.out.println("SystemInfo:---------------------------");
                    System.out.println(systemInfo);
                    System.out.println("Message:---------------------------");
                    System.out.println(result);
                    System.out.println("---------------------------End of the message.");
                } else {
                    System.out.println("We are sorry, but hash of the encrypted message doesn't match.");
                }
            } else {
                System.out.println("I'm sorry, I can't read this message. Sender and recipient keys are not 0FB3.");
            }
        } catch (JAXBException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static String decryptSystemInfo(String messageInBase64, String password) {
        byte[] messageEncrypted = Base64.getDecoder().decode(messageInBase64);
        byte[] messageDecryptedA = new byte[messageEncrypted.length];
        try {
            //Decryption xor key is MD5 hash in ascii of the password
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(password.getBytes());
            byte[] key = DatatypeConverter.printHexBinary(md.digest()).toLowerCase().getBytes();

            //first stage - dexor message with key
            for (int i = 0; i < messageEncrypted.length; i++ ) {
                messageDecryptedA[i] = (byte)(Byte.toUnsignedInt(messageEncrypted[i]) ^ Byte.toUnsignedInt(key[i % key.length]));
            }

            //second stage - dexor message by even and odd bytes
            byte[] messageDecryptedB = new byte[messageDecryptedA.length / 2 + messageDecryptedA.length % 2];
            for (int i = 0; i < messageDecryptedB.length; i++ ) {
                messageDecryptedB[i] = (byte)(Byte.toUnsignedInt(messageDecryptedA[i*2]) ^ Byte.toUnsignedInt(messageDecryptedA[i*2+1]));
            }
            return new String(messageDecryptedB);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    private static EncodedXML unmarshallFile(String filename) throws JAXBException, IOException {
        JAXBContext context = JAXBContext.newInstance(EncodedXML.class);
        return (EncodedXML) context.createUnmarshaller()
                .unmarshal(new FileReader(filename));
    }
    private static SystemInfo unmarshallSystemInfo(String systemInfoXML) throws JAXBException, IOException {
        JAXBContext context = JAXBContext.newInstance(SystemInfo.class);
        return (SystemInfo) context.createUnmarshaller()
                .unmarshal(new StringReader(systemInfoXML));
    }

    private static String decryptAES256Base64Message(String encryptedMessageInBase64, byte[] key, byte[] iv) {
        try {
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE, new SecretKeySpec(key, "AES"), new IvParameterSpec(iv));
            byte[] decryptedMessage = cipher.doFinal(Base64.getDecoder().decode(encryptedMessageInBase64));
            if (decryptedMessage[0] == 'P' && decryptedMessage[1] == 'K') { //Message is compressed as ZIP file
                ZipInputStream zip = new ZipInputStream(new ByteArrayInputStream(decryptedMessage));
                ByteArrayOutputStream bos = new ByteArrayOutputStream();
                zip.getNextEntry();
                IOUtils.copy(zip, bos);
                zip.close();
                bos.close();
                return bos.toString();
            }else{
                return new String(decryptedMessage);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}