package junit.rest;

import static org.junit.Assert.*;

import org.junit.Test;

import client.rest.ClientInterface;
import client.rest.RestClient;

public class getBenutzerRest {


	Boolean test=false;
	
	ClientInterface client = new RestClient();


	@Test
	public void test() {
			 if(client.getBenutzerByUsername("josi")!=null){
				 test=true;
			 }else {
				 test=false;
			 }
			 
			 assertEquals(true,test);
				 
			
}
}
