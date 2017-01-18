package management;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date; 
import dao.*;
import modell.Benutzer;
import modell.Person;
import modell.Produkt;
/**
 * Diese Klasse wird verwendet um die Aktionen der Auktionsverwaltung durchfuehren und kontrollieren 
 * zu koennen. 
 * 
 */
public class Auktionsverwaltung {
	
	private static Auktionsverwaltung autkionsveraltungInstance=null;
	private ProduktDAO dao;
	/**
	 * Im Konstruktor der Klasse Auktionsverwaltung wird ein Objekt der  Klasse SerializedProduktDAO 
	 * erzeugt
	 */
	private Auktionsverwaltung (){
		dao = new SerializedProduktDAOHibernate();
	}
	/**
	 * Singleton Design-pattern
	 * @return
	 */
	public static Auktionsverwaltung getInstance(){
		if(autkionsveraltungInstance==null) autkionsveraltungInstance = new Auktionsverwaltung();
		return autkionsveraltungInstance;
	}
	
	/**
	 * Das Produkt wird anhand der ID gesucht und geholt.
	 * Es wird weiters geprueft ob das neue Gebot hoeher als das aktuelle Gebot ist und dann ersetzt.
	 * Es wird noch der Username kontrolliert ob er denn nicht der zuletzt gebotene User war, damit man
	 * sich nicht ueberbieten kann.
	 * @param username ist der Username des Bieters
	 * @param gebot ist das Gebot welches der User fuer ein Produkt machen moechte
	 * @param produktID Ist die ID des Produktes fuer das Geboten werden soll
	 * @return boolean
	 */
	public boolean gebotAbgeben(String username,double gebot,String produktID){
		username = username.trim();
		Produkt p = Produktverwaltung.getinstance().getProduktByID(produktID);
		Person b = Benutzerverwaltung.getInstance().getPersonByUsername(username);
		
		if(b==null){
			System.err.println("Auktionsverwaltung:gebotAbgeben: kein Benutzer mit diesem Usernamen('"+username+"') vorhanden!");
			return false;
		}
		if(p==null){
			System.err.println("Auktionsverwaltung:gebotAbgeben: kein Produkt mit diese Produktid("+produktID+"') vorhanden!");
			return false;
		}
		if(p.getHoechstbietender().trim().equals(username)){
			System.err.println("Auktionsverwaltung:gebotAbgeben: Der User('"+username+"') war bereits Hoechstbietender!");
			return false;
		}
		
		if(gebot>p.getAktuellesGebot())
			return dao.produktBekommtNeuesGebot(produktID, username, gebot);

		
		System.err.println("Auktionsverwaltung:gebotAbgeben: Das Gebot('"+gebot+"') von User('"+username+"') ist kleiner als aktuelles('"+p.getAktuellesGebot()+"')!");
		return false;
}
	
	
	public boolean gebotLoeschen(String produktID){
		Produkt p = Produktverwaltung.getinstance().getProduktByID(produktID);
		
		if(p==null){
			System.err.println("Auktionsverwaltung:gebotLoeschen: kein Produkt mit dieser ID('"+produktID+"') vorhanden!");
			return false;
		}
		
		return dao.produktBekommtNeuesGebot(produktID, p.getOwnerUsername(), p.getStartpreis());
		
}
	
	
	/**
	 * Diese Methode checkt die Auktionsdauer jedes Produktes auf die Sekunde genau.
	 * Jedes mal wenn ein Produkt aufgemacht wird, kommt diese Methode ins spiel und checkt
	 * ob ein Gebot ueberhaupt noch moeglich ist. Ist die Auktionszeit abgelaufen kann nicht mehr
	 * geboten werden.
	 * @throws ParseException
	 */
	public void gebotEnde() throws ParseException{
		DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
		
			for(Produkt index:dao.getProduktList()){
				Date date =new Date();
				String s =dateFormat.format(date);
				
				Date enddatum =index.getEnddatum();
				String h=dateFormat.format(enddatum);
				
				Date now=dateFormat.parse(s);
				Date future=dateFormat.parse(h);
			
	      	if(now.after(future)){
	      		index.setVerkauft(true);
	      		String losch=index.getProduktID().toString();
	      		dao.produktLoeschen(losch);
	      		dao.produktAnlegen(index);
	      		
	      		
	      	}
		}	
	}
		
}