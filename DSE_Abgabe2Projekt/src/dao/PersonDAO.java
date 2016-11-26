/**
*	Das Paket dient zum persistenten Speichern der Benutzer und Produktdaten um spaeter 
*	wieder darauf zugreifen zu koennen.
 */
package dao;

import java.util.List;
import modell.Benutzer;
import modell.Person;

public interface PersonDAO {

	/**
	 *Wenn keine Liste enthalten ist, wird eine leere Liste erstellt und
	 * diese zurückgegeben!
	 * 
	 * @return Die Liste der gespeicherten Person.
	 */
	List<Person> getPersonList();

	/**
	 *Wenn keine Liste enthalten ist,wird eine leere Liste erstellt und
	 * diese zurückgegeben!
	 * 
	 * @return Die Liste der gespeicherten Benutzer.
	 */
	List<Benutzer> getBenutzerList();

	
	/**
	 * 
	 * @param id Anhand der eindeutigen ID wird die Person gesucht.
	 * @return Die gefundene Person wird zurückgegeben, oder null wird zurückgeliefert.
	 */
	Person getPersonById(String id);
	
	/**
	 * 
	 * @param username Anhand diesem eindeutigen Parameter wird die Person gesucht.
	 * @return Die gefundene Person wird zurückgegeben, oder null.
	 */
	Person getPersonByUsername(String username);

	/**
	 * 
	 * @param benutzer Die zu speichernde Person.
	 * @return true, falls Vorgang erfolgreich, andernfalls false.
	 */
	boolean speicherePerson(Person benutzer);

	/**
	 * 
	 * @param benutzer Die Id der zu löschenden Person als String.
	 * @return true, falls Vorgang erfolgreich, andernfalls false.
	 */
	boolean loeschePerson(String benutzer);

	/**
	 * 
	 * @param benutzer Der Username der einzufrierenden Person als String.
	 * @return true, falls Vorgang erfolgreich, andernfalls false.
	 */
	boolean einfrierenPerson(String benutzer);
	
	/**
	 * 
	 * @param benutzer Der Username der einzufrierenden Person als String.
	 * @return true, falls Vorgang erfolgreich, andernfalls false.
	 */
	boolean einfrierenAufheben(String benutzer);
	
}