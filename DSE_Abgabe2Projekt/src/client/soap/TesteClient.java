package client.soap;

import client.soap.services.withoutTomcat.Benutzer;
import soap.services.Benutzerservices;

/**
 * 
 * Dies ist eine reine Testklasse, sie bleibt extra noch drinnen, um 
 * zusätzlich zu den JUnit tests immer neue individuelle Tests schnell zu
 * schreiben. 
 *
 */
public class TesteClient {

	/**
	 * Diese Methode führt die Tests durch
	 * @param args
	 */
	public static void main(String[] args) {

//		Benutzerverwaltung benver = Benutzerverwaltung.getInstance();
//		benver.benutzerAnlegen("Gerhard", "Schmidt", "gertsch@gmx.at", "Roseldorf", "Roseldorf", "gertsch", "hallo");
//		benver.benutzerAnlegen("Mathias", "Newelka", "nessi@nessi", "Roseldorf", "Roseldorf", "nessi", "haha");
		ClientInterface client = new Client();
		
		System.out.println("TesteClient: ");
		
		String username = "gertsch";
		String password = "falsches testpasswort"; 
		if(client.pruefeLogin(username, password))
			System.out.println("sollte nie ausgegeben werden");
		
		password = "hallo"; //richtiges passwort
		if(client.pruefeLogin(username, password))
			System.out.println("sollte ausgegeben werden");
		
		
		System.out.println("Alle Benutzer");
		for(Benutzer b : client.getBenutzerListe()){
			System.out.println(" "+b.toString());
		}
		
		
		Benutzerservices ser = new Benutzerservices();
		if(ser.pruefeLogin("gertsch", "hallo")) System.out.println("warum");;
		
		
	}

}
