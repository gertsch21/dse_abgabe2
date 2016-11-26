package soap.services;

import java.util.List;

import javax.jws.WebService;

import management.Benutzerverwaltung;
import modell.Benutzer;

@WebService(targetNamespace = "http://services.soap/", endpointInterface = "soap.services.BenutzerservicesSEI", portName = "BenutzerservicesPort", serviceName = "BenutzerservicesService")
public class Benutzerservices implements BenutzerservicesSEI {
	public boolean pruefeLogin(String username, String password){
		return Benutzerverwaltung.getInstance().pruefeLogin(username, password);
	}
	public List<Benutzer> getBenutzerliste(){
		return Benutzerverwaltung.getInstance().getBenutzerListe();
	}
}
