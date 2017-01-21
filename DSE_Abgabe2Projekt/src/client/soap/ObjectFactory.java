
package client.soap;

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

    private final static QName _Benutzer_QNAME = new QName("http://services.soap/", "Benutzer");
    private final static QName _Person_QNAME = new QName("http://services.soap/", "Person");
    private final static QName _Produkt_QNAME = new QName("http://services.soap/", "Produkt");
    private final static QName _Produktgruppe_QNAME = new QName("http://services.soap/", "Produktgruppe");
    private final static QName _AdminAnlegen_QNAME = new QName("http://services.soap/", "adminAnlegen");
    private final static QName _AdminAnlegenResponse_QNAME = new QName("http://services.soap/", "adminAnlegenResponse");
    private final static QName _AdressdatenAendern_QNAME = new QName("http://services.soap/", "adressdatenAendern");
    private final static QName _AdressdatenAendernResponse_QNAME = new QName("http://services.soap/", "adressdatenAendernResponse");
    private final static QName _BenutzerAnlegen_QNAME = new QName("http://services.soap/", "benutzerAnlegen");
    private final static QName _BenutzerAnlegenResponse_QNAME = new QName("http://services.soap/", "benutzerAnlegenResponse");
    private final static QName _BenutzerEinfAufheben_QNAME = new QName("http://services.soap/", "benutzerEinfAufheben");
    private final static QName _BenutzerEinfAufhebenResponse_QNAME = new QName("http://services.soap/", "benutzerEinfAufhebenResponse");
    private final static QName _BenutzerEinfrieren_QNAME = new QName("http://services.soap/", "benutzerEinfrieren");
    private final static QName _BenutzerEinfrierenResponse_QNAME = new QName("http://services.soap/", "benutzerEinfrierenResponse");
    private final static QName _Benutzerloeschen_QNAME = new QName("http://services.soap/", "benutzerloeschen");
    private final static QName _BenutzerloeschenResponse_QNAME = new QName("http://services.soap/", "benutzerloeschenResponse");
    private final static QName _GebotAbgeben_QNAME = new QName("http://services.soap/", "gebotAbgeben");
    private final static QName _GebotAbgebenResponse_QNAME = new QName("http://services.soap/", "gebotAbgebenResponse");
    private final static QName _GebotLoeschen_QNAME = new QName("http://services.soap/", "gebotLoeschen");
    private final static QName _GebotLoeschenResponse_QNAME = new QName("http://services.soap/", "gebotLoeschenResponse");
    private final static QName _GetBenutzerliste_QNAME = new QName("http://services.soap/", "getBenutzerliste");
    private final static QName _GetBenutzerlisteResponse_QNAME = new QName("http://services.soap/", "getBenutzerlisteResponse");
    private final static QName _GetGebotshistorieVonBenutzer_QNAME = new QName("http://services.soap/", "getGebotshistorieVonBenutzer");
    private final static QName _GetGebotshistorieVonBenutzerResponse_QNAME = new QName("http://services.soap/", "getGebotshistorieVonBenutzerResponse");
    private final static QName _GetPersonByUsername_QNAME = new QName("http://services.soap/", "getPersonByUsername");
    private final static QName _GetPersonByUsernameResponse_QNAME = new QName("http://services.soap/", "getPersonByUsernameResponse");
    private final static QName _GetProduktByID_QNAME = new QName("http://services.soap/", "getProduktByID");
    private final static QName _GetProduktByIDResponse_QNAME = new QName("http://services.soap/", "getProduktByIDResponse");
    private final static QName _GetProduktListe_QNAME = new QName("http://services.soap/", "getProduktListe");
    private final static QName _GetProduktListeResponse_QNAME = new QName("http://services.soap/", "getProduktListeResponse");
    private final static QName _GetProduktgruppeByName_QNAME = new QName("http://services.soap/", "getProduktgruppeByName");
    private final static QName _GetProduktgruppeByNameResponse_QNAME = new QName("http://services.soap/", "getProduktgruppeByNameResponse");
    private final static QName _GetProduktgruppeList_QNAME = new QName("http://services.soap/", "getProduktgruppeList");
    private final static QName _GetProduktgruppeListResponse_QNAME = new QName("http://services.soap/", "getProduktgruppeListResponse");
    private final static QName _GetVerkaufteProdukteVonBenutzer_QNAME = new QName("http://services.soap/", "getVerkaufteProdukteVonBenutzer");
    private final static QName _GetVerkaufteProdukteVonBenutzerResponse_QNAME = new QName("http://services.soap/", "getVerkaufteProdukteVonBenutzerResponse");
    private final static QName _GetZumVerkaufStehendeProdukteVonBenutzer_QNAME = new QName("http://services.soap/", "getZumVerkaufStehendeProdukteVonBenutzer");
    private final static QName _GetZumVerkaufStehendeProdukteVonBenutzerResponse_QNAME = new QName("http://services.soap/", "getZumVerkaufStehendeProdukteVonBenutzerResponse");
    private final static QName _PasswortAendern_QNAME = new QName("http://services.soap/", "passwortAendern");
    private final static QName _PasswortAendernResponse_QNAME = new QName("http://services.soap/", "passwortAendernResponse");
    private final static QName _ProduktAendern_QNAME = new QName("http://services.soap/", "produktAendern");
    private final static QName _ProduktAendernResponse_QNAME = new QName("http://services.soap/", "produktAendernResponse");
    private final static QName _ProduktAnlegen_QNAME = new QName("http://services.soap/", "produktAnlegen");
    private final static QName _ProduktAnlegenResponse_QNAME = new QName("http://services.soap/", "produktAnlegenResponse");
    private final static QName _ProduktLoeschen_QNAME = new QName("http://services.soap/", "produktLoeschen");
    private final static QName _ProduktLoeschenResponse_QNAME = new QName("http://services.soap/", "produktLoeschenResponse");
    private final static QName _ProduktVerschieben_QNAME = new QName("http://services.soap/", "produktVerschieben");
    private final static QName _ProduktVerschiebenResponse_QNAME = new QName("http://services.soap/", "produktVerschiebenResponse");
    private final static QName _ProduktgruppeAendern_QNAME = new QName("http://services.soap/", "produktgruppeAendern");
    private final static QName _ProduktgruppeAendernResponse_QNAME = new QName("http://services.soap/", "produktgruppeAendernResponse");
    private final static QName _ProduktgruppeAnlegen_QNAME = new QName("http://services.soap/", "produktgruppeAnlegen");
    private final static QName _ProduktgruppeAnlegenResponse_QNAME = new QName("http://services.soap/", "produktgruppeAnlegenResponse");
    private final static QName _ProduktgruppeLoeschen_QNAME = new QName("http://services.soap/", "produktgruppeLoeschen");
    private final static QName _ProduktgruppeLoeschenResponse_QNAME = new QName("http://services.soap/", "produktgruppeLoeschenResponse");
    private final static QName _PruefeLogin_QNAME = new QName("http://services.soap/", "pruefeLogin");
    private final static QName _PruefeLoginResponse_QNAME = new QName("http://services.soap/", "pruefeLoginResponse");
    private final static QName _SucheProdukt_QNAME = new QName("http://services.soap/", "sucheProdukt");
    private final static QName _SucheProduktResponse_QNAME = new QName("http://services.soap/", "sucheProduktResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: soap.services
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Benutzer }
     * 
     */
    public Benutzer createBenutzer() {
        return new Benutzer();
    }

    /**
     * Create an instance of {@link Produkt }
     * 
     */
    public Produkt createProdukt() {
        return new Produkt();
    }

    /**
     * Create an instance of {@link Produktgruppe }
     * 
     */
    public Produktgruppe createProduktgruppe() {
        return new Produktgruppe();
    }

    /**
     * Create an instance of {@link AdminAnlegen }
     * 
     */
    public AdminAnlegen createAdminAnlegen() {
        return new AdminAnlegen();
    }

    /**
     * Create an instance of {@link AdminAnlegenResponse }
     * 
     */
    public AdminAnlegenResponse createAdminAnlegenResponse() {
        return new AdminAnlegenResponse();
    }

    /**
     * Create an instance of {@link AdressdatenAendern }
     * 
     */
    public AdressdatenAendern createAdressdatenAendern() {
        return new AdressdatenAendern();
    }

    /**
     * Create an instance of {@link AdressdatenAendernResponse }
     * 
     */
    public AdressdatenAendernResponse createAdressdatenAendernResponse() {
        return new AdressdatenAendernResponse();
    }

    /**
     * Create an instance of {@link BenutzerAnlegen }
     * 
     */
    public BenutzerAnlegen createBenutzerAnlegen() {
        return new BenutzerAnlegen();
    }

    /**
     * Create an instance of {@link BenutzerAnlegenResponse }
     * 
     */
    public BenutzerAnlegenResponse createBenutzerAnlegenResponse() {
        return new BenutzerAnlegenResponse();
    }

    /**
     * Create an instance of {@link BenutzerEinfAufheben }
     * 
     */
    public BenutzerEinfAufheben createBenutzerEinfAufheben() {
        return new BenutzerEinfAufheben();
    }

    /**
     * Create an instance of {@link BenutzerEinfAufhebenResponse }
     * 
     */
    public BenutzerEinfAufhebenResponse createBenutzerEinfAufhebenResponse() {
        return new BenutzerEinfAufhebenResponse();
    }

    /**
     * Create an instance of {@link BenutzerEinfrieren }
     * 
     */
    public BenutzerEinfrieren createBenutzerEinfrieren() {
        return new BenutzerEinfrieren();
    }

    /**
     * Create an instance of {@link BenutzerEinfrierenResponse }
     * 
     */
    public BenutzerEinfrierenResponse createBenutzerEinfrierenResponse() {
        return new BenutzerEinfrierenResponse();
    }

    /**
     * Create an instance of {@link Benutzerloeschen }
     * 
     */
    public Benutzerloeschen createBenutzerloeschen() {
        return new Benutzerloeschen();
    }

    /**
     * Create an instance of {@link BenutzerloeschenResponse }
     * 
     */
    public BenutzerloeschenResponse createBenutzerloeschenResponse() {
        return new BenutzerloeschenResponse();
    }

    /**
     * Create an instance of {@link GebotAbgeben }
     * 
     */
    public GebotAbgeben createGebotAbgeben() {
        return new GebotAbgeben();
    }

    /**
     * Create an instance of {@link GebotAbgebenResponse }
     * 
     */
    public GebotAbgebenResponse createGebotAbgebenResponse() {
        return new GebotAbgebenResponse();
    }

    /**
     * Create an instance of {@link GebotLoeschen }
     * 
     */
    public GebotLoeschen createGebotLoeschen() {
        return new GebotLoeschen();
    }

    /**
     * Create an instance of {@link GebotLoeschenResponse }
     * 
     */
    public GebotLoeschenResponse createGebotLoeschenResponse() {
        return new GebotLoeschenResponse();
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
     * Create an instance of {@link GetGebotshistorieVonBenutzer }
     * 
     */
    public GetGebotshistorieVonBenutzer createGetGebotshistorieVonBenutzer() {
        return new GetGebotshistorieVonBenutzer();
    }

    /**
     * Create an instance of {@link GetGebotshistorieVonBenutzerResponse }
     * 
     */
    public GetGebotshistorieVonBenutzerResponse createGetGebotshistorieVonBenutzerResponse() {
        return new GetGebotshistorieVonBenutzerResponse();
    }

    /**
     * Create an instance of {@link GetPersonByUsername }
     * 
     */
    public GetPersonByUsername createGetPersonByUsername() {
        return new GetPersonByUsername();
    }

    /**
     * Create an instance of {@link GetPersonByUsernameResponse }
     * 
     */
    public GetPersonByUsernameResponse createGetPersonByUsernameResponse() {
        return new GetPersonByUsernameResponse();
    }

    /**
     * Create an instance of {@link GetProduktByID }
     * 
     */
    public GetProduktByID createGetProduktByID() {
        return new GetProduktByID();
    }

    /**
     * Create an instance of {@link GetProduktByIDResponse }
     * 
     */
    public GetProduktByIDResponse createGetProduktByIDResponse() {
        return new GetProduktByIDResponse();
    }

    /**
     * Create an instance of {@link GetProduktListe }
     * 
     */
    public GetProduktListe createGetProduktListe() {
        return new GetProduktListe();
    }

    /**
     * Create an instance of {@link GetProduktListeResponse }
     * 
     */
    public GetProduktListeResponse createGetProduktListeResponse() {
        return new GetProduktListeResponse();
    }

    /**
     * Create an instance of {@link GetProduktgruppeByName }
     * 
     */
    public GetProduktgruppeByName createGetProduktgruppeByName() {
        return new GetProduktgruppeByName();
    }

    /**
     * Create an instance of {@link GetProduktgruppeByNameResponse }
     * 
     */
    public GetProduktgruppeByNameResponse createGetProduktgruppeByNameResponse() {
        return new GetProduktgruppeByNameResponse();
    }

    /**
     * Create an instance of {@link GetProduktgruppeList }
     * 
     */
    public GetProduktgruppeList createGetProduktgruppeList() {
        return new GetProduktgruppeList();
    }

    /**
     * Create an instance of {@link GetProduktgruppeListResponse }
     * 
     */
    public GetProduktgruppeListResponse createGetProduktgruppeListResponse() {
        return new GetProduktgruppeListResponse();
    }

    /**
     * Create an instance of {@link GetVerkaufteProdukteVonBenutzer }
     * 
     */
    public GetVerkaufteProdukteVonBenutzer createGetVerkaufteProdukteVonBenutzer() {
        return new GetVerkaufteProdukteVonBenutzer();
    }

    /**
     * Create an instance of {@link GetVerkaufteProdukteVonBenutzerResponse }
     * 
     */
    public GetVerkaufteProdukteVonBenutzerResponse createGetVerkaufteProdukteVonBenutzerResponse() {
        return new GetVerkaufteProdukteVonBenutzerResponse();
    }

    /**
     * Create an instance of {@link GetZumVerkaufStehendeProdukteVonBenutzer }
     * 
     */
    public GetZumVerkaufStehendeProdukteVonBenutzer createGetZumVerkaufStehendeProdukteVonBenutzer() {
        return new GetZumVerkaufStehendeProdukteVonBenutzer();
    }

    /**
     * Create an instance of {@link GetZumVerkaufStehendeProdukteVonBenutzerResponse }
     * 
     */
    public GetZumVerkaufStehendeProdukteVonBenutzerResponse createGetZumVerkaufStehendeProdukteVonBenutzerResponse() {
        return new GetZumVerkaufStehendeProdukteVonBenutzerResponse();
    }

    /**
     * Create an instance of {@link PasswortAendern }
     * 
     */
    public PasswortAendern createPasswortAendern() {
        return new PasswortAendern();
    }

    /**
     * Create an instance of {@link PasswortAendernResponse }
     * 
     */
    public PasswortAendernResponse createPasswortAendernResponse() {
        return new PasswortAendernResponse();
    }

    /**
     * Create an instance of {@link ProduktAendern }
     * 
     */
    public ProduktAendern createProduktAendern() {
        return new ProduktAendern();
    }

    /**
     * Create an instance of {@link ProduktAendernResponse }
     * 
     */
    public ProduktAendernResponse createProduktAendernResponse() {
        return new ProduktAendernResponse();
    }

    /**
     * Create an instance of {@link ProduktAnlegen }
     * 
     */
    public ProduktAnlegen createProduktAnlegen() {
        return new ProduktAnlegen();
    }

    /**
     * Create an instance of {@link ProduktAnlegenResponse }
     * 
     */
    public ProduktAnlegenResponse createProduktAnlegenResponse() {
        return new ProduktAnlegenResponse();
    }

    /**
     * Create an instance of {@link ProduktLoeschen }
     * 
     */
    public ProduktLoeschen createProduktLoeschen() {
        return new ProduktLoeschen();
    }

    /**
     * Create an instance of {@link ProduktLoeschenResponse }
     * 
     */
    public ProduktLoeschenResponse createProduktLoeschenResponse() {
        return new ProduktLoeschenResponse();
    }

    /**
     * Create an instance of {@link ProduktVerschieben }
     * 
     */
    public ProduktVerschieben createProduktVerschieben() {
        return new ProduktVerschieben();
    }

    /**
     * Create an instance of {@link ProduktVerschiebenResponse }
     * 
     */
    public ProduktVerschiebenResponse createProduktVerschiebenResponse() {
        return new ProduktVerschiebenResponse();
    }

    /**
     * Create an instance of {@link ProduktgruppeAendern }
     * 
     */
    public ProduktgruppeAendern createProduktgruppeAendern() {
        return new ProduktgruppeAendern();
    }

    /**
     * Create an instance of {@link ProduktgruppeAendernResponse }
     * 
     */
    public ProduktgruppeAendernResponse createProduktgruppeAendernResponse() {
        return new ProduktgruppeAendernResponse();
    }

    /**
     * Create an instance of {@link ProduktgruppeAnlegen }
     * 
     */
    public ProduktgruppeAnlegen createProduktgruppeAnlegen() {
        return new ProduktgruppeAnlegen();
    }

    /**
     * Create an instance of {@link ProduktgruppeAnlegenResponse }
     * 
     */
    public ProduktgruppeAnlegenResponse createProduktgruppeAnlegenResponse() {
        return new ProduktgruppeAnlegenResponse();
    }

    /**
     * Create an instance of {@link ProduktgruppeLoeschen }
     * 
     */
    public ProduktgruppeLoeschen createProduktgruppeLoeschen() {
        return new ProduktgruppeLoeschen();
    }

    /**
     * Create an instance of {@link ProduktgruppeLoeschenResponse }
     * 
     */
    public ProduktgruppeLoeschenResponse createProduktgruppeLoeschenResponse() {
        return new ProduktgruppeLoeschenResponse();
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
     * Create an instance of {@link SucheProdukt }
     * 
     */
    public SucheProdukt createSucheProdukt() {
        return new SucheProdukt();
    }

    /**
     * Create an instance of {@link SucheProduktResponse }
     * 
     */
    public SucheProduktResponse createSucheProduktResponse() {
        return new SucheProduktResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Benutzer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.soap/", name = "Benutzer")
    public JAXBElement<Benutzer> createBenutzer(Benutzer value) {
        return new JAXBElement<Benutzer>(_Benutzer_QNAME, Benutzer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Person }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.soap/", name = "Person")
    public JAXBElement<Person> createPerson(Person value) {
        return new JAXBElement<Person>(_Person_QNAME, Person.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Produkt }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.soap/", name = "Produkt")
    public JAXBElement<Produkt> createProdukt(Produkt value) {
        return new JAXBElement<Produkt>(_Produkt_QNAME, Produkt.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Produktgruppe }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.soap/", name = "Produktgruppe")
    public JAXBElement<Produktgruppe> createProduktgruppe(Produktgruppe value) {
        return new JAXBElement<Produktgruppe>(_Produktgruppe_QNAME, Produktgruppe.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AdminAnlegen }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.soap/", name = "adminAnlegen")
    public JAXBElement<AdminAnlegen> createAdminAnlegen(AdminAnlegen value) {
        return new JAXBElement<AdminAnlegen>(_AdminAnlegen_QNAME, AdminAnlegen.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AdminAnlegenResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.soap/", name = "adminAnlegenResponse")
    public JAXBElement<AdminAnlegenResponse> createAdminAnlegenResponse(AdminAnlegenResponse value) {
        return new JAXBElement<AdminAnlegenResponse>(_AdminAnlegenResponse_QNAME, AdminAnlegenResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AdressdatenAendern }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.soap/", name = "adressdatenAendern")
    public JAXBElement<AdressdatenAendern> createAdressdatenAendern(AdressdatenAendern value) {
        return new JAXBElement<AdressdatenAendern>(_AdressdatenAendern_QNAME, AdressdatenAendern.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AdressdatenAendernResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.soap/", name = "adressdatenAendernResponse")
    public JAXBElement<AdressdatenAendernResponse> createAdressdatenAendernResponse(AdressdatenAendernResponse value) {
        return new JAXBElement<AdressdatenAendernResponse>(_AdressdatenAendernResponse_QNAME, AdressdatenAendernResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BenutzerAnlegen }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.soap/", name = "benutzerAnlegen")
    public JAXBElement<BenutzerAnlegen> createBenutzerAnlegen(BenutzerAnlegen value) {
        return new JAXBElement<BenutzerAnlegen>(_BenutzerAnlegen_QNAME, BenutzerAnlegen.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BenutzerAnlegenResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.soap/", name = "benutzerAnlegenResponse")
    public JAXBElement<BenutzerAnlegenResponse> createBenutzerAnlegenResponse(BenutzerAnlegenResponse value) {
        return new JAXBElement<BenutzerAnlegenResponse>(_BenutzerAnlegenResponse_QNAME, BenutzerAnlegenResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BenutzerEinfAufheben }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.soap/", name = "benutzerEinfAufheben")
    public JAXBElement<BenutzerEinfAufheben> createBenutzerEinfAufheben(BenutzerEinfAufheben value) {
        return new JAXBElement<BenutzerEinfAufheben>(_BenutzerEinfAufheben_QNAME, BenutzerEinfAufheben.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BenutzerEinfAufhebenResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.soap/", name = "benutzerEinfAufhebenResponse")
    public JAXBElement<BenutzerEinfAufhebenResponse> createBenutzerEinfAufhebenResponse(BenutzerEinfAufhebenResponse value) {
        return new JAXBElement<BenutzerEinfAufhebenResponse>(_BenutzerEinfAufhebenResponse_QNAME, BenutzerEinfAufhebenResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BenutzerEinfrieren }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.soap/", name = "benutzerEinfrieren")
    public JAXBElement<BenutzerEinfrieren> createBenutzerEinfrieren(BenutzerEinfrieren value) {
        return new JAXBElement<BenutzerEinfrieren>(_BenutzerEinfrieren_QNAME, BenutzerEinfrieren.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BenutzerEinfrierenResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.soap/", name = "benutzerEinfrierenResponse")
    public JAXBElement<BenutzerEinfrierenResponse> createBenutzerEinfrierenResponse(BenutzerEinfrierenResponse value) {
        return new JAXBElement<BenutzerEinfrierenResponse>(_BenutzerEinfrierenResponse_QNAME, BenutzerEinfrierenResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Benutzerloeschen }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.soap/", name = "benutzerloeschen")
    public JAXBElement<Benutzerloeschen> createBenutzerloeschen(Benutzerloeschen value) {
        return new JAXBElement<Benutzerloeschen>(_Benutzerloeschen_QNAME, Benutzerloeschen.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BenutzerloeschenResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.soap/", name = "benutzerloeschenResponse")
    public JAXBElement<BenutzerloeschenResponse> createBenutzerloeschenResponse(BenutzerloeschenResponse value) {
        return new JAXBElement<BenutzerloeschenResponse>(_BenutzerloeschenResponse_QNAME, BenutzerloeschenResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GebotAbgeben }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.soap/", name = "gebotAbgeben")
    public JAXBElement<GebotAbgeben> createGebotAbgeben(GebotAbgeben value) {
        return new JAXBElement<GebotAbgeben>(_GebotAbgeben_QNAME, GebotAbgeben.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GebotAbgebenResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.soap/", name = "gebotAbgebenResponse")
    public JAXBElement<GebotAbgebenResponse> createGebotAbgebenResponse(GebotAbgebenResponse value) {
        return new JAXBElement<GebotAbgebenResponse>(_GebotAbgebenResponse_QNAME, GebotAbgebenResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GebotLoeschen }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.soap/", name = "gebotLoeschen")
    public JAXBElement<GebotLoeschen> createGebotLoeschen(GebotLoeschen value) {
        return new JAXBElement<GebotLoeschen>(_GebotLoeschen_QNAME, GebotLoeschen.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GebotLoeschenResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.soap/", name = "gebotLoeschenResponse")
    public JAXBElement<GebotLoeschenResponse> createGebotLoeschenResponse(GebotLoeschenResponse value) {
        return new JAXBElement<GebotLoeschenResponse>(_GebotLoeschenResponse_QNAME, GebotLoeschenResponse.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link GetGebotshistorieVonBenutzer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.soap/", name = "getGebotshistorieVonBenutzer")
    public JAXBElement<GetGebotshistorieVonBenutzer> createGetGebotshistorieVonBenutzer(GetGebotshistorieVonBenutzer value) {
        return new JAXBElement<GetGebotshistorieVonBenutzer>(_GetGebotshistorieVonBenutzer_QNAME, GetGebotshistorieVonBenutzer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetGebotshistorieVonBenutzerResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.soap/", name = "getGebotshistorieVonBenutzerResponse")
    public JAXBElement<GetGebotshistorieVonBenutzerResponse> createGetGebotshistorieVonBenutzerResponse(GetGebotshistorieVonBenutzerResponse value) {
        return new JAXBElement<GetGebotshistorieVonBenutzerResponse>(_GetGebotshistorieVonBenutzerResponse_QNAME, GetGebotshistorieVonBenutzerResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetPersonByUsername }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.soap/", name = "getPersonByUsername")
    public JAXBElement<GetPersonByUsername> createGetPersonByUsername(GetPersonByUsername value) {
        return new JAXBElement<GetPersonByUsername>(_GetPersonByUsername_QNAME, GetPersonByUsername.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetPersonByUsernameResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.soap/", name = "getPersonByUsernameResponse")
    public JAXBElement<GetPersonByUsernameResponse> createGetPersonByUsernameResponse(GetPersonByUsernameResponse value) {
        return new JAXBElement<GetPersonByUsernameResponse>(_GetPersonByUsernameResponse_QNAME, GetPersonByUsernameResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetProduktByID }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.soap/", name = "getProduktByID")
    public JAXBElement<GetProduktByID> createGetProduktByID(GetProduktByID value) {
        return new JAXBElement<GetProduktByID>(_GetProduktByID_QNAME, GetProduktByID.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetProduktByIDResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.soap/", name = "getProduktByIDResponse")
    public JAXBElement<GetProduktByIDResponse> createGetProduktByIDResponse(GetProduktByIDResponse value) {
        return new JAXBElement<GetProduktByIDResponse>(_GetProduktByIDResponse_QNAME, GetProduktByIDResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetProduktListe }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.soap/", name = "getProduktListe")
    public JAXBElement<GetProduktListe> createGetProduktListe(GetProduktListe value) {
        return new JAXBElement<GetProduktListe>(_GetProduktListe_QNAME, GetProduktListe.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetProduktListeResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.soap/", name = "getProduktListeResponse")
    public JAXBElement<GetProduktListeResponse> createGetProduktListeResponse(GetProduktListeResponse value) {
        return new JAXBElement<GetProduktListeResponse>(_GetProduktListeResponse_QNAME, GetProduktListeResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetProduktgruppeByName }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.soap/", name = "getProduktgruppeByName")
    public JAXBElement<GetProduktgruppeByName> createGetProduktgruppeByName(GetProduktgruppeByName value) {
        return new JAXBElement<GetProduktgruppeByName>(_GetProduktgruppeByName_QNAME, GetProduktgruppeByName.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetProduktgruppeByNameResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.soap/", name = "getProduktgruppeByNameResponse")
    public JAXBElement<GetProduktgruppeByNameResponse> createGetProduktgruppeByNameResponse(GetProduktgruppeByNameResponse value) {
        return new JAXBElement<GetProduktgruppeByNameResponse>(_GetProduktgruppeByNameResponse_QNAME, GetProduktgruppeByNameResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetProduktgruppeList }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.soap/", name = "getProduktgruppeList")
    public JAXBElement<GetProduktgruppeList> createGetProduktgruppeList(GetProduktgruppeList value) {
        return new JAXBElement<GetProduktgruppeList>(_GetProduktgruppeList_QNAME, GetProduktgruppeList.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetProduktgruppeListResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.soap/", name = "getProduktgruppeListResponse")
    public JAXBElement<GetProduktgruppeListResponse> createGetProduktgruppeListResponse(GetProduktgruppeListResponse value) {
        return new JAXBElement<GetProduktgruppeListResponse>(_GetProduktgruppeListResponse_QNAME, GetProduktgruppeListResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetVerkaufteProdukteVonBenutzer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.soap/", name = "getVerkaufteProdukteVonBenutzer")
    public JAXBElement<GetVerkaufteProdukteVonBenutzer> createGetVerkaufteProdukteVonBenutzer(GetVerkaufteProdukteVonBenutzer value) {
        return new JAXBElement<GetVerkaufteProdukteVonBenutzer>(_GetVerkaufteProdukteVonBenutzer_QNAME, GetVerkaufteProdukteVonBenutzer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetVerkaufteProdukteVonBenutzerResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.soap/", name = "getVerkaufteProdukteVonBenutzerResponse")
    public JAXBElement<GetVerkaufteProdukteVonBenutzerResponse> createGetVerkaufteProdukteVonBenutzerResponse(GetVerkaufteProdukteVonBenutzerResponse value) {
        return new JAXBElement<GetVerkaufteProdukteVonBenutzerResponse>(_GetVerkaufteProdukteVonBenutzerResponse_QNAME, GetVerkaufteProdukteVonBenutzerResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetZumVerkaufStehendeProdukteVonBenutzer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.soap/", name = "getZumVerkaufStehendeProdukteVonBenutzer")
    public JAXBElement<GetZumVerkaufStehendeProdukteVonBenutzer> createGetZumVerkaufStehendeProdukteVonBenutzer(GetZumVerkaufStehendeProdukteVonBenutzer value) {
        return new JAXBElement<GetZumVerkaufStehendeProdukteVonBenutzer>(_GetZumVerkaufStehendeProdukteVonBenutzer_QNAME, GetZumVerkaufStehendeProdukteVonBenutzer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetZumVerkaufStehendeProdukteVonBenutzerResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.soap/", name = "getZumVerkaufStehendeProdukteVonBenutzerResponse")
    public JAXBElement<GetZumVerkaufStehendeProdukteVonBenutzerResponse> createGetZumVerkaufStehendeProdukteVonBenutzerResponse(GetZumVerkaufStehendeProdukteVonBenutzerResponse value) {
        return new JAXBElement<GetZumVerkaufStehendeProdukteVonBenutzerResponse>(_GetZumVerkaufStehendeProdukteVonBenutzerResponse_QNAME, GetZumVerkaufStehendeProdukteVonBenutzerResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PasswortAendern }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.soap/", name = "passwortAendern")
    public JAXBElement<PasswortAendern> createPasswortAendern(PasswortAendern value) {
        return new JAXBElement<PasswortAendern>(_PasswortAendern_QNAME, PasswortAendern.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PasswortAendernResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.soap/", name = "passwortAendernResponse")
    public JAXBElement<PasswortAendernResponse> createPasswortAendernResponse(PasswortAendernResponse value) {
        return new JAXBElement<PasswortAendernResponse>(_PasswortAendernResponse_QNAME, PasswortAendernResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ProduktAendern }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.soap/", name = "produktAendern")
    public JAXBElement<ProduktAendern> createProduktAendern(ProduktAendern value) {
        return new JAXBElement<ProduktAendern>(_ProduktAendern_QNAME, ProduktAendern.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ProduktAendernResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.soap/", name = "produktAendernResponse")
    public JAXBElement<ProduktAendernResponse> createProduktAendernResponse(ProduktAendernResponse value) {
        return new JAXBElement<ProduktAendernResponse>(_ProduktAendernResponse_QNAME, ProduktAendernResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ProduktAnlegen }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.soap/", name = "produktAnlegen")
    public JAXBElement<ProduktAnlegen> createProduktAnlegen(ProduktAnlegen value) {
        return new JAXBElement<ProduktAnlegen>(_ProduktAnlegen_QNAME, ProduktAnlegen.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ProduktAnlegenResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.soap/", name = "produktAnlegenResponse")
    public JAXBElement<ProduktAnlegenResponse> createProduktAnlegenResponse(ProduktAnlegenResponse value) {
        return new JAXBElement<ProduktAnlegenResponse>(_ProduktAnlegenResponse_QNAME, ProduktAnlegenResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ProduktLoeschen }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.soap/", name = "produktLoeschen")
    public JAXBElement<ProduktLoeschen> createProduktLoeschen(ProduktLoeschen value) {
        return new JAXBElement<ProduktLoeschen>(_ProduktLoeschen_QNAME, ProduktLoeschen.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ProduktLoeschenResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.soap/", name = "produktLoeschenResponse")
    public JAXBElement<ProduktLoeschenResponse> createProduktLoeschenResponse(ProduktLoeschenResponse value) {
        return new JAXBElement<ProduktLoeschenResponse>(_ProduktLoeschenResponse_QNAME, ProduktLoeschenResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ProduktVerschieben }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.soap/", name = "produktVerschieben")
    public JAXBElement<ProduktVerschieben> createProduktVerschieben(ProduktVerschieben value) {
        return new JAXBElement<ProduktVerschieben>(_ProduktVerschieben_QNAME, ProduktVerschieben.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ProduktVerschiebenResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.soap/", name = "produktVerschiebenResponse")
    public JAXBElement<ProduktVerschiebenResponse> createProduktVerschiebenResponse(ProduktVerschiebenResponse value) {
        return new JAXBElement<ProduktVerschiebenResponse>(_ProduktVerschiebenResponse_QNAME, ProduktVerschiebenResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ProduktgruppeAendern }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.soap/", name = "produktgruppeAendern")
    public JAXBElement<ProduktgruppeAendern> createProduktgruppeAendern(ProduktgruppeAendern value) {
        return new JAXBElement<ProduktgruppeAendern>(_ProduktgruppeAendern_QNAME, ProduktgruppeAendern.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ProduktgruppeAendernResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.soap/", name = "produktgruppeAendernResponse")
    public JAXBElement<ProduktgruppeAendernResponse> createProduktgruppeAendernResponse(ProduktgruppeAendernResponse value) {
        return new JAXBElement<ProduktgruppeAendernResponse>(_ProduktgruppeAendernResponse_QNAME, ProduktgruppeAendernResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ProduktgruppeAnlegen }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.soap/", name = "produktgruppeAnlegen")
    public JAXBElement<ProduktgruppeAnlegen> createProduktgruppeAnlegen(ProduktgruppeAnlegen value) {
        return new JAXBElement<ProduktgruppeAnlegen>(_ProduktgruppeAnlegen_QNAME, ProduktgruppeAnlegen.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ProduktgruppeAnlegenResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.soap/", name = "produktgruppeAnlegenResponse")
    public JAXBElement<ProduktgruppeAnlegenResponse> createProduktgruppeAnlegenResponse(ProduktgruppeAnlegenResponse value) {
        return new JAXBElement<ProduktgruppeAnlegenResponse>(_ProduktgruppeAnlegenResponse_QNAME, ProduktgruppeAnlegenResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ProduktgruppeLoeschen }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.soap/", name = "produktgruppeLoeschen")
    public JAXBElement<ProduktgruppeLoeschen> createProduktgruppeLoeschen(ProduktgruppeLoeschen value) {
        return new JAXBElement<ProduktgruppeLoeschen>(_ProduktgruppeLoeschen_QNAME, ProduktgruppeLoeschen.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ProduktgruppeLoeschenResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.soap/", name = "produktgruppeLoeschenResponse")
    public JAXBElement<ProduktgruppeLoeschenResponse> createProduktgruppeLoeschenResponse(ProduktgruppeLoeschenResponse value) {
        return new JAXBElement<ProduktgruppeLoeschenResponse>(_ProduktgruppeLoeschenResponse_QNAME, ProduktgruppeLoeschenResponse.class, null, value);
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

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SucheProdukt }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.soap/", name = "sucheProdukt")
    public JAXBElement<SucheProdukt> createSucheProdukt(SucheProdukt value) {
        return new JAXBElement<SucheProdukt>(_SucheProdukt_QNAME, SucheProdukt.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SucheProduktResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://services.soap/", name = "sucheProduktResponse")
    public JAXBElement<SucheProduktResponse> createSucheProduktResponse(SucheProduktResponse value) {
        return new JAXBElement<SucheProduktResponse>(_SucheProduktResponse_QNAME, SucheProduktResponse.class, null, value);
    }

}
