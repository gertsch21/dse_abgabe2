/**
 * Das Package Modell dient fuer alle Akteure die Akionen und Verwaltungen durchfuehren koennen 
 */
package modell;

import java.util.UUID;


/**
 * Die Klasse Benutzer ist eine Subklasse von der Klasse Person und repr�sentiert die Benutzer
 */
public class Benutzer extends Person{
	
	
	boolean istEingefroren;
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 * @param id Die id des jeweiligen Benutzers.
	 * @param vorname Der Vorname des des jeweiligen Benutzers.
	 * @param nachname Der Nachname des jeweiligen Benutzers.
	 * @param email Die email des jeweiligen Benutzers.
	 * @param strasse Die Strasse in der der jeweilige Benutzer gemeldet ist.
	 * @param wohnort Der Wohnort, in dem der jeweilige Benutzer gemeldet ist.
	 * @param username Der eindeutige Username des jeweiligen Benutzers.
	 * @param password Das Passwort des jeweiligen Benutzers.
	 */
	public Benutzer(UUID id, String vorname, String nachname, String email,
			String strasse, String wohnort, String username, String password){
			super(id,vorname,nachname,email,strasse,wohnort,username,password);
			
			istEingefroren = false;
	}

	/**
	 * @return istEingefroren Ist true, falls der User eingefroren wurde und somit temporaer keine Berechtigung mehr hat. 
	 */
	public boolean getIstEingefroren(){
		return istEingefroren;
	}

	/**
	 * @param istEingefroren Um den Benutzer einzufrieren oder aufzutauen(true zum einfrieren, false zum auftauen)
	 */
	public void setIstEingefroren(boolean istEingefroren){
		this.istEingefroren = istEingefroren;
	}
	
	

}