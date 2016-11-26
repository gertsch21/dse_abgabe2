package soap.services;

import java.util.List;

import javax.jws.WebService;

import modell.Benutzer;

@WebService(name = "BenutzerservicesSEI", targetNamespace = "http://services.soap/")
public interface BenutzerservicesSEI {

	boolean pruefeLogin(String username, String password);

	List<Benutzer> getBenutzerliste();

}