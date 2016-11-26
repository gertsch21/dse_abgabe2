package client.soap;

import java.util.List;

import client.soap.services.*;

public interface ClientInterface {
	public boolean pruefeLogin(String username, String password);
	public List<Benutzer> getBenutzerListe();
}
