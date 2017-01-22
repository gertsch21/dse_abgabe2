package junitSOAP;

import static org.junit.Assert.*;
import org.junit.Test;
import client.soap.AlleServicesSEI;
import webservice.soap.SoapClient;

public class PersonByUsername {
	
	Boolean test=false;
	SoapClient sc = SoapClient.getInstance();
	AlleServicesSEI client = sc.getClient();


	@Test
	public void test() {
			 if(client.getPersonByUsername("mirzi")!=null){
				 test=true;
			 }else {
				 test=false;
			 }
			 
			 assertEquals(true,test);
				 
			
}
	
	@Test
	public void test2() {
		

		 if(client.getPersonByUsername("unbekannt")!= null){
			 test=true;
		 }else {
			 test=false;
		 }
		 
		 assertEquals(false,test);
			 

	}
}
