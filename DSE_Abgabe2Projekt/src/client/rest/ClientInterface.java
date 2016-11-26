package client.rest;

public interface ClientInterface {
	
	public boolean pruefeLoginXml(String usern, String pwd);
	public boolean pruefeLoginPlain(String usern, String pwd);

}
