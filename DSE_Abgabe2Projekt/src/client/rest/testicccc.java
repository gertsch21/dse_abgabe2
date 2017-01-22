package client.rest;

public class testicccc {

	public static void main(String[] args) {
		ClientInterface1 test = new RestClient1();
		
		System.out.println(test.produktgruppeAendern("Menschen","Fahrzeuge"));
	//	System.out.println(test.getGebotshistorieVonBenutzer("josi"));
		//System.out.println(test.getProduktByID("81043b2c-2160-4130-97f6-1f3982a5d7bb"));

	}

}
