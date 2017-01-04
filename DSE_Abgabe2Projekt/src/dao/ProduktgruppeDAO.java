/**
*	Das Packet dient zum persistenten speichern der Benutzer und Produktdaten um spaeter 
*	wieder darauf zugreifen zu koennen.
 * 
 */

package dao;

import java.util.List;
import modell.Produktgruppe;

/**
 *Dieses Interface definiert Methoden des Entwurfsmusters DAO zur Erstellung persistenter Produktgruppeobjekte 
 *Diese Klasse erm�glicht es, auf Daten zuzugreifen.
 */


public interface ProduktgruppeDAO {
	
	/**
	 * Diese Methode liefert eine Liste von allen angelegten Produktgruppen
	 * @return
	 */
	public List<Produktgruppe> getProduktgruppeList();
	
	
	/**
	 * In dieser Methode wird eine Produktgruppe Liste mit existierten Namen zurueckgeliefert 
	 * @param name ist ein existirender Name, der uebergeben wird um die gesuchte
	 *  Produktgruppe zurueckzuliefern. 
	 * @return 
	 */
	public Produktgruppe getProduktgruppeByName(String name);
	
	
	/**
	 * In dieser Methode wird eine neue Produktgruppe persistent angelegt
	 * @param newProduktgruppe ist ein Objekt, das persistent in einer Produktgruppe Liste angelegt wird 
	 * @return true wenn das Objekt korrekt angelegt ist,
	 * false falls nicht
	 */
	public boolean produktgruppeAnlegen(Produktgruppe newProduktgruppe);
	
	
	/**
	 * In diesesr Methode wird ein existierendes Objekt aus der Produktgruppe Liste geloescht(geht nur, WENN diese LEER ist!!)
	 * 
	 * @param name ist ein existierender Name, der uebergeben wird um die gesuchte Produktgruppe 
	 * zu loeschen.
	 * @return true wenn das Objekt geloescht ist ,
	 * flase falls nicht
	 */
	public boolean produktgruppeLoeschen(String name);
	
	
	
	
	
	/**
	 * Mit dieser Methode wird die Produktgruppe geaendert(da wir nur den Namen haben, wird dieser geaendert)
	 * @param alterName bisheriger Name
	 * @param neuerName zukuenftiger Name
	 * @return true wenn erfolgreich war, false falls nicht
	 */
	public boolean produktgruppeAendern(String alterName, String neuerName);

}
