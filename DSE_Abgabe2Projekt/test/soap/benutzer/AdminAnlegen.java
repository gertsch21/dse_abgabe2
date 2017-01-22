package junitSOAP;

import static org.junit.Assert.*;
import org.junit.Test;
import client.soap.AlleServicesSEI;
import webservice.soap.SoapClient;


public class AdminAnlegen {
	Boolean test=false;
	SoapClient sc = SoapClient.getInstance();
	AlleServicesSEI client = sc.getClient();

	@Test
	public void test() throws Exception {

		test = client.adminAnlegen("Herman" , "Gurke","mikiruri@hotmail.com", 90210, "RodeoDrive", "BevHills", 569, "herman", "halloo", 50000);
		assertEquals(true,test);
	}

}
