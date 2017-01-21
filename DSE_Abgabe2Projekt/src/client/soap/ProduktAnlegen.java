
package client.soap;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für produktAnlegen complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="produktAnlegen"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="arg0" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="arg1" type="{http://www.w3.org/2001/XMLSchema}double"/&gt;
 *         &lt;element name="arg2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="arg3" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="arg4" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="arg5" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "produktAnlegenClient", propOrder = {
    "arg0",
    "arg1",
    "arg2",
    "arg3",
    "arg4",
    "arg5"
})
public class ProduktAnlegen {

    protected String arg0;
    protected double arg1;
    protected String arg2;
    protected String arg3;
    protected int arg4;
    protected String arg5;

    /**
     * Ruft den Wert der arg0-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getArg0() {
        return arg0;
    }

    /**
     * Legt den Wert der arg0-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setArg0(String value) {
        this.arg0 = value;
    }

    /**
     * Ruft den Wert der arg1-Eigenschaft ab.
     * 
     */
    public double getArg1() {
        return arg1;
    }

    /**
     * Legt den Wert der arg1-Eigenschaft fest.
     * 
     */
    public void setArg1(double value) {
        this.arg1 = value;
    }

    /**
     * Ruft den Wert der arg2-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getArg2() {
        return arg2;
    }

    /**
     * Legt den Wert der arg2-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setArg2(String value) {
        this.arg2 = value;
    }

    /**
     * Ruft den Wert der arg3-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getArg3() {
        return arg3;
    }

    /**
     * Legt den Wert der arg3-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setArg3(String value) {
        this.arg3 = value;
    }

    /**
     * Ruft den Wert der arg4-Eigenschaft ab.
     * 
     */
    public int getArg4() {
        return arg4;
    }

    /**
     * Legt den Wert der arg4-Eigenschaft fest.
     * 
     */
    public void setArg4(int value) {
        this.arg4 = value;
    }

    /**
     * Ruft den Wert der arg5-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getArg5() {
        return arg5;
    }

    /**
     * Legt den Wert der arg5-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setArg5(String value) {
        this.arg5 = value;
    }

}
