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
		this.myFile=new File(filePath);
		checkIfFileExist();
	}
	
	
	/**
	 * Prüft ob das File, auf welches myFile zeigt auch existiert, falls nicht,
	 * dann wird eines erzeugt.
	 */
	
	public void checkIfFileExist(){

		if(!this.myFile.exists())
			try{
				this.myFile.createNewFile();
			} catch(IOException e1){
				System.out.println("Error: File konnte nicht erstellt werden.");
		}
	}
	
	
	
	/**
	 *Wenn keine Liste enthalten ist, wird eine leere Liste erstellt und
	 * diese zurückgegeben!
	 * 
	 * @return Die Liste der gespeicherten Person.
	 */
	
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
					System.err.println("Fehler beim Schließen: "+e);
			}
		}
		return myList;
	}

	/**
	 *Wenn keine Liste enthalten ist,wird eine leere Liste erstellt und
	 * diese zurückgegeben!
	 * 
	 * @return Die Liste der gespeicherten Benutzer.
	 */
	
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
	
	/**
	 * 
	 * @param id Anhand der eindeutigen ID wird die Person gesucht.
	 * @return Die gefundene Person wird zurückgegeben, oder null wird zurückgeliefert.
	 */
	
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

	/**
	 * 
	 * @param benutzer Die zu speichernde Person.
	 * @return true, falls Vorgang erfolgreich, andernfalls false.
	 */
	
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
	
	/**
	 * 
	 * @param username Anhand diesem eindeutigen Parameter wird die Person gesucht.
	 * @return Die gefundene Person wird zurückgegeben, oder null.
	 */
	
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

	
	/**
	 * 
	 * @param benutzer Die Id der zu löschenden Person als String.
	 * @return true, falls Vorgang erfolgreich, andernfalls false.
	 */
	
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
	
	/**
	 * 
	 * @param benutzer Der Username der einzufrierenden Person als String.
	 * @return true, falls Vorgang erfolgreich, andernfalls false.
	 */
	
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
	
	/**
	 * 
	 * @param benutzer Der Username der einzufrierenden Person als String.
	 * @return true, falls Vorgang erfolgreich, andernfalls false.
	 */
	
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
	 * Noch nicht sicher obb das so bleiben kann ? Vielleicht ist diese Methode unnötig
	 * derzeit noch nicht im Interface vorhanden! Gehört ansonsten entfernt
	 * Prüft ob ein Person in einer gegebenen Liste enthalten ist.
	 * 
	 * @param benutzer Der zu prüfende Person.
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
	 * Diese Methode schreibt eine übergebene Liste in die Datei.
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



	
}