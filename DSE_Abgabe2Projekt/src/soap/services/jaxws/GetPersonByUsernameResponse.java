
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

@XmlRootElement(name = "getPersonByUsernameResponse", namespace = "http://services.soap/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getPersonByUsernameResponse", namespace = "http://services.soap/")

public class GetPersonByUsernameResponse {

    @XmlElement(name = "return")
    private modell.Person _return;

    public modell.Person getReturn() {
        return this._return;
    }

    public void setReturn(modell.Person new_return)  {
        this._return = new_return;
    }

}
