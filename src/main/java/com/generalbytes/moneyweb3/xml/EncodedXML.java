
package com.generalbytes.moneyweb3.xml;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="ISDS_SenderID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="ISDS_RecipientID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="SenderKey" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="RecipientKey" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="EncData" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="EncPublicKey" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="version" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="minVersion" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="part" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "isdsSenderID",
    "isdsRecipientID",
    "senderKey",
    "recipientKey",
    "encData",
    "encPublicKey"
})
@XmlRootElement(name = "EncodedXML")
public class EncodedXML {

    @XmlElement(name = "ISDS_SenderID")
    protected String isdsSenderID;
    @XmlElement(name = "ISDS_RecipientID")
    protected String isdsRecipientID;
    @XmlElement(name = "SenderKey", required = true)
    protected String senderKey;
    @XmlElement(name = "RecipientKey", required = true)
    protected String recipientKey;
    @XmlElement(name = "EncData", required = true)
    protected String encData;
    @XmlElement(name = "EncPublicKey")
    protected String encPublicKey;
    @XmlAttribute(name = "version")
    protected String version;
    @XmlAttribute(name = "minVersion")
    protected String minVersion;
    @XmlAttribute(name = "part")
    protected String part;
    @XmlAttribute(name = "name")
    protected String name;

    /**
     * Gets the value of the isdsSenderID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getISDSSenderID() {
        return isdsSenderID;
    }

    /**
     * Sets the value of the isdsSenderID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setISDSSenderID(String value) {
        this.isdsSenderID = value;
    }

    /**
     * Gets the value of the isdsRecipientID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getISDSRecipientID() {
        return isdsRecipientID;
    }

    /**
     * Sets the value of the isdsRecipientID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setISDSRecipientID(String value) {
        this.isdsRecipientID = value;
    }

    /**
     * Gets the value of the senderKey property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSenderKey() {
        return senderKey;
    }

    /**
     * Sets the value of the senderKey property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSenderKey(String value) {
        this.senderKey = value;
    }

    /**
     * Gets the value of the recipientKey property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRecipientKey() {
        return recipientKey;
    }

    /**
     * Sets the value of the recipientKey property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRecipientKey(String value) {
        this.recipientKey = value;
    }

    /**
     * Gets the value of the encData property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEncData() {
        return encData;
    }

    /**
     * Sets the value of the encData property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEncData(String value) {
        this.encData = value;
    }

    /**
     * Gets the value of the encPublicKey property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEncPublicKey() {
        return encPublicKey;
    }

    /**
     * Sets the value of the encPublicKey property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEncPublicKey(String value) {
        this.encPublicKey = value;
    }

    /**
     * Gets the value of the version property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVersion() {
        return version;
    }

    /**
     * Sets the value of the version property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVersion(String value) {
        this.version = value;
    }

    /**
     * Gets the value of the minVersion property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMinVersion() {
        return minVersion;
    }

    /**
     * Sets the value of the minVersion property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMinVersion(String value) {
        this.minVersion = value;
    }

    /**
     * Gets the value of the part property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPart() {
        return part;
    }

    /**
     * Sets the value of the part property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPart(String value) {
        this.part = value;
    }

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

}
