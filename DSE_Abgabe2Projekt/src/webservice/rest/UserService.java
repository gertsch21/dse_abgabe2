/**
 *Dieses Paket beinhaltet alle wichtigen Klassen des Servers auf dem der WebService implementiert ist.
 */
 package webservice.rest;
 
 
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import management.Benutzerverwaltung;
import modell.Benutzer;
/**
 * 
 * In dieser Klasse wird Root Path erstellt. Die Methode überprüft die übergebene Paramater mit Hilfe 
 * des Benutzerverwaltungsojbekts. Gibt danach ein true oder false zurück. Danach wird ein String übergeben. 
 *
 */

@Path("/userservice")
public class UserService {
	
	Benutzerverwaltung benutzer = Benutzerverwaltung.getInstance();

	@GET
    @Path("/login/{username}/{password}")
    @Produces(MediaType.TEXT_PLAIN)
    public String einloggenText(@PathParam("username") String usern, @PathParam("password") String pwd) {
		if(benutzer.pruefeLogin(usern, pwd)==true) return	"Willkommen   " + usern;
		else return "Bitte ueberpruefen Sie Benutzername und/oder Passwort";
		
			
		
	}
	
	@GET
    @Path("login/xml/{username}/{password}")
    @Produces(MediaType.TEXT_XML)
    public String einloggen(@PathParam("username") String usern, @PathParam("password") String pwd) {
		if(benutzer.pruefeLogin(usern, pwd)==true)    return "<title>" + "Willkommen " +  usern + "</title>";
		else return "<title>"+ "Bitte ueberpruefen Sie Benutzername und/oder Passwort" +"</title>";
     
    }
     
	 	@GET
	    @Path("getBenutzer/{name}")
	    @Produces(MediaType.APPLICATION_XML)
	    public Benutzer getBenutzer(@PathParam("name") String id) {
	        Benutzer ben = new Benutzer();
	        ben = (Benutzer) benutzer.getPersonByUsername(id);
	        return ben;
	    }
	 	
	 	@GET
	    @Path("getBenutzerListe/")
	    @Produces(MediaType.APPLICATION_XML)
	    public List<Benutzer> getBenutzerListe() {
	       List<Benutzer> liste = benutzer.getBenutzerListe();
	        return liste;
	    }
	 	
	 
	 	
	 	
	 	
	 	
	}
	
    
     