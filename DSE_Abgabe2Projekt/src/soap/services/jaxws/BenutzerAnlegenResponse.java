
package soap.services.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * This class was generated by Apache CXF 2.7.18
 * Sat Jan 21 15:00:21 CET 2017
 * Generated source version: 2.7.18
 */

@XmlRootElement(name = "benutzerAnlegenResponse", namespace = "http://services.soap/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "benutzerAnlegenResponse", namespace = "http://services.soap/")

public class BenutzerAnlegenResponse {

    @XmlElement(name = "return")
    private boolean _return;

    public boolean getReturn() {
        return this._return;
    }

    public void setReturn(boolean new_return)  {
        this._return = new_return;
    }

}

