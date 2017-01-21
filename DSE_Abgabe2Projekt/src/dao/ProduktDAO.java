/**
 *Das Paket dient zum persistenten speichern der Benutzer und Produktdaten um spaeter 
 *wieder darauf zugreifen zu koennen.
 * 
 */

package dao;

import java.util.List;
import java.util.UUID;

import modell.Produkt;

/**
 *Dieses Interface definiert Methoden des Entwurfsmusters DAO zur Erstellung persistenter Produktobjekte 
 *Diese Klasse ermoeglicht es, auf Daten zuzugreifen.
 */


public interface ProduktDAO{
	
	/**
	 * Diese Methode liefert eine Liste von Produkten 
	 * @return
	 */
	List<Produkt> getProduktList();
	/**
	 * 
     * Diese Methode lifert ein Objekt eines Produktes mit der eindeutigen Id zurueck
     *  @param id ist eine ProduktId ,die bereits existiert 
	 *  @return ein Objekt von der Klasse Produkt
	 */
	
	Produkt getProduktByID(String id);
	/**
	 * In dieser Methode wird ein Objekt von der Klasse Produkt gespeichert
	 * @param newProdukt ist ein Objekt von der Klasse Produkt das persistent gespeichert wird
	 * @return true wenn das Objekt korrekt gespeichert ist,false falls nicht
	 */
	
	boolean produktAnlegen(Produkt newProdukt);
	/**
	 * In dieser Methode wird ein Objekt von der Klasse Produkt geloescht
	 * @param deleteID ist eine existierende ProduktId, die uebergeben wird um das Produkt
	 * aus der Produkt Liste zu loeschen
	 * @return true wenn das Objekt korrekt geloescht ist ,false falls nicht
	 */
	boolean produktLoeschen(String deleteID);
	
	
	/**
	 * @param id entspricht dem zu verschiebenden Produkt
	 * @param kategorie entspricht der Kategorie in die das Produkt verschoben wird
	 * @return true oder false je nach dem ob das Produkt erfolgreich neu angelegt wird oder nicht.
	 */
	public boolean produktVerschieben(UUID id,String kategorie);
	
	/**
	 * Diese Methode ist dafuer da, dass es bei einem neuen Gebot den Bieter aktualisiert, sowie
	 * das Gebot
	 * @param produktID Die ID des zu aendernden Produktes
	 * @param username Der neue Hoechstbietende
	 * @param gebot Das neue Gebot
	 * @return
	 */
	boolean produktBekommtNeuesGebot(String produktID, String username, double gebot);
	
}
