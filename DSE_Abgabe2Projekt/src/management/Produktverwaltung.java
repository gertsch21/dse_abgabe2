/**Das Package Management beinhaltet Klassen die zu Verwaltung der Akteure benoetigt werden
 *  
 * 
 */
package management;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import modell.Person;
import modell.Produkt;
import modell.Produktgruppe;
import dao.ProduktDAO;
import dao.SerializedProduktDAO;
import dao.SerializedProduktDAOHibernate;
import dao.PersonDAO;
import dao.SerializedPersonDAO;

/**
 * 
 * Klasse Produktverwaltung verwaltet alle Methoden mit dem Produkt in Verbindung stehen.
 *
 */
public class Produktverwaltung {
	
	private static Produktverwaltung produktverwaltungInstance=null;
	private ProduktDAO dao;
	
	private Produktverwaltung(){
		dao = new SerializedProduktDAOHibernate();
	}
	
	/**
	 * @return gibt das Objekt produktverwaltungInstance (Produktverwaltung),
	 *  wenn noch keines vorhanden wird eines erzeugt.
	 */
	public static Produktverwaltung getinstance(){
		if(produktverwaltungInstance == null) produktverwaltungInstance = new Produktverwaltung();
		return produktverwaltungInstance;
		
	}
	
	
	/**
	 * Diese Methode retourniert das Produkt mit der gegebenen ProduktID
	 * @param produktID ID des zu suchenden Produktes
	 * @return Das Produkt falls vorhanden, falls nicht, dann null
	 */
	public Produkt getProduktByID(String produktID){
		return dao.getProduktByID(produktID);
	}
	
	
	/**
	 * @param name ist der Name des Produkt
	 * @param startpreis ist der Anfangspreis des Produkts
	 * @param Uname ist der Username des Besitzers
	 * @return dao.produktAnlegen() oder false
	 */
	public boolean produktAnlegen( String name, double startpreis, String Uname, String kategorie, int dauer, String beschreibung){
		
		boolean produktgruppeVorhanden = false;
		PersonDAO daoP = new SerializedPersonDAO();
		List<Person> personListe = daoP.getPersonList();
		
		//pruefen ob Kategorie existiert
		for(Produktgruppe pg : Produktgruppeverwaltung.getinstance().getProduktgruppeList())
			if(kategorie.equals(pg.getName())){
				produktgruppeVorhanden = true;
				break;
			}
		if(!produktgruppeVorhanden){
			System.out.println("Error: (produktAnlegen()) : No matching Produktgruppe was found.");
			return false;
		}
	
		
		//pruefen ob Person vorhanden
		for(Person x:personListe){
			if(x.getUsername().equals(Uname)){
				System.out.println("username: " + Uname);
				
				UUID id=UUID.randomUUID();
				return dao.produktAnlegen(new Produkt(id, name, startpreis, Uname, kategorie, dauer, beschreibung));
			}
		}
		System.out.println("Error: (produktAnlegen()) : No matching Username was found.");
		return false;
		
	}
	
	/**
	 * @param parameter ist der vom User übergebene Parameter zur produktsuche(muss im NAMEN des Produkts enthalten sein!!)
	 * @return Liste der gefundenen Produkte
	 */
	public List<Produkt> sucheProdukt(String parameter){
		
		List<Produkt> alleProdukte = dao.getProduktList();
		List<Produkt> gefundeneProdukte = new ArrayList<Produkt>();
		
		if(alleProdukte.size() == 0){
			return alleProdukte;
		}
		
		for(Produkt x: alleProdukte){
			if(x.getName().contains(parameter)){
				gefundeneProdukte.add(x);
			}
		}
		return gefundeneProdukte;	
	}
	
	/**
	 * @param id ist die aus der Produkt Lise zu löschende ID für das jeweilige Produkt
	 * @return gibt eine Funktion mit der id als Parameter an das ProduktDAO weiter zum löschen
	 */
	public boolean produktLoeschen(String id){
		System.out.println("Produktverwaltung: produktLoeschen: Delete : " + id);
		return this.dao.produktLoeschen(id);
	}
	
	/**
	 * @param id entspricht dem zu verschiebenden Produkt
	 * @param kategorie entspricht der Kategorie in die das Produkt verschoben wird
	 * @return true oder false je nach dem ob das Produkt erfolgreich neu angelegt wird oder nicht.
	 */
	public boolean produktVerschieben(UUID id,String kategorie){
		return dao.produktVerschieben(id, kategorie);
	}
	
	public boolean produktAendern(UUID id, String name, double startpreis, String Uname, String kategorie, int dauer, String beschreibung){
		
		if(id==null || name==null || Uname==null || kategorie==null || beschreibung==null)
			return false;
		
		Produkt p = dao.getProduktByID( id.toString() );
		Produkt a = p;
		
		if(p == null){
			System.out.println("Error:produktAendern: mit dieser id gibt es kein Produkt!");
			return false;
		}
		
		if(Benutzerverwaltung.getInstance().getPersonByUsername(Uname)==null){
			System.out.println("Error:produktAendern: mit dieser id gibt es kein Produkt!");
			return false;
		}
		
		if(Produktgruppeverwaltung.getinstance().getProduktgruppeByName(kategorie) == null){
			System.out.println("Error:produktAendern: mit diesem Namen gibt es keine Produktgruppe!");
			return false;
		}
		
		
		a.setName(name);
		a.setStartpreis(startpreis);
		a.setOwnerUsername(Uname);
		
		a.setDauer(dauer);
		a.setBeschreibung(beschreibung);
		a.setStartdatum(new Date());
		a.setEnddatum(dauer);
		a.setHoechstbietender(Uname);
		a.setAktuellesGebot(startpreis);
			
		
		if( dao.produktLoeschen(p.getProduktID().toString()) ){
			if(dao.produktAnlegen(a)){
				System.out.println("Produktverwaltung: ProduktAendern: Produkt geaendert!("+a+")");
				return true;
			}
			System.out.println("Produktverwaltung: ProduktAendern: Produkt nicht geaendert!");
		}
		
		return false;
	}
	
	/**
	 * 
	 * @return Liefert die komplette Produktliste
	 */
	public List<Produkt> getProduktListe(){
		return dao.getProduktList();
	}
}
