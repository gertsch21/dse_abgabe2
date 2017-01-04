/**
 * Das Paket dient zum persistenten Speichern der Personen
 */
package dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import exceptions.BenutzerNotFoundException;
import modell.Administrator;
import modell.Benutzer;
import modell.Person;


public class SerializedPersonDAO implements PersonDAO{

	private String filePath;
	private File myFile;
	
	/**
	 *  Der Pfad ist immer PersonenListe.dat(also im jeweiligen Ordner)
	 */
	public SerializedPersonDAO(){
		super();
		this.filePath="C:\\Users\\Gerhard\\Desktop\\PersonenListe.dat";
		this.myFile = new File(filePath);
		checkIfFileExist();
	}
	
	
	public void checkIfFileExist(){

		if(!this.myFile.exists())
			try{
				this.myFile.createNewFile();
			} catch(IOException e1){
				System.out.println("Error: File konnte nicht erstellt werden.");
		}
	}
	
	@Override
	public List<Person> getPersonList(){
		
		InputStream is=null;
		ArrayList<Person> myList=null;
		ObjectInputStream ois=null;
		
		if(myFile.length()==0){
			
				System.out.println("File ist leer");
				myList = new ArrayList<Person>();
				writeListInFile(myList);
				return myList;
		}
		try{
				is=new FileInputStream(filePath);
				ois=new ObjectInputStream(is);
				myList=(ArrayList<Person>) ois.readObject();
		} catch(IOException e){
				System.err.println("IO: "+e);
		} catch(ClassNotFoundException e){
				System.err.println("Klasse nicht gefunden: "+e);
		} finally{
			try{
					ois.close();
					is.close();
			} catch(Exception e){
					System.err.println("Fehler beim Schlie�en: "+e);
			}
		}
		return myList;
	}

	
	@Override
	public List<Benutzer> getBenutzerList(){
		
		List<Person> personen=this.getPersonList();
		List<Benutzer> benutzer = new ArrayList<Benutzer>();
		for(Person i:personen){
			if(i.getClass()==Benutzer.class)
				benutzer.add((Benutzer)i);
		}
		System.out.println("Anz Personen: "+personen.size()+"\nAnz Benutzer: "+benutzer.size());
		return benutzer;
		
	}
	
	@Override
	public Person getPersonById(String id){
		List<Person> liste=getPersonList();
		if(liste==null) return null; 
		for(Person p:liste){
			if(p.getId().toString()==id){
				return p;
			}
		}
		return null; 
	}

	
	@Override
	public boolean speicherePerson(Person benutzer){
		List<Person> myList=null;
		myList = getPersonList();
		for(Person i:myList)
			if(benutzer.getUsername().equals(i.getUsername()) || benutzer.getId().equals(i.getId())){
				System.out.println("Person schon enthalten.");
				return false;
			}
			
			myList.add(benutzer);
			writeListInFile(myList);
			return true;
	}
	
	@Override
	public Person getPersonByUsername(String username){	
		List<Person> liste=getPersonList();
		if(liste==null){
			System.out.println("Keine Liste!"); 
			return null;
		} 
		for(Person p:liste){
			if(p.getUsername().equals(username))
				return p;
		}
		return null;
	}

	
	@Override
	public boolean loeschePerson(String benutzer){
		
		boolean found=false;
		List<Person> myList=this.getPersonList();
		
		try{
			for (Person i : myList)
				if(i.getUsername().equals(benutzer)){
					myList.remove(i);
					found=true;
					break;
				}
			
			writeListInFile(myList);
			return found;
		}catch(NullPointerException e){
			System.out.println("Error: Keine Liste vorhanden!"); 
			return false;
		}

	}
	
	
	@Override
	public boolean einfrierenPerson(String username){
		boolean found=false;
		List<Person> myList=this.getPersonList();
		try{
			for(Person i : myList){
				if(i.getUsername().equals(username)){
					if(i.getClass()==Benutzer.class){
						((Benutzer)i).setIstEingefroren(true);
					}
					else{
						return false;
					}
				found = true;
				break;
					
				}
			}
			writeListInFile(myList);
			return found;
		}catch(NullPointerException e){
			System.out.println("Error: Keine Liste vorhanden!");
			return false;
		}
	}
	
	@Override
	public boolean einfrierenAufheben(String username){
		boolean found=false;
		List<Person> myList=this.getPersonList();
		try{
			for(Person i : myList){
				if(i.getUsername().equals(username)){
					if(i.getClass()==Benutzer.class){
						((Benutzer)i).setIstEingefroren(false);
					}
					else{
						return false;
					}
				found = true;
				break;
				}
			}
			writeListInFile(myList);
			return found;
		}catch(NullPointerException e){
			System.out.println("Error: Keine Liste vorhanden!");
			return false;
		}
	}

	
	
	/**
	 * Noch nicht sicher obb das so bleiben kann ? Vielleicht ist diese Methode unn�tig
	 * derzeit noch nicht im Interface vorhanden! Geh�rt ansonsten entfernt
	 * Pr�ft ob ein Person in einer gegebenen Liste enthalten ist.
	 * 
	 * @param benutzer Der zu pr�fende Person.
	 * @param myList Die zu verwendende Liste.
	 * @return True falls enthalten, False falls nicht enthalten.
	 */
	private boolean elementInList(Person benutzer, List<Person> myList){
		if(myList != null)
			for (Person i : myList)
				if (i.getId()==benutzer.getId())
					return true;
		return false;
	}


	
	/**
	 * Diese Methode schreibt eine �bergebene Liste in die Datei.
	 * @param myList Die zu speichernde Liste.
	 */
	private void writeListInFile(List<Person> myList){
		OutputStream os=null;
		try{
			os=new FileOutputStream(filePath);
			ObjectOutputStream oos=new ObjectOutputStream(os);
			oos.writeObject(myList);

		} catch(IOException e){
			System.err.println("Problem mit dem Dateischreiben: " + e);
		} finally{
			try{
				os.close();
			} catch(Exception e) {
				System.err.println("Problem mit schliessen: " + e);
			}
		}

	}


	@Override
	public boolean passwortAendern(String username, String neuesPasswort) throws BenutzerNotFoundException {
		boolean erfolgreich = false;
		
		List<Person> personenliste = getPersonList();
		for(Person p : personenliste){
			if(p.getUsername().equals(username)){
				p.setPassword(neuesPasswort);
				erfolgreich = true;
				break;
			}
		}
		if(erfolgreich){
			writeListInFile(personenliste);
			return true;
		}
		return false;
	}


	@Override
	public boolean adressdatenAendern(String username, int plz, String strasse, String wohnort, int hausnummer) {
		boolean erfolgreich = false;
		List<Person> personenliste = getPersonList();
		for(Person p : personenliste){
			if(p.getUsername().equals(username)){
				p.setPlz(plz);
				p.setStrasse(strasse);
				p.setWohnort(wohnort);
				p.setHausnummer(hausnummer);
				erfolgreich = true;
				break;
			}
		}
		if(erfolgreich){
			writeListInFile(personenliste);
			return true;
		}
		return false;
	}

}