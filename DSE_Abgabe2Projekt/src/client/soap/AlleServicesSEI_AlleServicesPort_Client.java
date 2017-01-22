
package client.soap;

/**
 * Please modify this class to meet your needs
 * This class is not complete
 */

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 3.1.8
 * 2017-01-21T22:21:36.720+01:00
 * Generated source version: 3.1.8
 * 
 */
public final class AlleServicesSEI_AlleServicesPort_Client {

    private static final QName SERVICE_NAME = new QName("http://services.soap/", "AlleServicesService");

    private AlleServicesSEI_AlleServicesPort_Client() {
    }

    public static void main(String args[]) throws java.lang.Exception {
        URL wsdlURL = AlleServicesService.WSDL_LOCATION;
        if (args.length > 0 && args[0] != null && !"".equals(args[0])) { 
            File wsdlFile = new File(args[0]);
            try {
                if (wsdlFile.exists()) {
                    wsdlURL = wsdlFile.toURI().toURL();
                } else {
                    wsdlURL = new URL(args[0]);
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }
      
        AlleServicesService ss = new AlleServicesService(wsdlURL, SERVICE_NAME);
        AlleServicesSEI port = ss.getAlleServicesPort();  
        
        {
        System.out.println("Invoking pruefeLogin...");
        java.lang.String _pruefeLogin_arg0 = "";
        java.lang.String _pruefeLogin_arg1 = "";
        boolean _pruefeLogin__return = port.pruefeLogin(_pruefeLogin_arg0, _pruefeLogin_arg1);
        System.out.println("pruefeLogin.result=" + _pruefeLogin__return);


        }
        {
        System.out.println("Invoking benutzerAnlegen...");
        java.lang.String _benutzerAnlegen_arg0 = "";
        java.lang.String _benutzerAnlegen_arg1 = "";
        java.lang.String _benutzerAnlegen_arg2 = "";
        int _benutzerAnlegen_arg3 = 0;
        java.lang.String _benutzerAnlegen_arg4 = "";
        java.lang.String _benutzerAnlegen_arg5 = "";
        int _benutzerAnlegen_arg6 = 0;
        java.lang.String _benutzerAnlegen_arg7 = "";
        java.lang.String _benutzerAnlegen_arg8 = "";
        boolean _benutzerAnlegen__return = port.benutzerAnlegen(_benutzerAnlegen_arg0, _benutzerAnlegen_arg1, _benutzerAnlegen_arg2, _benutzerAnlegen_arg3, _benutzerAnlegen_arg4, _benutzerAnlegen_arg5, _benutzerAnlegen_arg6, _benutzerAnlegen_arg7, _benutzerAnlegen_arg8);
        System.out.println("benutzerAnlegen.result=" + _benutzerAnlegen__return);


        }
        {
        System.out.println("Invoking benutzerloeschen...");
        java.lang.String _benutzerloeschen_arg0 = "";
        boolean _benutzerloeschen__return = port.benutzerloeschen(_benutzerloeschen_arg0);
        System.out.println("benutzerloeschen.result=" + _benutzerloeschen__return);


        }
        {
        System.out.println("Invoking getProduktgruppeByName...");
        java.lang.String _getProduktgruppeByName_arg0 = "";
        client.soap.Produktgruppe _getProduktgruppeByName__return = port.getProduktgruppeByName(_getProduktgruppeByName_arg0);
        System.out.println("getProduktgruppeByName.result=" + _getProduktgruppeByName__return);


        }
        {
        System.out.println("Invoking getPersonByUsername...");
        java.lang.String _getPersonByUsername_arg0 = "";
        client.soap.Person _getPersonByUsername__return = port.getPersonByUsername(_getPersonByUsername_arg0);
        System.out.println("getPersonByUsername.result=" + _getPersonByUsername__return);


        }
        {
        System.out.println("Invoking benutzerEinfAufheben...");
        java.lang.String _benutzerEinfAufheben_arg0 = "";
        boolean _benutzerEinfAufheben__return = port.benutzerEinfAufheben(_benutzerEinfAufheben_arg0);
        System.out.println("benutzerEinfAufheben.result=" + _benutzerEinfAufheben__return);


        }
        {
        System.out.println("Invoking benutzerEinfrieren...");
        java.lang.String _benutzerEinfrieren_arg0 = "";
        boolean _benutzerEinfrieren__return = port.benutzerEinfrieren(_benutzerEinfrieren_arg0);
        System.out.println("benutzerEinfrieren.result=" + _benutzerEinfrieren__return);


        }
        {
        System.out.println("Invoking getProduktByID...");
        java.lang.String _getProduktByID_arg0 = "";
        client.soap.Produkt _getProduktByID__return = port.getProduktByID(_getProduktByID_arg0);
        System.out.println("getProduktByID.result=" + _getProduktByID__return);


        }
        {
        System.out.println("Invoking adminAnlegen...");
        java.lang.String _adminAnlegen_arg0 = "";
        java.lang.String _adminAnlegen_arg1 = "";
        java.lang.String _adminAnlegen_arg2 = "";
        int _adminAnlegen_arg3 = 0;
        java.lang.String _adminAnlegen_arg4 = "";
        java.lang.String _adminAnlegen_arg5 = "";
        int _adminAnlegen_arg6 = 0;
        java.lang.String _adminAnlegen_arg7 = "";
        java.lang.String _adminAnlegen_arg8 = "";
        double _adminAnlegen_arg9 = 0.0;
        boolean _adminAnlegen__return = port.adminAnlegen(_adminAnlegen_arg0, _adminAnlegen_arg1, _adminAnlegen_arg2, _adminAnlegen_arg3, _adminAnlegen_arg4, _adminAnlegen_arg5, _adminAnlegen_arg6, _adminAnlegen_arg7, _adminAnlegen_arg8, _adminAnlegen_arg9);
        System.out.println("adminAnlegen.result=" + _adminAnlegen__return);


        }
        {
        System.out.println("Invoking gebotAbgeben...");
        java.lang.String _gebotAbgeben_arg0 = "";
        double _gebotAbgeben_arg1 = 0.0;
        java.lang.String _gebotAbgeben_arg2 = "";
        boolean _gebotAbgeben__return = port.gebotAbgeben(_gebotAbgeben_arg0, _gebotAbgeben_arg1, _gebotAbgeben_arg2);
        System.out.println("gebotAbgeben.result=" + _gebotAbgeben__return);


        }
        {
        System.out.println("Invoking getProduktgruppeList...");
        java.util.List<client.soap.Produktgruppe> _getProduktgruppeList__return = port.getProduktgruppeList();
        System.out.println("getProduktgruppeList.result=" + _getProduktgruppeList__return);


        }
        {
        System.out.println("Invoking adressdatenAendern...");
        java.lang.String _adressdatenAendern_arg0 = "";
        int _adressdatenAendern_arg1 = 0;
        java.lang.String _adressdatenAendern_arg2 = "";
        java.lang.String _adressdatenAendern_arg3 = "";
        int _adressdatenAendern_arg4 = 0;
        boolean _adressdatenAendern__return = port.adressdatenAendern(_adressdatenAendern_arg0, _adressdatenAendern_arg1, _adressdatenAendern_arg2, _adressdatenAendern_arg3, _adressdatenAendern_arg4);
        System.out.println("adressdatenAendern.result=" + _adressdatenAendern__return);


        }
        {
        System.out.println("Invoking getProduktListe...");
        java.util.List<client.soap.Produkt> _getProduktListe__return = port.getProduktListe();
        System.out.println("getProduktListe.result=" + _getProduktListe__return);


        }
        {
        System.out.println("Invoking getVerkaufteProdukteVonBenutzer...");
        java.lang.String _getVerkaufteProdukteVonBenutzer_arg0 = "";
        java.util.List<client.soap.Produkt> _getVerkaufteProdukteVonBenutzer__return = port.getVerkaufteProdukteVonBenutzer(_getVerkaufteProdukteVonBenutzer_arg0);
        System.out.println("getVerkaufteProdukteVonBenutzer.result=" + _getVerkaufteProdukteVonBenutzer__return);


        }
        {
        System.out.println("Invoking produktAendern...");
        java.lang.String _produktAendern_arg0 = "";
        java.lang.String _produktAendern_arg1 = "";
        double _produktAendern_arg2 = 0.0;
        java.lang.String _produktAendern_arg3 = "";
        java.lang.String _produktAendern_arg4 = "";
        int _produktAendern_arg5 = 0;
        java.lang.String _produktAendern_arg6 = "";
        boolean _produktAendern__return = port.produktAendern(_produktAendern_arg0, _produktAendern_arg1, _produktAendern_arg2, _produktAendern_arg3, _produktAendern_arg4, _produktAendern_arg5, _produktAendern_arg6);
        System.out.println("produktAendern.result=" + _produktAendern__return);


        }
        {
        System.out.println("Invoking produktgruppeAnlegen...");
        java.lang.String _produktgruppeAnlegen_arg0 = "";
        boolean _produktgruppeAnlegen__return = port.produktgruppeAnlegen(_produktgruppeAnlegen_arg0);
        System.out.println("produktgruppeAnlegen.result=" + _produktgruppeAnlegen__return);


        }
        {
        System.out.println("Invoking produktgruppeLoeschen...");
        java.lang.String _produktgruppeLoeschen_arg0 = "";
        boolean _produktgruppeLoeschen__return = port.produktgruppeLoeschen(_produktgruppeLoeschen_arg0);
        System.out.println("produktgruppeLoeschen.result=" + _produktgruppeLoeschen__return);


        }
        {
        System.out.println("Invoking produktVerschieben...");
        java.lang.String _produktVerschieben_arg0 = "";
        java.lang.String _produktVerschieben_arg1 = "";
        boolean _produktVerschieben__return = port.produktVerschieben(_produktVerschieben_arg0, _produktVerschieben_arg1);
        System.out.println("produktVerschieben.result=" + _produktVerschieben__return);


        }
        {
        System.out.println("Invoking sucheProdukt...");
        java.lang.String _sucheProdukt_arg0 = "";
        java.util.List<client.soap.Produkt> _sucheProdukt__return = port.sucheProdukt(_sucheProdukt_arg0);
        System.out.println("sucheProdukt.result=" + _sucheProdukt__return);


        }
        {
        System.out.println("Invoking produktgruppeAendern...");
        java.lang.String _produktgruppeAendern_arg0 = "";
        java.lang.String _produktgruppeAendern_arg1 = "";
        boolean _produktgruppeAendern__return = port.produktgruppeAendern(_produktgruppeAendern_arg0, _produktgruppeAendern_arg1);
        System.out.println("produktgruppeAendern.result=" + _produktgruppeAendern__return);


        }
        {
        System.out.println("Invoking getBenutzerliste...");
        java.util.List<client.soap.Benutzer> _getBenutzerliste__return = port.getBenutzerliste();
        System.out.println("getBenutzerliste.result=" + _getBenutzerliste__return);


        }
        {
        System.out.println("Invoking gebotLoeschen...");
        java.lang.String _gebotLoeschen_arg0 = "";
        boolean _gebotLoeschen__return = port.gebotLoeschen(_gebotLoeschen_arg0);
        System.out.println("gebotLoeschen.result=" + _gebotLoeschen__return);


        }
        {
        System.out.println("Invoking passwortAendern...");
        java.lang.String _passwortAendern_arg0 = "";
        java.lang.String _passwortAendern_arg1 = "";
        boolean _passwortAendern__return = port.passwortAendern(_passwortAendern_arg0, _passwortAendern_arg1);
        System.out.println("passwortAendern.result=" + _passwortAendern__return);


        }
        {
        System.out.println("Invoking getZumVerkaufStehendeProdukteVonBenutzer...");
        java.lang.String _getZumVerkaufStehendeProdukteVonBenutzer_arg0 = "";
        java.util.List<client.soap.Produkt> _getZumVerkaufStehendeProdukteVonBenutzer__return = port.getZumVerkaufStehendeProdukteVonBenutzer(_getZumVerkaufStehendeProdukteVonBenutzer_arg0);
        System.out.println("getZumVerkaufStehendeProdukteVonBenutzer.result=" + _getZumVerkaufStehendeProdukteVonBenutzer__return);


        }
        {
        System.out.println("Invoking produktLoeschen...");
        java.lang.String _produktLoeschen_arg0 = "";
        boolean _produktLoeschen__return = port.produktLoeschen(_produktLoeschen_arg0);
        System.out.println("produktLoeschen.result=" + _produktLoeschen__return);


        }
        {
        System.out.println("Invoking getGebotshistorieVonBenutzer...");
        java.lang.String _getGebotshistorieVonBenutzer_arg0 = "";
        java.util.List<client.soap.Produkt> _getGebotshistorieVonBenutzer__return = port.getGebotshistorieVonBenutzer(_getGebotshistorieVonBenutzer_arg0);
        System.out.println("getGebotshistorieVonBenutzer.result=" + _getGebotshistorieVonBenutzer__return);


        }
        {
        System.out.println("Invoking produktAnlegen...");
        java.lang.String _produktAnlegen_arg0 = "";
        double _produktAnlegen_arg1 = 0.0;
        java.lang.String _produktAnlegen_arg2 = "";
        java.lang.String _produktAnlegen_arg3 = "";
        int _produktAnlegen_arg4 = 0;
        java.lang.String _produktAnlegen_arg5 = "";
        boolean _produktAnlegen__return = port.produktAnlegen(_produktAnlegen_arg0, _produktAnlegen_arg1, _produktAnlegen_arg2, _produktAnlegen_arg3, _produktAnlegen_arg4, _produktAnlegen_arg5);
        System.out.println("produktAnlegen.result=" + _produktAnlegen__return);


        }

        System.exit(0);
    }

}