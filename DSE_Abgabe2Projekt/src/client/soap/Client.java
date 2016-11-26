package client.soap;

import java.net.URL;
import java.util.List;

import javax.xml.namespace.QName;

import client.soap.services.Benutzer;
import client.soap.services.BenutzerservicesSEI;
import client.soap.services.BenutzerservicesService;

public class Client implements ClientInterface {

	private static final QName SERVICE_NAME = new QName("http://services.soap/", "BenutzerservicesService");
	
	private BenutzerservicesService ss;
    private BenutzerservicesSEI port;   
    private static final URL wsdlURL = BenutzerservicesService.WSDL_LOCATION;
    
	public Client() {
		this.ss = new BenutzerservicesService(wsdlURL, SERVICE_NAME);
		this.port = ss.getBenutzerservicesPort();
    }

      
	/**
	 * 
	 * 
	 * @param username Der zu pruefende Username
	 * @param password Das zu pruefende Passwort
	 * @return Falls korrekt true, sonst false
	 */
	public boolean pruefeLogin(String username, String password){
		return this.port.pruefeLogin(username, password);
	}
	
	/**
	 * 
	 * @return
	 */
	public List<Benutzer> getBenutzerListe(){
		return port.getBenutzerliste();
	}
   

	
}
