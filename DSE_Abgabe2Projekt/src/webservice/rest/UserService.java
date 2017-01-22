package webservice.rest;


import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.CacheControl;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.core.Response.Status;

import management.Auktionsverwaltung;
import management.Benutzerverwaltung;
import management.Produktgruppeverwaltung;
import management.Produktverwaltung;
import modell.Benutzer;
import modell.Produkt;
import modell.Produktgruppe;

@Path("/userservice/")

public class UserService {
	
	Benutzerverwaltung ben_ver = Benutzerverwaltung.getInstance();
	Produktverwaltung pr_ver = Produktverwaltung.getinstance();
	Auktionsverwaltung ak_ver = Auktionsverwaltung.getInstance()  ;
	Produktgruppeverwaltung pr_gr = Produktgruppeverwaltung.getinstance();
	
	private static final String SUCCESS_RESULT="<result>success</result>";
	private static final String FAILURE_RESULT="<result>failure</result>";
	
	
		//Benutzerverwaltung
	
		@PUT
		@Path("/benutzerReg")
		@Produces(MediaType.TEXT_HTML)
		public Response benutzerRegistrieren(@PathParam("fullname") String usern, @PathParam("email") String email,@PathParam("passwort") String pwd) {
		if(ben_ver.benutzerAnlegen(usern, "Nachname1", email, 1110, "Holbein", "Wien", 7, usern, pwd)){
			String page="<html><body><a href=\"/Benutzer erfolgreich registriert!\">back to list</a></body></html>";
			return Response.ok(page).build();
		}
		    return  Response.status(Status.NOT_FOUND).build();
		}
		
		@PUT
		@Path("/benutzerRegist")
		@Produces(MediaType.APPLICATION_XML)
		public String benutzerRegistrieren1(@PathParam("fullname") String usern, @PathParam("email") String email,@PathParam("passwort") String pwd) {
		if(ben_ver.benutzerAnlegen(usern, "Nachname1", email, 1110, "Holbein", "Wien", 7, usern, pwd)){
			
			return SUCCESS_RESULT;
		}
		    return  FAILURE_RESULT;
		}
		
		@PUT
		@Path("/benutzerAnlegen")
		@Produces(MediaType.APPLICATION_XML)
		public String benutzerAnlegen(@FormParam("vorn") String vorn,
				@FormParam("nachn") String nachn,
				@FormParam("email") String email,
				@FormParam("plz") int plz,
				@FormParam("strasse") String strasse,
				@FormParam("wohnort") String wohnort,
				@FormParam("hausn") int hausn,
				@FormParam("username") String usern,
				@FormParam("passwort") String pwd) {
			
		boolean benutzerAn = false;
		benutzerAn = ben_ver.benutzerAnlegen(vorn, nachn, email, plz, strasse, wohnort, hausn, usern, pwd);
		if(benutzerAn==true){
			return SUCCESS_RESULT;
		}
		    return  FAILURE_RESULT;
		}
		
		@PUT
		@Path("/adminAnlegen")
		@Produces(MediaType.APPLICATION_XML)
		public String adminAnlegen(@FormParam("vorn") String vorn,
				@FormParam("nachn") String nachn,
				@FormParam("email") String email,
				@FormParam("plz") int plz,
				@FormParam("strasse") String strasse,
				@FormParam("wohnort") String wohnort,
				@FormParam("hausn") int hausn,
				@FormParam("username") String usern,
				@FormParam("passwort") String pwd,
				@FormParam("passwort") double gehalt) {
			
		boolean adminAn = false;
		adminAn = ben_ver.adminAnlegen(vorn, nachn, email, plz, strasse, wohnort, hausn, usern, pwd,gehalt);
		if(adminAn==true){
			return SUCCESS_RESULT;
		}
		    return  FAILURE_RESULT;
		}
		
		
		@POST
	    @Path("/login")
		@Produces(MediaType.APPLICATION_XML)
		@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	    public Response pruefeLogin(@PathParam("username") String usern,
	    							@PathParam("password") String pwd,
	    							@Context HttpServletResponse servletResponse) {
			if(ben_ver.pruefeLogin(usern, pwd)){
				String page="<html><body><a href=\"/Benutzer erfolgreich registriert!\">back to list</a></body></html>";
				return Response.ok().build();
			}
			    return  Response.status(Status.NOT_FOUND).build();
			}
	
		

	
		@GET
	    @Path("/getBenutzer/{name}")
	    @Produces(MediaType.APPLICATION_XML)
	    public Benutzer getBenutzerByUsername(@FormParam("name") String name) {
	        Benutzer ben = new Benutzer();
	        ben = (Benutzer) ben_ver.getPersonByUsername(name);
	        return ben;
	    }
		
		@GET
	    @Path("/getBenutzerListe")
	    @Produces(MediaType.APPLICATION_XML)
	    public List<Benutzer> getBenutzerListe() {
	       List<Benutzer> liste = ben_ver.getBenutzerListe();
	        return liste;
	    }
		

	
		@GET
		@Path("/getProdukte")
		@Produces(MediaType.APPLICATION_XML)
		public List<Produkt> getProduktListe(){
			List<Produkt> mylist = pr_ver.getProduktListe();
			return mylist;
		}
	
	
		@DELETE
		@Path("/benutzerdelete/{usern}/")
		@Produces(MediaType.APPLICATION_XML)
		public Response deleteBenutzerHTML(@PathParam("usern") String usern){
		
				
			if (ben_ver.benutzerloeschen(usern)) {
				return Response.ok().build();
			}
			else {
				return Response.status(Status.NOT_FOUND).build();
			}
		}
		@DELETE
		@Path("/benutzerdelete/{usern}")
		@Produces(MediaType.APPLICATION_XML)
		public String deleteBenutzer(@PathParam("usern") String usern){
		
				
			if (ben_ver.benutzerloeschen(usern)) {
				return SUCCESS_RESULT;
			}
			else {
				return FAILURE_RESULT;
			}
		}
		
	
		
		@POST
		@Path("/einfrierenBenutzer")
		@Produces(MediaType.APPLICATION_XML)
		@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
		public String einfrierenBenutzer(@FormParam("name") String usern) {
			boolean einfri = ben_ver.benutzerEinfrieren(usern);
			
			if(einfri == true){
				return SUCCESS_RESULT;
			}else {
				return FAILURE_RESULT ;
			}
		}
		
		@POST
		@Path("/einaufhebenBenutzer")
		@Produces(MediaType.APPLICATION_XML)
		@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
		public String einaufhebenBenutzer(@PathParam("name") String usern) {
			boolean einfri = ben_ver.benutzerEinfAufheben(usern);
			
			if(einfri == true){
				return SUCCESS_RESULT;
			}else {
				return FAILURE_RESULT; 
			}
		}
		
		@POST
		@Path("/passwortaendern")
		@Produces(MediaType.APPLICATION_XML)
		@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
		public String passwortAendern(@PathParam("name") String usern, @PathParam("passwort") String pwd){
			boolean pass = ben_ver.passwortAendern(usern, pwd);
			
			if(pass == true){
				return SUCCESS_RESULT;
			}else {
				return FAILURE_RESULT; 
			}
		}
		
		@POST
		@Path("/addressaendern")
		@Produces(MediaType.APPLICATION_XML)
		@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
		public String adressAendern(@PathParam("name") String usern,
									@PathParam("plz") String plz,
									@PathParam("strasse") String str,
									@PathParam("wohnort") String ort,
									@PathParam("hausnummer") String nummer
									){
			int plzint = Integer.valueOf(plz);
			int nummer1 = Integer.valueOf(nummer);
			boolean pass = ben_ver.adressdatenAendern(usern, plzint, str, ort, nummer1);
			
			if(pass == true){
				return SUCCESS_RESULT;
			}else {
				return FAILURE_RESULT; 
			}
		}
		
		@DELETE
		@Path("/gebotdelete/{id}/")
		@Produces(MediaType.APPLICATION_XML)
		public String gebotdelete(@PathParam("id") String produktId){
			if (ak_ver.gebotLoeschen(produktId)) {
				return SUCCESS_RESULT;
			}
			else {
				return FAILURE_RESULT;
			}
		}

		
		@PUT
		@Path("/gebotAbgeben")
		@Produces(MediaType.APPLICATION_XML)
		@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
		public String gebotAbgeben(@PathParam("name") String usern,
								   @PathParam("gebot") double gebot,
								   @PathParam("produktID") String produktID){
			boolean gebotres = ak_ver.gebotAbgeben(usern, gebot, produktID);
			
			if(gebotres == true){
				return SUCCESS_RESULT;
			}else {
				return FAILURE_RESULT; 
			}
		}
		

		@GET
	    @Path("/getProdukt/{id}")
	    @Produces(MediaType.APPLICATION_XML)
		public Produkt getProduktById(@PathParam("id") String id) {
	        Produkt pro = new Produkt();
	        pro = (Produkt) pr_ver.getProduktByID(id);
	        return pro;
	    }
		
		
		
		@PUT
		@Path("/produktAnlegen")
		@Produces(MediaType.APPLICATION_XML)
		public String produktAnlegen(@PathParam("name") String usern,
				@PathParam("startpreis") double sp,
				@PathParam("uname") String uname,
				@PathParam("kategorie") String kate,
				@PathParam("dauer") int dauer,
				@PathParam("beschreibung") String be) {
			
		if(pr_ver.produktAnlegen(usern, sp, uname, kate, dauer, be)){
			return SUCCESS_RESULT;
		}else{
			return FAILURE_RESULT; 
		}
		}
		
		@DELETE
		@Path("/produktdelete/{id}/")
		@Produces(MediaType.APPLICATION_XML)
		public String produktDelete(@PathParam("id") String produktId){
			if (pr_ver.produktLoeschen(produktId)) {
				return SUCCESS_RESULT;
			}
			else {
				return FAILURE_RESULT;
			}
		}
		
		@POST
		@Path("/produktverschieben")
		@Produces(MediaType.APPLICATION_XML)
		@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
		public String produktVerschieben(@PathParam("uuid") UUID usern,
								   @PathParam("kategorie") String kate){
			boolean gebotres = pr_ver.produktVerschieben(usern, kate);
			
			if(gebotres == true){
				return SUCCESS_RESULT;
			}else {
				return FAILURE_RESULT; 
			}
		}
		
		@GET
		@Path("/getGebotHistorie/{username}")
		@Produces(MediaType.APPLICATION_XML)
		public List<Produkt> getGebotshistorieVonBenutzer(@PathParam("username") String uname){
			
			List<Produkt> mylist = ben_ver.getGebotshistorieVonBenutzer(uname);
			
			return mylist;
			
		}
		
		@GET
		@Path("/getVerkaufteProdukteVonBenutzer/{username}")
		@Produces(MediaType.APPLICATION_XML)
		public List<Produkt> getVerkaufteProdukteVonBenutzer(@PathParam("username") String uname){
			
			List<Produkt> mylist = ben_ver.getVerkaufteProdukteVonBenutzer(uname);
			
			return mylist;
			
		}
		
	//	Produktsortiment des Benutzers(alle noch nicht Verkauften)
		
		@GET
		@Path("/produktSortiment/{username}")
		@Produces(MediaType.APPLICATION_XML)
		public List<Produkt> getZumVerkaufStehendeProdukteVonBenutzer(@PathParam("username") String uname){
			List<Produkt> mylist = ben_ver.getZumVerkaufStehendeProdukteVonBenutzer(uname);
			return mylist;
			
		}	
		
		@POST
		@Path("/produktAendern")
		@Produces(MediaType.APPLICATION_XML)
		public String produktAendern(@PathParam("id") UUID id,
				@PathParam("name") String name,
				@PathParam("startpreis") double sp,
				@PathParam("uname") String uname,
				@PathParam("kategorie") String kate,
				@PathParam("dauer") int dauer,
				@PathParam("beschreibung") String be){
			boolean por_Aend = pr_ver.produktAendern(id, name, sp, uname, kate, dauer, be);
				
			if(por_Aend == true){
				return SUCCESS_RESULT;
			}else {
				return FAILURE_RESULT; 
			}
		}
		//Produktgruppe
		@PUT
		@Path("/produktgruppeAnlegen")
		@Produces(MediaType.APPLICATION_XML)
		public String produktgruppeAnlegen(@PathParam("name") String name){
			
			
			if(pr_gr.produktgruppeAnlegen(name)){
				return SUCCESS_RESULT;
			}else{
				return FAILURE_RESULT;
			}
		}
		
		@DELETE 
		@Path("/produktgruppeLoeschen/{name}")
		@Produces(MediaType.APPLICATION_XML)
		public String produktgruppeLoeschen(@PathParam("name") String name){
			if(pr_gr.produktgruppeLoeschen(name)){
				return SUCCESS_RESULT;
			}else{
				return FAILURE_RESULT;
			}
		}
		
		@GET
		@Path("/produktgruppeSuchen/{name}")
		@Produces(MediaType.APPLICATION_XML)
		public Produktgruppe getProduktgruppebyUsername(@PathParam("name") String name){
			Produktgruppe pr = pr_gr.getProduktgruppeByName(name);
			return pr;
			
		}
		
		@POST
		@Path("/produktgruppeAendern")
		@Produces(MediaType.APPLICATION_XML)
		@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
		public String produktgruppeAendern(@PathParam("oldname") String oldname,
								   @PathParam("newname") String newname){
		
			
			if(	pr_gr.produktgruppeAendern(oldname, newname)){
				return SUCCESS_RESULT;
			}else {
				return FAILURE_RESULT; 
			}
		}
		
		@GET
		@Path("/getproduktgruppeListe/{name}")
		@Produces(MediaType.APPLICATION_XML)
		public List<Produktgruppe> produktgruppeListe(@PathParam("name") String name){
			List<Produktgruppe> mylist = pr_gr.getProduktgruppeList();
			return mylist;
			
		}
		
		
		@GET
	    @Path("/getHTML")
	    @Produces(MediaType.TEXT_HTML)
	    public String getHTML() {
	      
	        return "<h1>Hallo</h1>";
	    }
		
		
		
		
		
		
		
	}
	
	
	
	
	
	

	
	
	
	
	

