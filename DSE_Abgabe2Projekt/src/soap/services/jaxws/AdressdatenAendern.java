
package soap.services.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * This class was generated by Apache CXF 2.7.18
 * Sat Jan 21 21:51:17 CET 2017
 * Generated source version: 2.7.18
 */

@XmlRootElement(name = "adressdatenAendern", namespace = "http://services.soap/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "adressdatenAendern", namespace = "http://services.soap/", propOrder = {"arg0", "arg1", "arg2", "arg3", "arg4"})

public class AdressdatenAendern {

    @XmlElement(name = "arg0")
    private java.lang.String arg0;
    @XmlElement(name = "arg1")
    private int arg1;
    @XmlElement(name = "arg2")
    private java.lang.String arg2;
    @XmlElement(name = "arg3")
    private java.lang.String arg3;
    @XmlElement(name = "arg4")
    private int arg4;

    public java.lang.String getArg0() {
        return this.arg0;
    }

    public void setArg0(java.lang.String newArg0)  {
        this.arg0 = newArg0;
    }

    public int getArg1() {
        return this.arg1;
    }

    public void setArg1(int newArg1)  {
        this.arg1 = newArg1;
    }

    public java.lang.String getArg2() {
        return this.arg2;
    }

    public void setArg2(java.lang.String newArg2)  {
        this.arg2 = newArg2;
    }

    public java.lang.String getArg3() {
        return this.arg3;
    }

    public void setArg3(java.lang.String newArg3)  {
        this.arg3 = newArg3;
    }

    public int getArg4() {
        return this.arg4;
    }

    public void setArg4(int newArg4)  {
        this.arg4 = newArg4;
    }

}

