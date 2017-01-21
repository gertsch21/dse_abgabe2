
package client.soap;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für benutzer complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="benutzer"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://services.soap/}person"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="istEingefroren" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "benutzerClient", propOrder = {
    "istEingefroren"
})
public class Benutzer
    extends Person
{

    protected boolean istEingefroren;

    /**
     * Ruft den Wert der istEingefroren-Eigenschaft ab.
     * 
     */
    public boolean isIstEingefroren() {
        return istEingefroren;
    }

    /**
     * Legt den Wert der istEingefroren-Eigenschaft fest.
     * 
     */
    public void setIstEingefroren(boolean value) {
        this.istEingefroren = value;
    }

}
