
package soap.services.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * This class was generated by Apache CXF 2.7.18
 * Sat Jan 21 15:27:32 CET 2017
 * Generated source version: 2.7.18
 */

@XmlRootElement(name = "getProduktgruppeByName", namespace = "http://services.soap/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getProduktgruppeByName", namespace = "http://services.soap/")

public class GetProduktgruppeByName {

    @XmlElement(name = "arg0")
    private java.lang.String arg0;

    public java.lang.String getArg0() {
        return this.arg0;
    }

    public void setArg0(java.lang.String newArg0)  {
        this.arg0 = newArg0;
    }

}

