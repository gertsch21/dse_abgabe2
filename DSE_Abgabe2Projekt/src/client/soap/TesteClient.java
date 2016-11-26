package client.soap;

import client.soap.services.Benutzer;


public class TesteClient {

	public static void main(String[] args) {

//		Benutzerverwaltung benver = Benutzerverwaltung.getInstance();
//		benver.benutzerAnlegen("Gerhard", "Schmidt", "gertsch@gmx.at", "Roseldorf", "Roseldorf", "gertsch", "hallo");
//		benver.benutzerAnlegen("Mathias", "Newelka", "nessi@nessi", "Roseldorf", "Roseldorf", "nessi", "haha");
		ClientInterface client = new Client();
		
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
		
		
		
	}

}
