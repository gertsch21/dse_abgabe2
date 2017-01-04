/**
 * Das Package Management beinhaltet Klassen die zu Verwaltung der Akteure benoetigt werden
 */
package management;

import java.util.List;

import dao.ProduktgruppeDAO;
import dao.SerializedProduktgruppeDAO;
import modell.Produktgruppe;


/**
 * @author Josef
 * 
 * Klasse Produktgruppeverwaltung verwaltet das Anlegen und Loeschen von Produktgruppen
 *
 */
public class Produktgruppeverwaltung {

	private static Produktgruppeverwaltung ProduktgruppeverwaltungInstance=null;
	private ProduktgruppeDAO dao;
	
	private Produktgruppeverwaltung(){
		dao = new SerializedProduktgruppeDAO();
	}
	
	/**
	 * @return gibt das Objekt ProduktgruppeverwaltungInstance (Produktgruppeverwaltung), 
	 * wenn noch keines vorhanden wird eines erzeugt.
	 */
	public static Produktgruppeverwaltung getinstance(){
		if(ProduktgruppeverwaltungInstance == null) ProduktgruppeverwaltungInstance = new Produktgruppeverwaltung();
		return ProduktgruppeverwaltungInstance;
	}
	
	/**
	 * 
	 * @param name ist der neue Produktgruppename der angelegt wird
	 * @return true wenn die neue Produktgruppe angelegt ist,
	 * @return false wenn die neue Produktgruppe einen Fehler hat
	 */
	public boolean produktgruppeAnlegen( String name ){
		
		List<Produktgruppe> liste = dao.getProduktgruppeList();

		for(Produktgruppe x: liste){
			if(x.getName().equals(name)){
				return false;
			}
		}
		
		Produktgruppe neueProduktgruppe = new Produktgruppe(name);
		return dao.produktgruppeAnlegen(neueProduktgruppe);
	}
	/**
	 * ACHTUNG: Produktgruppe MUSS leer sein
	 * @param name ist der gesuchte Produktgruppename, der geloescht werden soll
	 * @return true wenn das Loeschen von der Produktgruppe erfolgreich war, false falls nicht
	 */
	public boolean produktgruppeLoeschen( String name ){
	
		List<Produktgruppe> liste = dao.getProduktgruppeList();

		for(Produktgruppe x: liste){
			if(x.getName().equals(name)){
				return dao.produktgruppeLoeschen(name);
			}
		}
		return false;	
	}
	
	
	/**
	 * Diese Methode gibt die Produktgruppenliste zurueck
	 * @return Retourniert die eine Liste aller Produktgruppen
	 */
	public List<Produktgruppe> getProduktgruppeList(){
		return dao.getProduktgruppeList();
	}

	
	/**
	 * Diese Methode gibt die zu suchende Produktgruppe zurueck(oder null)
	 * @param name
	 * @return Retourniert die gewuenschte Produktgruppe, falls vorhanden, sonst null
	 */
	public Produktgruppe getProduktgruppeByName(String name){
		return dao.getProduktgruppeByName(name);
	}
	
	
	/**
	 * Mit dieser Methode wird die Produktgruppe geaendert(da wir nur den Namen haben, wird dieser geaendert)
	 * @param alterName bisheriger Name
	 * @param neuerName zukuenftiger Name
	 * @return true wenn erfolgreich war, false falls nicht
	 */
	public boolean produktgruppeAendern(String alterName, String neuerName){
		if(neuerName.length() == 0) return false;
		return dao.produktgruppeAendern(alterName, neuerName);
	}
	
}
