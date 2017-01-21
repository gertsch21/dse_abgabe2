
package client.soap.services.withoutTomcat;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the soap.services package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _GetBenutzerliste_QNAME = new QName("http://services.soap/", "getBenutzerliste");
    private final static QName _GetBenutzerlisteResponse_QNAME = new QName("http://services.soap/", "getBenutzerlisteResponse");
    private final static QName _PruefeLogin_QNAME = new QName("http://services.soap/", "pruefeLogin");
    private final static QName _PruefeLoginResponse_QNAME = new QName("http://services.soap/", "pruefeLoginResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: soap.services
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetBenutzerliste }
     * 
     */
    public GetBenutzerliste createGetBenutzerliste() {
        return new GetBenutzerliste();
    }

    /**
     * Create an instance of {@link GetBenutzerlisteResponse }
     * 
     */
    public GetBenutzerlisteResponse createGetBenutzerlisteResponse() {
        return new GetBenutzerlisteResponse();
    }

    /**
     * Create an instance of {@link PruefeLogin }
     * 
     */
    public PruefeLogin createPruefeLogin() {
        return new PruefeLogin();
    }

    /**
     * Create an instance of {@link PruefeLoginResponse }
     * 
     */
    public PruefeLoginResponse createPruefeLoginResponse() {
        return new PruefeLoginResponse();
    }

    /**
     * Create an instance of {@link Benutzer }
     * 
     */
    public Benutzer createBenutzer() {
        return new Benutzer();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetBenutzerliste }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.soap/", name = "getBenutzerliste")
    public JAXBElement<GetBenutzerliste> createGetBenutzerliste(GetBenutzerliste value) {
        return new JAXBElement<GetBenutzerliste>(_GetBenutzerliste_QNAME, GetBenutzerliste.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetBenutzerlisteResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.soap/", name = "getBenutzerlisteResponse")
    public JAXBElement<GetBenutzerlisteResponse> createGetBenutzerlisteResponse(GetBenutzerlisteResponse value) {
        return new JAXBElement<GetBenutzerlisteResponse>(_GetBenutzerlisteResponse_QNAME, GetBenutzerlisteResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PruefeLogin }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.soap/", name = "pruefeLogin")
    public JAXBElement<PruefeLogin> createPruefeLogin(PruefeLogin value) {
        return new JAXBElement<PruefeLogin>(_PruefeLogin_QNAME, PruefeLogin.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PruefeLoginResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.soap/", name = "pruefeLoginResponse")
    public JAXBElement<PruefeLoginResponse> createPruefeLoginResponse(PruefeLoginResponse value) {
        return new JAXBElement<PruefeLoginResponse>(_PruefeLoginResponse_QNAME, PruefeLoginResponse.class, null, value);
    }

}
