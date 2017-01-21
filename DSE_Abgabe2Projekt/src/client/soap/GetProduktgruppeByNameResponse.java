
package client.soap;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für getProduktgruppeByNameResponse complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="getProduktgruppeByNameResponse"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="return" type="{http://services.soap/}produktgruppe" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getProduktgruppeByNameResponseClient", propOrder = {
    "_return"
})
public class GetProduktgruppeByNameResponse {

    @XmlElement(name = "return")
    protected Produktgruppe _return;

    /**
     * Ruft den Wert der return-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Produktgruppe }
     *     
     */
    public Produktgruppe getReturn() {
        return _return;
    }

    /**
     * Legt den Wert der return-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Produktgruppe }
     *     
     */
    public void setReturn(Produktgruppe value) {
        this._return = value;
    }

}
