import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import management.Produktverwaltung;
import modell.Produkt;


public class ProduktAendern {
	
	Produktverwaltung proVer = Produktverwaltung.getinstance();
	List<Produkt> list = proVer.getProduktListe();
	Produkt p = null;
	String ID;
	Boolean test;
	
	@Test
	public void test() {
		
		for (Produkt i : list){
			if(i.getName().equals("Der Chef")){
				p = i;
				ID = p.getProduktID().toString();
				System.out.println("das Produkt" + p );
				break;
			}
		}
		System.out.println("das ist die SYSO ID" + p.getProduktID());
		test = client.produktAendern(p.getProduktID().toString(),"Huber",200, "Hofer", "Smartphone", 18, "Voll145 anders");
		assertEquals(true,test);	
	
	}

}
