package client.rest;

import org.apache.cxf.jaxrs.client.WebClient;


public class RestClient implements ClientInterface{

		static final String REST_URI = "http://localhost:9999/";
	    static final String ADD_PATH = "user/login";
	    String s;
	   
		    @Override
			public boolean pruefeLoginXml(String usern, String pwd) {
		    	WebClient loginClient = WebClient.create(REST_URI);
		        loginClient.path(ADD_PATH).path(usern + "/" + pwd).accept("text/xml");
		        s = loginClient.get(String.class);
		        if(s.equals("Willkommen   " + usern)){
		        System.out.println(s);
		        return true;
		        }
		        else {
		        	System.out.println(s);
		        	return false;
		        }
			    
				
				
			}

			@Override
			public boolean pruefeLoginPlain(String usern, String pwd) {
				WebClient loginClient = WebClient.create(REST_URI);
		        loginClient.path(ADD_PATH).path(usern + "/" + pwd).accept("text/plain");
		        s = loginClient.get(String.class);
		        if(s.equals("Willkommen   " + usern)){
		        System.out.println(s);
		        return true;
		        }
		        else {
		        	System.out.println(s);
		        	return false;
		        }
				
			}
	         
	   

 

   

	    }




        
    
