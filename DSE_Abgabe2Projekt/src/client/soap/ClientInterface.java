package client.soap;

import java.util.List;

import client.soap.services.withoutTomcat.*;

/**
 * Dieses Interface ist die direkte Schnittstelle mit dem GUI. 
 * Hier wird festgelegt welche Methoden vom GUI aufgerufen werden können,
 * dies soll also eine Art Entkopplung sein, im Sinne einer Schichtenarchitektur
 *
 */
public interface ClientInterface {
	/**
	 * Diese Methode prüft den Login, also ob der Username mit dem Passwort zusammenpasst und ob 
	 * der User überhaupt gespeichert ist
	 * @param username Der Username des Users
	 * @param password Das Passwort des Users
	 * @return true, falls korrekt, false falls Username/passwort nicht zusammenpasst oder der User nicht vorhanden ist
	 */
	public boolean pruefeLogin(String username, String password);
	
	/**
	 * Diese Methode retourniert die Liste von Benutzern, welche gespeichert sind
	 * @return Die Liste aller Benutzer, als Benutzer-Objekte
	 */
	public List<Benutzer> getBenutzerListe();
}
