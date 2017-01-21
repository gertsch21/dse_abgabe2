
package client.soap;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java-Klasse für produkt complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="produkt"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="produktID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="startpreis" type="{http://www.w3.org/2001/XMLSchema}double"/&gt;
 *         &lt;element name="ownerUsername" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="dauer" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="beschreibung" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="startdatum" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *         &lt;element name="enddatum" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *         &lt;element name="hoechstbietender" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="aktuellesGebot" type="{http://www.w3.org/2001/XMLSchema}double"/&gt;
 *         &lt;element name="verkauft" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "produktClient", propOrder = {
    "produktID",
    "name",
    "startpreis",
    "ownerUsername",
    "dauer",
    "beschreibung",
    "startdatum",
    "enddatum",
    "hoechstbietender",
    "aktuellesGebot",
    "verkauft"
})
public class Produkt {

    protected String produktID;
    protected String name;
    protected double startpreis;
    protected String ownerUsername;
    protected int dauer;
    protected String beschreibung;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar startdatum;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar enddatum;
    protected String hoechstbietender;
    protected double aktuellesGebot;
    protected boolean verkauft;

    /**
     * Ruft den Wert der produktID-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProduktID() {
        return produktID;
    }

    /**
     * Legt den Wert der produktID-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProduktID(String value) {
        this.produktID = value;
    }

    /**
     * Ruft den Wert der name-Eigenschaft ab.
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
     * Legt den Wert der name-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Ruft den Wert der startpreis-Eigenschaft ab.
     * 
     */
    public double getStartpreis() {
        return startpreis;
    }

    /**
     * Legt den Wert der startpreis-Eigenschaft fest.
     * 
     */
    public void setStartpreis(double value) {
        this.startpreis = value;
    }

    /**
     * Ruft den Wert der ownerUsername-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOwnerUsername() {
        return ownerUsername;
    }

    /**
     * Legt den Wert der ownerUsername-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOwnerUsername(String value) {
        this.ownerUsername = value;
    }

    /**
     * Ruft den Wert der dauer-Eigenschaft ab.
     * 
     */
    public int getDauer() {
        return dauer;
    }

    /**
     * Legt den Wert der dauer-Eigenschaft fest.
     * 
     */
    public void setDauer(int value) {
        this.dauer = value;
    }

    /**
     * Ruft den Wert der beschreibung-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBeschreibung() {
        return beschreibung;
    }

    /**
     * Legt den Wert der beschreibung-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBeschreibung(String value) {
        this.beschreibung = value;
    }

    /**
     * Ruft den Wert der startdatum-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getStartdatum() {
        return startdatum;
    }

    /**
     * Legt den Wert der startdatum-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setStartdatum(XMLGregorianCalendar value) {
        this.startdatum = value;
    }

    /**
     * Ruft den Wert der enddatum-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getEnddatum() {
        return enddatum;
    }

    /**
     * Legt den Wert der enddatum-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setEnddatum(XMLGregorianCalendar value) {
        this.enddatum = value;
    }

    /**
     * Ruft den Wert der hoechstbietender-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHoechstbietender() {
        return hoechstbietender;
    }

    /**
     * Legt den Wert der hoechstbietender-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHoechstbietender(String value) {
        this.hoechstbietender = value;
    }

    /**
     * Ruft den Wert der aktuellesGebot-Eigenschaft ab.
     * 
     */
    public double getAktuellesGebot() {
        return aktuellesGebot;
    }

    /**
     * Legt den Wert der aktuellesGebot-Eigenschaft fest.
     * 
     */
    public void setAktuellesGebot(double value) {
        this.aktuellesGebot = value;
    }

    /**
     * Ruft den Wert der verkauft-Eigenschaft ab.
     * 
     */
    public boolean isVerkauft() {
        return verkauft;
    }

    /**
     * Legt den Wert der verkauft-Eigenschaft fest.
     * 
     */
    public void setVerkauft(boolean value) {
        this.verkauft = value;
    }

}
