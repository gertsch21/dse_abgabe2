package client.rest;

import java.util.List;
import java.util.UUID;

import javax.ws.rs.PathParam;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import org.apache.cxf.jaxrs.client.WebClient;
import modell.Benutzer;
import modell.Produkt;
import modell.Produktgruppe;

public class RestClient implements ClientInterface {
	
	static final String REST_URI = "http://localhost:9999/";
	static final String USER_PATH = "/userservice/";
	private static final  String SUCCESS_RESULT="<result>success</result>";
	String s;
	   


		public Benutzer getBenutzerByUsername(String name){
			
				Benutzer ben = new Benutzer();
				ben.setUsername(name);
				WebClient client = WebClient.create(REST_URI);
				  	      client.path("/userservice/getBenutzer").path(name).accept("application/xml");
				
				Benutzer c = client.get(Benutzer.class);
				
				return c;
			}
		
		
		
		
		@Override
		public boolean pruefeLogin(String uname, String pwd) {
			Client client = ClientBuilder.newClient();
			Form form = new Form();
			form.param("username", uname);
			form.param("password", pwd);
			
			
			String clientResult=client.target(REST_URI+"/userservice/login").request(MediaType.APPLICATION_XML)
								.post(Entity.entity(form,MediaType.APPLICATION_FORM_URLENCODED_TYPE),String.class);
									
			 if(SUCCESS_RESULT.equals(clientResult)){
		         return true;
		      }else{
		    	  return false;
		      }
		}

			@Override
		public boolean benutzerRegistrieren1(String uname, String email, String pwd) {
			Client client = ClientBuilder.newClient();
			Form form = new Form();
			form.param("fullname", uname);
			form.param("email", email);
			form.param("passwort", pwd);
			
			
			String clientResult=client.target(REST_URI+"/userservice/benutzerRegist").request(MediaType.APPLICATION_XML)
								.put(Entity.entity(form,MediaType.APPLICATION_FORM_URLENCODED_TYPE),String.class);
									
																			
			  if(SUCCESS_RESULT.equals(clientResult)){
			         return true;
			      }else{
			    	  return false;
			      }
			
		}
		
		
		@Override
		public boolean benutzerAnlegen(String vorname, String nachname, String email, int plz, String strasse, String wohnort,
				int hausnummer, String username, String password) {
			Client client = ClientBuilder.newClient();
			Form form = new Form();
			form.param("vorn", vorname);
			form.param("nachn", nachname);
			form.param("email", email);
			String plz1 = String.valueOf(plz);
			form.param("plz", plz1);
			form.param("strasse", strasse);
			form.param("wohnort", wohnort);
			String hausnummer1 = String.valueOf(hausnummer);
			form.param("hausn", hausnummer1);
			form.param("username", username);
			form.param("passwort", password);
			
			
			String clientResult=client.target(REST_URI+"/userservice/benutzerAnlegen").request(MediaType.APPLICATION_XML)
								.put(Entity.entity(form,MediaType.APPLICATION_FORM_URLENCODED_TYPE),String.class);
									
																			
			  if(SUCCESS_RESULT.equals(clientResult)){
			         return true;
			      }else{
			    	  return false;
			      }
			
		}
		
		
		
		@Override
		public boolean adminAnlegen(String vorname, String nachname, String email, int plz, String strasse, String wohnort,
				int hausnummer, String username, String password, double gehalt) {
			Client client = ClientBuilder.newClient();
			Form form = new Form();
			form.param("vorn", vorname);
			form.param("nachn", nachname);
			form.param("email", email);
			String plz1 = String.valueOf(plz);
			form.param("plz", plz1);
			form.param("strasse", strasse);
			form.param("wohnort", wohnort);
			String hausnummer1 = String.valueOf(hausnummer);
			form.param("hausn", hausnummer1);
			form.param("username", username);
			form.param("passwort", password);
			
			
			String clientResult=client.target(REST_URI+"/userservice/adminAnlegen").request(MediaType.APPLICATION_XML)
								.put(Entity.entity(form,MediaType.APPLICATION_FORM_URLENCODED_TYPE),String.class);
									
																			
			  if(SUCCESS_RESULT.equals(clientResult)){
			         return true;
			      }else{
			    	  return false;
			      }
		}
		@Override
		public List<Benutzer> getBenutzerListe() {
			Client client = ClientBuilder.newClient();
			GenericType<List<Benutzer>> list = new GenericType<List<Benutzer>>() {};
		      List<Benutzer> benutzer = client.target(REST_URI+"/userservice/getBenutzerListe")
		    		  		.request(MediaType.APPLICATION_XML)
		    		  		.get(list);
		      return benutzer;
		}
		
		
		@Override
		public boolean deleteBenutzer(String uname) {
			
			Client client = ClientBuilder.newClient();
			String clientResult = client.target(REST_URI+"/userservice/benutzerdelete")
			         .path("/{usern}")
			         .resolveTemplate("usern", uname)
			         .request(MediaType.APPLICATION_XML)
			         .delete(String.class);
			
			if(SUCCESS_RESULT.equals(clientResult)){
				return true;
			}else
			{
				return false;
			}
			
			
			
		}
		@Override
		public boolean einfrierenBenutzer(String uname) {
			Client client = ClientBuilder.newClient();
			 Form form = new Form();
		     form.param("name", uname);
		    
		      String clientResult = client
		         .target(REST_URI+"/userservice/einfrierenBenutzer")
		         .request(MediaType.APPLICATION_XML)
		         .post(Entity.entity(form,MediaType.APPLICATION_FORM_URLENCODED), String.class);
		           
		      
		      if(SUCCESS_RESULT.equals(clientResult)){
					return true;
				}else
				{
					return false;
				}
		}
		@Override
		public boolean einaufhebenBenutzer(String uname) {
			Client client = ClientBuilder.newClient();
			 Form form = new Form();
		     form.param("name", uname);
		    
		      String clientResult = client
		         .target(REST_URI+"/userservice/einaufhebenBenutzer")
		         .request(MediaType.APPLICATION_XML)
		         .post(Entity.entity(form,
		            MediaType.APPLICATION_FORM_URLENCODED_TYPE),
		            String.class);
		      
		      if(SUCCESS_RESULT.equals(clientResult)){
					return true;
				}else
				{
					return false;
				}
		}
		@Override
		public boolean passwortAendern(String uname, String pname) {
			Client client = ClientBuilder.newClient();
			 Form form = new Form();
		     form.param("name", uname);
		     form.param("passwort",pname);
		    
		      String clientResult = client
		         .target(REST_URI+"/userservice/passwortAendern")
		         .request(MediaType.APPLICATION_XML)
		         .post(Entity.entity(form,
		            MediaType.APPLICATION_FORM_URLENCODED_TYPE),
		            String.class);
		      
		      if(SUCCESS_RESULT.equals(clientResult)){
					return true;
				}else
				{
					return false;
				}
		}
		@Override
		public boolean adressAendern(String usern, int plz, String str, String ort, int nummer) {
			Client client = ClientBuilder.newClient();
			 Form form = new Form();
		     form.param("name", usern);
		     String plz1 = String.valueOf(plz);
		     form.param("plz",plz1);
		     form.param("strasse", str);
		     form.param("wohnort", ort);
		 	String hausnummer1 = String.valueOf(nummer);
		     form.param("hausnummer", hausnummer1);
		    
		      String clientResult = client
		         .target(REST_URI+"/userservice/addressaendern")
		         .request(MediaType.APPLICATION_XML)
		         .post(Entity.entity(form,
		            MediaType.APPLICATION_FORM_URLENCODED_TYPE),
		            String.class);
		      
		      if(SUCCESS_RESULT.equals(clientResult)){
					return true;
				}else
				{
					return false;
				}
		}
		
		
		
		@Override
		public List<Produkt> getGebotshistorieVonBenutzer(String uname) {
			Client client = ClientBuilder.newClient();
			GenericType<List<Produkt>> list = new GenericType<List<Produkt>>() {};
			
			
		      List<Produkt> produkte = client.target(REST_URI+"/userservice/getGebotHistorie").path(uname)
		    		  		.request(MediaType.APPLICATION_XML)
		    		  		.get(list);
		      return produkte;
		}
		
		
		
		
		@Override
		public List<Produkt> getZumVerkaufStehendeProdukteVonBenutzer(String uname) {
			Client client = ClientBuilder.newClient();
			GenericType<List<Produkt>> list = new GenericType<List<Produkt>>() {};
			
			
		      List<Produkt> produkte = client.target(REST_URI+"/userservice/produktSortiment").path(uname)
		    		  		.request(MediaType.APPLICATION_XML)
		    		  		.get(list);
		      return produkte;
		}
		@Override
		public List<Produkt> getVerkaufteProdukteVonBenutzer(String username) {
			
			Client client = ClientBuilder.newClient();
			GenericType<List<Produkt>> list = new GenericType<List<Produkt>>() {};
			List<Produkt> produkte = client.target(REST_URI+"/userservice/getVerkaufteProdukteVonBenutzer").path(username)
		    		  		.request(MediaType.APPLICATION_XML)
		    		  		.get(list);
		      return produkte;
		}
		@Override
		public boolean gebotdelete(String ID) {
			Client client = ClientBuilder.newClient();
			String clientResult = client.target(REST_URI+"/userservice/gebotdelete")
			         .path("/{id}")
			         .resolveTemplate("id", ID)
			         .request(MediaType.APPLICATION_XML)
			         .delete(String.class);
			
			if(SUCCESS_RESULT.equals(clientResult)){
				return true;
			}else
			{
				return false;
			}
			
		}
		@Override
		public boolean gebotAbgeben(String usern, double gebot, String produktID) {
			Client client = ClientBuilder.newClient();
			Form form = new Form();
			form.param("name", usern);
			String gebot1 = String.valueOf(gebot);
			form.param("gebot", gebot1);
			form.param("produktID", produktID);
			
			
			String clientResult=client.target(REST_URI+"/userservice/gebotAbgeben").request(MediaType.APPLICATION_XML)
								.put(Entity.entity(form,MediaType.APPLICATION_FORM_URLENCODED_TYPE),String.class);
									
																			
			  if(SUCCESS_RESULT.equals(clientResult)){
			         return true;
			      }else{
			    	  return false;
			      }
		}
		@Override
		public List<Produkt> sucheProdukt() {
			Client client = ClientBuilder.newClient();
			GenericType<List<Produkt>> list = new GenericType<List<Produkt>>() {};
		      List<Produkt> produkte = client.target(REST_URI+"/userservice/getProdukte")
		    		  		.request(MediaType.APPLICATION_XML)
		    		  		.get(list);
		      return produkte;
		}
		
		@Override
		public Produkt getProduktByID(String id) {
		
			WebClient client = WebClient.create(REST_URI);
			  	      client.path("/userservice/getProdukt").path(id).accept("application/xml");
			Produkt c = client.get(Produkt.class);
			
			return c;
		}
		@Override
		public boolean produktAnlegen(String usern, double sp, String uname, String kate, int dauer, String be) {
			Client client = ClientBuilder.newClient();
			Form form = new Form();
			form.param("usern", usern);
			String sp1 = String.valueOf(sp);
			form.param("startpreis", sp1);
			form.param("uname", uname);
			form.param("kategorie", kate);
			String dauer1 = String.valueOf(dauer);
			form.param("dauer", dauer1);
			form.param("beschreibung", be);
						
			
			String clientResult=client.target(REST_URI+"/userservice/produktAnlegen").request(MediaType.APPLICATION_XML)
								.put(Entity.entity(form,MediaType.APPLICATION_FORM_URLENCODED_TYPE),String.class);
									
																			
			  if(SUCCESS_RESULT.equals(clientResult)){
			         return true;
			      }else{
			    	  return false;
			      }
			
		}
		@Override
		public boolean produktDelete(String Id) {
			Client client = ClientBuilder.newClient();
			String clientResult = client.target(REST_URI+"/userservice/produktdelete")
			         .path("/{id}")
			         .resolveTemplate("id", Id)
			         .request(MediaType.APPLICATION_XML)
			         .delete(String.class);
			
			if(SUCCESS_RESULT.equals(clientResult)){
				return true;
			}else
			{
				return false;
			}
		}
		@Override
		public boolean produktVerschieben(UUID usern, String kate) {
			Client client = ClientBuilder.newClient();
			String pas = String.valueOf(usern);
			 Form form = new Form();
			 
		     form.param("uuid", pas);
		     form.param("kategorie", kate);
		    
		      String clientResult = client
		         .target(REST_URI+"/userservice/produktverschieben")
		         .request(MediaType.APPLICATION_XML)
		         .post(Entity.entity(form,
		            MediaType.APPLICATION_FORM_URLENCODED_TYPE),
		            String.class);
		      
		      if(SUCCESS_RESULT.equals(clientResult)){
					return true;
				}else
				{
					return false;
				}
		}
		@Override
		public boolean produktAendern(UUID id, String name, double sp, String uname, String kate, int dauer, String be) {
			Client client = ClientBuilder.newClient();
			String pas = String.valueOf(id);
			Form form = new Form();
			form.param("name", pas);
			String sp1 = String.valueOf(sp);
			form.param("startpreis", sp1);
			form.param("uname", uname);
			form.param("kategorie", kate);
			String dauer1 = String.valueOf(dauer);
			form.param("dauer", dauer1);
			form.param("beschreibung", be);
						
			
			String clientResult=client.target(REST_URI+"/userservice/produktAendern").request(MediaType.APPLICATION_XML)
								.post(Entity.entity(form,MediaType.APPLICATION_FORM_URLENCODED_TYPE),String.class);
									
																			
			  if(SUCCESS_RESULT.equals(clientResult)){
			         return true;
			      }else{
			    	  return false;
			      }
		}
		@Override
		public boolean produktgruppeAnlegen(String name) {
			Client client = ClientBuilder.newClient();
			
			Form form = new Form();
			form.param("name", name);
			String clientResult=client.target(REST_URI+"/userservice/produktgruppeAnlegen").request(MediaType.APPLICATION_XML)
					.put(Entity.entity(form,MediaType.APPLICATION_FORM_URLENCODED_TYPE),String.class);
						
																
				if(SUCCESS_RESULT.equals(clientResult)){
			         return true;
			      }else{
			    	  return false;
			      }
			}
		@Override
		public boolean produktgruppeAendern(String oldname, String newname) {
			Client client = ClientBuilder.newClient();
			
			Form form = new Form();
			form.param("oldname", oldname);
			form.param("newname", newname);
			String clientResult=client.target(REST_URI+"/userservice/produktgruppeAendern").request(MediaType.APPLICATION_XML)
					.post(Entity.entity(form,MediaType.APPLICATION_FORM_URLENCODED_TYPE),String.class);
						
																
				if(SUCCESS_RESULT.equals(clientResult)){
			         return true;
			      }else{
			    	  return false;
			      }
			}
		
		@Override
		public boolean produktgruppeLoeschen(String name) {
			Client client = ClientBuilder.newClient();
			String clientResult = client.target(REST_URI+"/userservice/produktgruppeLoeschen")
			         .path("/{usern}")
			         .resolveTemplate("usern", name)
			         .request(MediaType.APPLICATION_XML)
			         .delete(String.class);
			
			if(SUCCESS_RESULT.equals(clientResult)){
				return true;
			}else
			{
				return false;
			}
		}
		@Override
		public Produktgruppe getProduktgruppebyUsername(String name) {
				WebClient client = WebClient.create(REST_URI);
				client.path("/userservice/produktgruppeSuchen").path(name).accept("application/xml");
	
				Produktgruppe c = client.get(Produktgruppe.class);
	
				return c;
		}
		
		@Override
		public List<Produktgruppe> produktgruppeListe(String name) {
			Client client = ClientBuilder.newClient();
			GenericType<List<Produktgruppe>> list = new GenericType<List<Produktgruppe>>() {};
		      List<Produktgruppe> produktgruppe = client.target(REST_URI+"/userservice/getproduktgruppeListe")
		    		  		.request(MediaType.APPLICATION_XML)
		    		  		.get(list);
		      return produktgruppe;
		}




	



	



	




		
	
	}
		


