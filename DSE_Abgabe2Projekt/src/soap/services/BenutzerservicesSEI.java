package soap.services;

import java.util.List;

import javax.jws.WebService;

import modell.Benutzer;

/**
 * 
 * Dieses Interface gibt die Services an, welche �ber den Server erreicht werden k�nnen
 *
 */
@WebService(name = "BenutzerservicesSEI", targetNamespace = "http://services.soap/")
public interface BenutzerservicesSEI {

	/**
	 * Diese Methode pr�ft den Login, also ob der Username mit dem Passwort zusammenpasst und ob 
	 * der User �berhaupt gespeichert ist
	 * @param username Der Username des Users
	 * @param password Das Passwort des Users
	 * @return true, falls korrekt, false falls Username/passwort nicht zusammenpasst oder der User nicht vorhanden ist
	 */
	boolean pruefeLogin(String username, String password);

	/**
	 * Diese Methode retourniert die Liste von Benutzern, welche gespeichert sind
	 * @return Die Liste aller Benutzer, als Benutzer-Objekte
	 */
	List<Benutzer> getBenutzerliste();

}