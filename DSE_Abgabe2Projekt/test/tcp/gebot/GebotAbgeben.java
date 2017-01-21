package junit.gebot;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import management.Auktionsverwaltung;
import management.Produktverwaltung;
import modell.Produkt;

public class GebotAbgeben {

	@Test
	public void test() {
		
		Auktionsverwaltung aktion = Auktionsverwaltung.getInstance();
		Produktverwaltung produkt = Produktverwaltung.getinstance();
		Produkt p = null;
		List<Produkt> list = produkt.getProduktListe();
		boolean max = false; 
		
		
		for(Produkt i : list){
		if(i.getOwnerUsername().equals("gertsch")){
			if(i.getName().equals("Samsung Lt 200")){
				p=i;
				System.out.println("ich habe mein produkt P" );
			}
				
				
		}
		String maxi = p.getProduktID().toString();
		System.out.println("String  "+ maxi);
		System.out.println("das ist p " + p.getAktuellesGebot());
		System.out.println(p.getName());
		max = aktion.gebotAbgeben("snezi", 1250.00,maxi );
		System.out.println("return von methdoe"+max);
		
		
		
		assertEquals(true,max );
	}

	}
}
