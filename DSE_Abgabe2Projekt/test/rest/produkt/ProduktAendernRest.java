package junit.rest.produkt;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import client.rest.ClientInterface;
import client.rest.RestClient;
import management.Produktverwaltung;
import modell.Produkt;

public class ProduktAendernRest {

	Boolean pro_test=false;
	ClientInterface client = new RestClient();

	Produktverwaltung produkt = Produktverwaltung.getinstance();
	Produkt p = null;
	
	@Test
	public void test() {
		List<Produkt> list = produkt.getProduktListe();
		for (Produkt i : list){
			
			if(i.getName().equals("Lederjacke")){
				p = i;
				break;
			}
		}
		
		pro_test = client.produktAendern(p.getProduktID(),"jacke",p.getAktuellesGebot(), p.getOwnerUsername(),"Fernsehen", p.getDauer(), p.getBeschreibung());
		assertEquals(true,pro_test);	
	}
	
}
