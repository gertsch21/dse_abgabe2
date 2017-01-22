package junit.benutzer;

import static org.junit.Assert.*;
import java.util.List;
import org.junit.Test;
import management.Benutzerverwaltung;
import modell.Benutzer;
import modell.Person;


public class GetPersonenList {
	Benutzerverwaltung benVer = Benutzerverwaltung.getInstance();
	
	@Test
	public void getPerosnenListeJunit(){
		
	
		 List<Person> per = benVer.getPersonenListe();
		 List<Person> p = per;
		 boolean perscheck = false;
		 
		 for (Person i : p){
			 
				if(i.getClass() == Person.class){
					
					perscheck = true;
				}
				else{
					perscheck = false; 
				}
					
			 }
		 assertEquals(false,perscheck);
			 
		
	}

}
