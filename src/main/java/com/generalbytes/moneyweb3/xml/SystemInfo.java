
package com.generalbytes.moneyweb3.xml;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
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
 *         &lt;element name="MWLversion" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="DateTime" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="EncDataSHA1" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="ComputerName" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="ComputerID" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "mwLversion",
    "dateTime",
    "encDataSHA1",
    "computerName",
    "computerID"
})
@XmlRootElement(name = "SystemInfo")
public class SystemInfo {

    @XmlElement(name = "MWLversion", required = true)
    protected String mwLversion;
    @XmlElement(name = "DateTime", required = true)
    protected String dateTime;
    @XmlElement(name = "EncDataSHA1", required = true)
    protected String encDataSHA1;
    @XmlElement(name = "ComputerName", required = true)
    protected String computerName;
    @XmlElement(name = "ComputerID", required = true)
    protected String computerID;

    /**
     * Gets the value of the mwLversion property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMWLversion() {
        return mwLversion;
    }

    /**
     * Sets the value of the mwLversion property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMWLversion(String value) {
        this.mwLversion = value;
    }

    /**
     * Gets the value of the dateTime property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDateTime() {
        return dateTime;
    }

    /**
     * Sets the value of the dateTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDateTime(String value) {
        this.dateTime = value;
    }

    /**
     * Gets the value of the encDataSHA1 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEncDataSHA1() {
        return encDataSHA1;
    }

    /**
     * Sets the value of the encDataSHA1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEncDataSHA1(String value) {
        this.encDataSHA1 = value;
    }

    /**
     * Gets the value of the computerName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getComputerName() {
        return computerName;
    }

    /**
     * Sets the value of the computerName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setComputerName(String value) {
        this.computerName = value;
    }

    /**
     * Gets the value of the computerID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getComputerID() {
        return computerID;
    }

    /**
     * Sets the value of the computerID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setComputerID(String value) {
        this.computerID = value;
    }

}
