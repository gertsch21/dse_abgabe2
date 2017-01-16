/**
 * Dieses Paket beinhaltet alle relevanten Client Klassen des Webservices mittels Rest
 */
package client.rest;

import org.apache.cxf.jaxrs.client.WebClient;

/**
 * 
 * Diese Klasse implementiert Client Interface und definiert die zwei Methoden.
 *
 */
public class RestClient implements ClientInterface{

		static final String REST_URI = "http://localhost:9999/";
	    static final String USER_PATH = "user/login";
	    static final String USER_PATHXML = "user/login/xml";
	    String s;
	    
	    
	    /**
	     * Hier werden die username und password mittels eindeutiger ID uebergeben und aufgerufen.
	     * Mittels rückgabewert wird kontrolliert ob ein true oder false retouniert wird.
	     */
	   
		    @Override
			public boolean pruefeLoginXml(String usern, String pwd) {
		    	WebClient loginClient = WebClient.create(REST_URI);
		        loginClient.path(USER_PATHXML).path(usern + "/" + pwd).accept("text/xml");
		        s = loginClient.get(String.class);


				if(s.equals("<title>"+ "Bitte ueberpruefen Sie Benutzername und/oder Passwort" +"</title>")){
					
					return false;
				} else {
				
					return true;
				}
			    
				
				
			}
		    /**
		     * Hier werden die username und password mittels eindeutiger ID uebergeben und aufgerufen.
		     * Mittels rückgabewert wird kontrolliert ob ein true oder false retouniert wird.
		     */

			@Override
			public boolean pruefeLoginPlain(String usern, String pwd) {
				WebClient loginClient = WebClient.create(REST_URI);
		        loginClient.path(USER_PATH).path(usern + "/" + pwd).accept("text/plain");
		        s = loginClient.get(String.class);

				if(s.equals("Bitte ueberpruefen Sie Benutzername und/oder Passwort")){
				
					return false;
				} else {
				
					return true;
				}
				
			}
}




        
    
