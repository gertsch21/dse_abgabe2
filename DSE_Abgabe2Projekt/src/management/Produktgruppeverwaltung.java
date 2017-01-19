/**
 * Das Package Management beinhaltet Klassen die zu Verwaltung der Akteure benoetigt werden
 */
package management;

import java.util.List;

import dao.ProduktgruppeDAO;
import dao.SerializedProduktgruppeDAOHibernate;
import modell.Produktgruppe;


/**
 * 
 * Klasse Produktgruppeverwaltung verwaltet das Anlegen und Loeschen von Produktgruppen
 *
 */
public class Produktgruppeverwaltung {

	private static Produktgruppeverwaltung ProduktgruppeverwaltungInstance=null;
	private ProduktgruppeDAO dao;
	
	private Produktgruppeverwaltung(){
		dao = new SerializedProduktgruppeDAOHibernate();
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
		if(name.trim().length()==0 || name.trim().length()!=name.length()){
			System.err.println("Produktgruppeverwaltung:produktgruppeLoeschen: Der Name('"+name+"') ist leer oder enthaelt Leerzeichen!");
			return false;
		}
		if(dao.getProduktgruppeByName(name)==null){
			System.err.println("Produktgruppeverwaltung:produktgruppeLoeschen: Die Produktgruppe('"+name+"') existiert nicht!");			
			return false;
		}
		if(dao.getProduktgruppeByName(name).getListe().size() != 0){
			System.err.println("Produktgruppeverwaltung:produktgruppeLoeschen: Die Produktgruppe('"+name+"') muss LEER sein, ist es aber nicht, enthaltene Produkte: "+dao.getProduktgruppeByName(name).getListe()+"!");			
			return false;
		}
		
		return dao.produktgruppeLoeschen(name);	
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
