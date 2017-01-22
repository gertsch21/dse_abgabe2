package client.rest;

public class testicccc {

	public static void main(String[] args) {
		ClientInterface1 test = new RestClient1();
		
		//System.out.println(test.getBenutzerByUsername("gertsch"));
		System.out.println(test.getGebotshistorieVonBenutzer("josi"));

	}

}
