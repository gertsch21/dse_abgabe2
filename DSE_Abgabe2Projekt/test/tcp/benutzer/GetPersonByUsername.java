package junit.benutzer;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import management.Benutzerverwaltung;
import modell.Person;


public class GetPersonByUsername {
	Benutzerverwaltung benVer = Benutzerverwaltung.getInstance();

	@Test
	public void getPersonByUsername() {
		 List<Person> liste = benVer.getPersonenListe();
		 Person person = benVer.getPersonByUsername("eki8");
		 boolean personcheck = false;
		 
		 for (Person i : liste){
				if(i.getUsername().equals(person.getUsername()) ){
					personcheck = true;
				}
				else{
					personcheck = false; 
				}
					
			 }
		 assertEquals(true,personcheck);
			 
		
	}
	
	@Test
	public void getPersonByUsernameFalse() {
		 boolean personcheck1 = false;
		
		 if(benVer.getPersonByUsername("eki10000")!= null){
			 personcheck1=true;
		 }else {
			 personcheck1=false;
		 }
		 
		 assertEquals(false,personcheck1);
			 
		
	}

	}	
	
	

