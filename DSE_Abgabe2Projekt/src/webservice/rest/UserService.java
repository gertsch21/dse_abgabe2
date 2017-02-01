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
//	private static final String FAILURE_RESULT="<result>failure</result>";
	
	
	
		
		@POST
		@Path("/benutzerRegist")
		@Produces(MediaType.APPLICATION_XML)
		public Response benutzerRegistrieren1(@FormParam("fullname") String usern, @FormParam("email") String email,@PathParam("passwort") String pwd) {
		if(ben_ver.benutzerAnlegen(usern, "Nachname1", email, 1110, "Holbein", "Wien", 7, usern, pwd)){
			
			return Response.ok(SUCCESS_RESULT).build();
		}
			return  Response.status(Status.BAD_REQUEST).build();
		}
		
		@POST
		@Path("/benutzerAnlegen")
		@Produces(MediaType.APPLICATION_XML)
		public Response benutzerAnlegen(@FormParam("vorn") String vorn,
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
			return Response.ok(SUCCESS_RESULT).build();
		}
			return  Response.status(Status.BAD_REQUEST).build();
		}
		
		@POST
		@Path("/adminAnlegen")
		@Produces(MediaType.APPLICATION_XML)
		public Response adminAnlegen(@FormParam("vorn") String vorn,
				@FormParam("nachn") String nachn,
				@FormParam("email") String email,
				@FormParam("plz") int plz,
				@FormParam("strasse") String strasse,
				@FormParam("wohnort") String wohnort,
				@FormParam("hausn") int hausn,
				@FormParam("username") String usern,
				@FormParam("passwort") String pwd,
				@FormParam("gehalt") double gehalt) {
			
	
		if(ben_ver.adminAnlegen(vorn, nachn, email, plz, strasse, wohnort, hausn, usern, pwd,gehalt)){
			return Response.ok(SUCCESS_RESULT).build();
		}
		    return  Response.status(Status.BAD_REQUEST).build();
		}
		
		
		@POST
	    @Path("/login")
		@Produces(MediaType.APPLICATION_XML)
	    public Response pruefeLogin(@FormParam("username") String usern,
	    							@FormParam("password") String pwd) {
			if(ben_ver.pruefeLogin(usern, pwd)){
				return Response.ok(SUCCESS_RESULT).build();
			}
			    return  Response.status(Status.BAD_REQUEST).build();
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
		@Path("/benutzerdelete")
		@Produces(MediaType.APPLICATION_XML)
		@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
		public Response deleteBenutzer(@FormParam("usern") String usern){
		
				
			if (ben_ver.benutzerloeschen(usern)) {
				return Response.ok(SUCCESS_RESULT).build();
			}
			else {
				return  Response.status(Status.BAD_REQUEST).build();
			}
		}
		
	
		
		@PUT
		@Path("/einfrierenBenutzer")
		@Produces(MediaType.APPLICATION_XML)
		@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
		public Response einfrierenBenutzer(@FormParam("name") String usern){
										 
		
			
			if(ben_ver.benutzerEinfrieren(usern)){
				return Response.ok(SUCCESS_RESULT).build();
			}else {
				return Response.status(Status.BAD_REQUEST).build();
			}
		}
		
		@PUT
		@Path("/einaufhebenBenutzer")
		@Produces(MediaType.APPLICATION_XML)
		@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
		public Response einaufhebenBenutzer(@FormParam("name") String usern) {
			
			
			if(ben_ver.benutzerEinfAufheben(usern)){
				return Response.ok(SUCCESS_RESULT).build();
		        		
			}else{
				 return  Response.status(Status.BAD_REQUEST).build();
			}
			   
		}
		
		@PUT
		@Path("/passwortaendern")
		@Produces(MediaType.APPLICATION_XML)
		@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
		public Response passwortAendern(@FormParam("name") String usern, @FormParam("passwort") String pwd){
			boolean pass = ben_ver.passwortAendern(usern, pwd);
			
			if(pass == true){
				return Response.ok(SUCCESS_RESULT).build();
			}else {
				return  Response.status(Status.BAD_REQUEST).build();
			}
		}
		
		@PUT
		@Path("/addressaendern")
		@Produces(MediaType.APPLICATION_XML)
		@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
		public Response adressAendern(@FormParam("name") String usern,
									@FormParam("plz") String plz,
									@FormParam("strasse") String str,
									@FormParam("wohnort") String ort,
									@FormParam("hausnummer") String nummer
									){
			int plzint = Integer.valueOf(plz);
			int nummer1 = Integer.valueOf(nummer);
			
			
			if(ben_ver.adressdatenAendern(usern, plzint, str, ort, nummer1)){
				return Response.ok(SUCCESS_RESULT).build();
			}else {
				return  Response.status(Status.BAD_REQUEST).build();
			}
		}
		
		@DELETE
		@Path("/gebotdelete/{id}/")
		@Produces(MediaType.APPLICATION_XML)
		public Response gebotdelete(@FormParam("id") String produktId){
			if (ak_ver.gebotLoeschen(produktId)) {
				return Response.ok(SUCCESS_RESULT).build();
			}
			else {
				return  Response.status(Status.BAD_REQUEST).build();
			}
		}

		
		@PUT
		@Path("/gebotAbgeben")
		@Produces(MediaType.APPLICATION_XML)
		@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
		public Response gebotAbgeben(@FormParam("name") String usern,
								   @FormParam("gebot") double gebot,
								   @FormParam("produktID") String produktID){
			boolean gebotres = ak_ver.gebotAbgeben(usern, gebot, produktID);
			
			if(gebotres == true){
				return Response.ok(SUCCESS_RESULT).build();
			}else {
				return  Response.status(Status.BAD_REQUEST).build();
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
		
		
		
		@POST
		@Path("/produktAnlegen")
		@Produces(MediaType.APPLICATION_XML)
		public Response produktAnlegen(@FormParam("name") String usern,
				@FormParam("startpreis") double sp,
				@FormParam("uname") String uname,
				@FormParam("kategorie") String kate,
				@FormParam("dauer") int dauer,
				@FormParam("beschreibung") String be) {
			
		if(pr_ver.produktAnlegen(usern, sp, uname, kate, dauer, be)){

			return Response.ok(SUCCESS_RESULT).build();
		}else{
			return  Response.status(Status.BAD_REQUEST).build();
		}
		}
		
		@DELETE
		@Path("/produktdelete/{id}/")
		@Produces(MediaType.APPLICATION_XML)
		public Response produktDelete(@FormParam("id") String produktId){
			if (pr_ver.produktLoeschen(produktId)) {

				return Response.ok(SUCCESS_RESULT).build();
			}
			else {
				return  Response.status(Status.BAD_REQUEST).build();
			}
		}
		
		@PUT
		@Path("/produktverschieben")
		@Produces(MediaType.APPLICATION_XML)
		@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
		public Response produktVerschieben(@FormParam("uuid") UUID usern,
								   @FormParam("kategorie") String kate){
			boolean gebotres = pr_ver.produktVerschieben(usern, kate);
			
			if(gebotres == true){

				return Response.ok(SUCCESS_RESULT).build();
			}else {
				return  Response.status(Status.BAD_REQUEST).build();
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
		
		@PUT
		@Path("/produktAendern")
		@Produces(MediaType.APPLICATION_XML)
		public Response produktAendern(@FormParam("id") UUID id,
				@FormParam("name") String name,
				@FormParam("startpreis") double sp,
				@FormParam("uname") String uname,
				@FormParam("kategorie") String kate,
				@FormParam("dauer") int dauer,
				@FormParam("beschreibung") String be){
			boolean por_Aend = pr_ver.produktAendern(id, name, sp, uname, kate, dauer, be);
				
			if(por_Aend == true){
				return Response.ok(SUCCESS_RESULT).build();
			}else {
				return  Response.status(Status.BAD_REQUEST).build();
			}
		}
		//Produktgruppe
		@POST
		@Path("/produktgruppeAnlegen")
		@Produces(MediaType.APPLICATION_XML)
		public Response produktgruppeAnlegen(@FormParam("name") String name){
			
			
			if(pr_gr.produktgruppeAnlegen(name)){
				return Response.ok(SUCCESS_RESULT).build();
			}else{
				return  Response.status(Status.BAD_REQUEST).build();
			}
		}
		
		@DELETE 
		@Path("/produktgruppeLoeschen/{name}")
		@Produces(MediaType.APPLICATION_XML)
		public Response produktgruppeLoeschen(@FormParam("name") String name){
			if(pr_gr.produktgruppeLoeschen(name)){
				return Response.ok(SUCCESS_RESULT).build();
			}else{
				return  Response.status(Status.BAD_REQUEST).build();
			}
		}
		
		@GET
		@Path("/produktgruppeSuchen/{name}")
		@Produces(MediaType.APPLICATION_XML)
		public Produktgruppe getProduktgruppebyUsername(@PathParam("name") String name){
			Produktgruppe pr = pr_gr.getProduktgruppeByName(name);
			return pr;
			
		}
		
		@PUT
		@Path("/produktgruppeAendern")
		@Produces(MediaType.APPLICATION_XML)
		@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
		public Response produktgruppeAendern(@FormParam("oldname") String oldname,
								   @FormParam("newname") String newname){
		
			
			if(	pr_gr.produktgruppeAendern(oldname, newname)){
				return Response.ok(SUCCESS_RESULT).build();
			}else {
				return  Response.status(Status.BAD_REQUEST).build();
			}
		}
		
		@GET
		@Path("/getproduktgruppeListe/{name}")
		@Produces(MediaType.APPLICATION_XML)
		public List<Produktgruppe> produktgruppeListe(@FormParam("name") String name){
			List<Produktgruppe> mylist = pr_gr.getProduktgruppeList();
			return mylist;
			
		}
		
		
		
		
		
		
		
		
	}
	
	
	
	
	
	

	
	
	
	
	

