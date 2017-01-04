package management;


import java.util.List;
import java.util.UUID;


import modell.Administrator;
import modell.Benutzer;
import modell.Person;
import dao.PersonDAO;
import dao.SerializedPersonDAO;

/**
 * Diese Klasse dient der Verwaltung der einzelnen Benutzer, und greift auf den darunterliegenden Layer zu(DAO)
 */
public class Benutzerverwaltung {
	
	private static Benutzerverwaltung benutzerverwaltungInstance=null;
	private PersonDAO dao;
	
	/**
	 * Konstruktor der Benutzerverwaltung, hier wird die private Variable vom Typ PersonDAO angelegt.
	 * 
	 */
	private Benutzerverwaltung() {
		dao = new SerializedPersonDAO();
	}
	
	/**
	 *  Singleton Design-pattern
	 *  
	 * @return Referenz auf das Benutzerverwaltungsobjekt
	 */
	public static Benutzerverwaltung getInstance(){
		if(benutzerverwaltungInstance == null) benutzerverwaltungInstance = new Benutzerverwaltung();
		return benutzerverwaltungInstance;
	}
	
	/**
	 * In dieser Methode wird geprüft, ob es eine Person gibt, mit dem Usernamen und dem dazugehörigen Passwort
	 * 
	 * @param username der zu überprüfende Benutzername
	 * @param password das zu überprüfende Passwort
	 * @return
	 */
	public boolean pruefeLogin(String username,String password){
		
		try{
			Person p = dao.getPersonByUsername(username);
		
			System.out.println("Prüfe login von: "+username+", korrektes pwd: "+p.getPassword());
			
			if(p.getPassword().equals(password)){
				if(p.getClass()==Benutzer.class && !((Benutzer)p).getIstEingefroren()){
					return true;//korrektes passwort-user kombi
				}if(p.getClass()!=Benutzer.class)
					return true;
			}
			return false;//falls kombi nicht passt
		}catch(NullPointerException e){
			return false;//null, da p null ist und p.getPassword aufgerufen wird
		}
	}
	
	
	/**
	 * In dieser Methode wird ein neuer Benutzer über das PersonDAO gespeichert.
	 * 
	 * @param vorname Vorname des neuen Benutzers
	 * @param nachname Nachname des neuen Benutzers
	 * @param email Email des neuen Benutzers
	 * @param strasse Strasse des neuen Benutzers
	 * @param wohnort Wohnort des neuen Benutzers
	 * @param username Der eineutige Username des neuen Benutzers
	 * @param password Das Passwort des neuen Benutzers
	 * @return Falls erfolgreich, wird true rückgegeben, bei einem Fehler: false
	 */
	public boolean benutzerAnlegen(String vorname, String nachname, String email, int plz, String strasse, String wohnort, int hausnummer, String username, String password){//Verbesserungswürdig!!!
		UUID id = UUID.randomUUID();
		System.out.println("benutzerAnlegen: "+id+" "+vorname+" "+nachname+" "+email+" "+plz+" "+strasse+" "+wohnort+" "+hausnummer+" "+username+" "+password);
		return dao.speicherePerson(new Benutzer(id, vorname, nachname, email, plz, strasse, wohnort, hausnummer, username, password));
	}
	
	/**
	 * In dierer Methode wird ein vorhandener Benutzer gelöscht.
	 * 
	 * @param username Der eineutige Username des neuen Benutzers 
	 * @return Falls erfolgreich wird true rückgegeben, bei einem Fehler: false
	 */
	public boolean benutzerloeschen(String username){//Achtung person nicht benutzer wird gelöscht!!!
		return this.dao.loeschePerson(username);
	}
	
	/**
	 * 
	 * @param username Einzufrierende Person username
	 * @return true, wenn erfolgreich, false, falls nicht möglich
	 */
	public boolean benutzerEinfrieren(String username){
		return this.dao.einfrierenPerson(username);
	}
	
	/**
	 * 
	 * @param username Username der Person, welche nicht mehr eingefroren sein soll.
	 * @return true, wenn erfolgreich, false, falls nicht möglich
	 */
	public boolean benutzerEinfAufheben(String username){
		return this.dao.einfrierenAufheben(username);
	}
	
	/**
	 * 
	 * @param vorname Vorname des neuen Admins
	 * @param nachname Nachname des neuen Admins
	 * @param email Email des neuen Admins
	 * @param strasse Strasse des neuen Admins
	 * @param wohnort Wohnort des neuen Admins
	 * @param username Der eineutige Username des neuen Admins
	 * @param password Das Passwort des neuen Admins
	 * @param gehalt Das Gehalt des Admins
	 * @return true falls erfolgreich, sonst false
	 */
	public boolean adminAnlegen(String vorname, String nachname, String email, int plz, String strasse, String wohnort, int hausnummer, String username, String password,double gehalt){//Verbesserungswürdig!!!
		UUID id = UUID.randomUUID();
		System.out.println("AdminAnlegen: "+id+" "+vorname+" "+nachname+" "+email+" "+plz+" "+strasse+" "+wohnort+" "+hausnummer+" "+username+" "+password);
		return dao.speicherePerson(new Administrator(id, vorname, nachname, email, plz, strasse, wohnort, hausnummer, username, password,gehalt));
	}
	
	/**
	 * Diese Methode gibt den Benutzer anhand des eindeutigen Usernamens zurueck
	 * @param username Der Username des Benutzers
	 * @return Der Benutzer als Person
	 */
	public Person getBenByUsername(String username){//Achtung, liefert Personen und nicht Benutzer!!!
		return dao.getPersonByUsername(username);
	}
	
	
	/**
	 * Retourniert die Liste mit allen Benutzern
	 * @return Liste mit allen Benutzern
	 */
	public List<Benutzer> getBenutzerListe(){
		return dao.getBenutzerList();
	}
	
	
	/**
	 * Retourniert die Liste mit allen Benutzern
	 * @return Liste mit allen Benutzern
	 */
	public List<Person> getPersonenListe(){
		return dao.getPersonList();
	}
	
	
	/**
	 * 
	 * @param username Der Username des betreffenden Users
	 * @param neuesPasswort Das neue Passwort des betreffenden Users
	 * @return true, falls erfolgreich, false, falls fehler aufgetreten sind
	 */
	public boolean passwortAendern(String username, String neuesPasswort){
		if(neuesPasswort.length() < 8 || neuesPasswort.length() > 32) //keine zu kurzen oder zu langen passwoerter
			return false;
		if(neuesPasswort.length() != neuesPasswort.trim().length()) //keine Leerzeichen erlaubt
			return false;
		
		try{
			return dao.passwortAendern(username, neuesPasswort);
		}catch(exceptions.BenutzerNotFoundException e){
			System.out.println("Benutzer nicht gefunden(username='"+username+"'): " + e.getMessage());
			return false;
		}
	}
	
	
	/**
	 * 
	 * @param username Der Username des betreffenden Users
	 * @param plz Die neue PLZ des betreffenden Users
	 * @param strasse Die neueStrasse des betreffenden Users
	 * @param wohnort Der neue Wohnort des betreffenden Users
	 * @param hausnummer Die Hausnummer des betreffenden Users
	 * @return true, falls erfolgreich, false, falls fehlgeschlagen
	 */
	public boolean adressdatenAendern(String username, int plz, String strasse, String wohnort, int hausnummer){
		try{
			if(username == null) return false;
			if(strasse == null) strasse = dao.getPersonByUsername(username).getStrasse();
			if(wohnort == null) wohnort = dao.getPersonByUsername(username).getWohnort();
			if(plz>99999 || plz<0 || hausnummer<0 || hausnummer > 1000) return false;
			if(strasse.length()>500 || wohnort.length() >500) return false;
			
			return dao.adressdatenAendern(username, plz, strasse, wohnort, hausnummer);
			
		}catch(Exception e){
			//zB bei nullpointer exception, wenn strasse oder wohnort null und auch username nicht vorhanden
		}
		return false;
	}
	
	

}