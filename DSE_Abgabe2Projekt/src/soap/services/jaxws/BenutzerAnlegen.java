
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

@XmlRootElement(name = "benutzerAnlegen", namespace = "http://services.soap/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "benutzerAnlegen", namespace = "http://services.soap/", propOrder = {"arg0", "arg1", "arg2", "arg3", "arg4", "arg5", "arg6", "arg7", "arg8"})

public class BenutzerAnlegen {

    @XmlElement(name = "arg0")
    private java.lang.String arg0;
    @XmlElement(name = "arg1")
    private java.lang.String arg1;
    @XmlElement(name = "arg2")
    private java.lang.String arg2;
    @XmlElement(name = "arg3")
    private int arg3;
    @XmlElement(name = "arg4")
    private java.lang.String arg4;
    @XmlElement(name = "arg5")
    private java.lang.String arg5;
    @XmlElement(name = "arg6")
    private int arg6;
    @XmlElement(name = "arg7")
    private java.lang.String arg7;
    @XmlElement(name = "arg8")
    private java.lang.String arg8;

    public java.lang.String getArg0() {
        return this.arg0;
    }

    public void setArg0(java.lang.String newArg0)  {
        this.arg0 = newArg0;
    }

    public java.lang.String getArg1() {
        return this.arg1;
    }

    public void setArg1(java.lang.String newArg1)  {
        this.arg1 = newArg1;
    }

    public java.lang.String getArg2() {
        return this.arg2;
    }

    public void setArg2(java.lang.String newArg2)  {
        this.arg2 = newArg2;
    }

    public int getArg3() {
        return this.arg3;
    }

    public void setArg3(int newArg3)  {
        this.arg3 = newArg3;
    }

    public java.lang.String getArg4() {
        return this.arg4;
    }

    public void setArg4(java.lang.String newArg4)  {
        this.arg4 = newArg4;
    }

    public java.lang.String getArg5() {
        return this.arg5;
    }

    public void setArg5(java.lang.String newArg5)  {
        this.arg5 = newArg5;
    }

    public int getArg6() {
        return this.arg6;
    }

    public void setArg6(int newArg6)  {
        this.arg6 = newArg6;
    }

    public java.lang.String getArg7() {
        return this.arg7;
    }

    public void setArg7(java.lang.String newArg7)  {
        this.arg7 = newArg7;
    }

    public java.lang.String getArg8() {
        return this.arg8;
    }

    public void setArg8(java.lang.String newArg8)  {
        this.arg8 = newArg8;
    }

}

