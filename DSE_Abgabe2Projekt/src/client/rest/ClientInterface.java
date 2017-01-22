package client.rest;

import java.util.List;
import java.util.UUID;

import javax.ws.rs.PathParam;

import modell.Benutzer;
import modell.Produkt;
import modell.Produktgruppe;

public interface ClientInterface {
	
	public boolean pruefeLogin(String uname, String pwd);
	public boolean benutzerRegistrieren1(String name, String email, String pwd);
	public boolean benutzerAnlegen(String vorname, String nachname, String email, int plz, String strasse, String wohnort, int hausnummer, String username, String password);
	public Benutzer getBenutzerByUsername(String name);
	public boolean adminAnlegen(String vorname, String nachname, String email, int plz, String strasse, String wohnort, int hausnummer, String username, String password, double gehalt);
	public List<Benutzer> getBenutzerListe();
	public boolean deleteBenutzer(String uname);
	public boolean einfrierenBenutzer(String uname);
	public boolean einaufhebenBenutzer(String uname);
	public boolean passwortAendern(String uname, String pname);
	public boolean adressAendern(String usern, int plz,String str, String ort, int nummer);
	public List<Produkt> getGebotshistorieVonBenutzer( String uname);
	public List<Produkt> getZumVerkaufStehendeProdukteVonBenutzer(String uname);
	public List<Produkt> getVerkaufteProdukteVonBenutzer(String username);

	public boolean gebotdelete(String ID);
	public boolean gebotAbgeben(String usern, double gebot,String produktID);
	
	
	public List<Produkt> sucheProdukt();
	public Produkt getProduktByID(String id);
	public boolean produktAnlegen(String usern,double sp,String uname, String kate,int dauer,String be);
	public boolean produktDelete(String Id);	
	public boolean produktVerschieben(UUID usern,String kate);
	public boolean produktAendern(UUID id, String name,double sp,String uname,String kate,int dauer,String be);
	
	
	
	public boolean produktgruppeAnlegen(String name);
	public boolean produktgruppeAendern(String oldname, String newname);
	public boolean produktgruppeLoeschen(String name);	
	public Produktgruppe getProduktgruppebyUsername(String name);
	public List<Produktgruppe> produktgruppeListe(String name);
	
			  
			 
			
			  
			    
			
			
			
			
			
}
