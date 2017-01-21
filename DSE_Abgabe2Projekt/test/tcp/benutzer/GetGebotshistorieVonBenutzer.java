package junit.benutzer;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.util.List;

import org.junit.Test;

import exceptions.BenutzerNotFoundException;
import management.Auktionsverwaltung;
import management.Benutzerverwaltung;
import management.Produktverwaltung;
import modell.Produkt;

public class GetGebotshistorieVonBenutzer {
	
	Benutzerverwaltung pr_ver = Benutzerverwaltung.getInstance();
	Produktverwaltung pr_ver1 = Produktverwaltung.getinstance();
	Auktionsverwaltung auktion = Auktionsverwaltung.getInstance();
	
	@Test
	public void test() throws BenutzerNotFoundException, ParseException {
		
		int count = 0;
		boolean  benutzer = false;
		auktion.gebotEnde();
		
		List<Produkt> allePr = pr_ver.getGebotshistorieVonBenutzer("gertsch");
		for(Produkt i : allePr){
			count++;
		}
		
		if(count == 0){
			benutzer = false; 
		}else{
			benutzer = true;
		}
		
	 	
		assertEquals(true,benutzer);
		
		
		
		
	}

}
