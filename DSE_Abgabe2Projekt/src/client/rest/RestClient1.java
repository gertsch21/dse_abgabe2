package client.rest;

import java.util.List;
import java.util.UUID;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;

import org.apache.cxf.jaxrs.client.WebClient;

import com.sun.jersey.api.client.ClientResponse;

import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import java.io.IOException;

import javax.ws.rs.core.UriBuilder;
import org.apache.http.client.ClientProtocolException;



import modell.Benutzer;
import modell.Produkt;
import modell.Produktgruppe;

public class RestClient1 implements ClientInterface1 {
	
	static final String REST_URI = "http://localhost:9999/";
	static final String USER_PATH = "/userservice1/";
	private static final  String SUCCESS_RESULT="<result>success</result>";
	String s;
	   


		public Benutzer getBenutzerByUsername(String name){
				Benutzer ben = new Benutzer();
				ben.setUsername(name);
				WebClient client = WebClient.create(REST_URI);
				  	      client.path("/userservice1/getBenutzer").path(name).accept("application/xml");
				
				Benutzer c = client.get(Benutzer.class);
				System.out.println("Benutzer" + c);
				return c;
			}
		
		
		
		
		@Override
		public boolean pruefeLogin(String uname, String pwd) {
			Client client = ClientBuilder.newClient();
			Form form = new Form();
			form.param("username", uname);
			form.param("password", pwd);
			
			
			String clientResult=client.target(REST_URI+"/userservice1/login").request(MediaType.APPLICATION_XML)
								.post(Entity.entity(form,MediaType.APPLICATION_FORM_URLENCODED_TYPE),String.class);
									
			 if(!SUCCESS_RESULT.equals(clientResult)){
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
			
			
			String clientResult=client.target(REST_URI+"/userservice1/benutzerRegist").request(MediaType.APPLICATION_XML)
								.post(Entity.entity(form,MediaType.APPLICATION_FORM_URLENCODED_TYPE),String.class);
									
																			
			  if(!SUCCESS_RESULT.equals(clientResult)){
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
			
			
			String clientResult=client.target(REST_URI+"/userservice1/benutzerAnlegen").request(MediaType.APPLICATION_XML)
								.post(Entity.entity(form,MediaType.APPLICATION_FORM_URLENCODED_TYPE),String.class);
									
																			
			  if(!SUCCESS_RESULT.equals(clientResult)){
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
			
			
			String clientResult=client.target(REST_URI+"/userservice1/benutzerAnlegen").request(MediaType.APPLICATION_XML)
								.post(Entity.entity(form,MediaType.APPLICATION_FORM_URLENCODED_TYPE),String.class);
									
																			
			  if(!SUCCESS_RESULT.equals(clientResult)){
			         return true;
			      }else{
			    	  return false;
			      }
		}
		@Override
		public List<Benutzer> getBenutzerListe() {
			Client client = ClientBuilder.newClient();
			GenericType<List<Benutzer>> list = new GenericType<List<Benutzer>>() {};
		      List<Benutzer> benutzer = client.target(REST_URI+"/userservice1/getBenutzerListe")
		    		  		.request(MediaType.APPLICATION_XML)
		    		  		.get(list);
		      return benutzer;
		}
		
		
		@Override
		public boolean deleteBenutzer(String uname) {
			
			Client client = ClientBuilder.newClient();
			String clientResult = client.target(REST_URI+"/userservice1/benutzerdelete")
			         .path("/{usern}")
			         .resolveTemplate("usern", uname)
			         .request(MediaType.APPLICATION_XML)
			         .delete(String.class);
			
			if(!SUCCESS_RESULT.equals(clientResult)){
				return true;
			}else
			{
				return false;
			}
			
			
			
		}
		@Override
		public boolean einfrierenBenutzer(String uname) {
			 Form form = new Form();
		     form.param("name", "naresh");
		    
		      String callResult = client
		         .target(REST_SERVICE_URL)
		         .request(MediaType.APPLICATION_XML)
		         .put(Entity.entity(form,
		            MediaType.APPLICATION_FORM_URLENCODED_TYPE),
		            String.class);
		}
		@Override
		public boolean einaufhebenBenutzer(String uname) {
			// TODO Auto-generated method stub
			return false;
		}
		@Override
		public boolean passwortAendern(String uname, String pname) {
			// TODO Auto-generated method stub
			return false;
		}
		@Override
		public boolean adressAendern(String usern, int plz, String str, String ort, int nummer) {
			// TODO Auto-generated method stub
			return false;
		}
		@Override
		public List<Produkt> getGebotshistorieVonBenutzer(String uname) {
			// TODO Auto-generated method stub
			return null;
		}
		@Override
		public List<Produkt> getZumVerkaufStehendeProdukteVonBenutzer(String uname) {
			// TODO Auto-generated method stub
			return null;
		}
		@Override
		public List<Produkt> getVerkaufteProdukteVonBenutzer(String username) {
			// TODO Auto-generated method stub
			return null;
		}
		@Override
		public boolean gebotdelete(String ID) {
			// TODO Auto-generated method stub
			return false;
		}
		@Override
		public boolean gebotAbgeben(String usern, double gebot, String produktID) {
			// TODO Auto-generated method stub
			return false;
		}
		@Override
		public List<Produkt> sucheProdukt() {
			// TODO Auto-generated method stub
			return null;
		}
		@Override
		public Produkt getProduktByID(String id) {
			// TODO Auto-generated method stub
			return null;
		}
		@Override
		public boolean produktAnlegen(String usern, double sp, String uname, String kate, int dauer, String be) {
			// TODO Auto-generated method stub
			return false;
		}
		@Override
		public boolean produktDelete(String Id) {
			// TODO Auto-generated method stub
			return false;
		}
		@Override
		public boolean produktVerschieben(UUID usern, String kate) {
			// TODO Auto-generated method stub
			return false;
		}
		@Override
		public boolean produktAendern(UUID id, String name, double sp, String uname, String kate, int dauer, String be) {
			// TODO Auto-generated method stub
			return false;
		}
		@Override
		public boolean produktgruppeAnlegen(String name) {
			// TODO Auto-generated method stub
			return false;
		}
		@Override
		public boolean produktgruppeAendern(String oldname, String newname) {
			// TODO Auto-generated method stub
			return false;
		}
		@Override
		public boolean produktgruppeLoeschen(String name) {
			// TODO Auto-generated method stub
			return false;
		}
		@Override
		public Produktgruppe getProduktgruppebyUsername(String name) {
			// TODO Auto-generated method stub
			return null;
		}
		@Override
		public List<Produktgruppe> produktgruppeListe(String name) {
			// TODO Auto-generated method stub
			return null;
		}




	



	



	




		
	
	}
		

