
package modell;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;


/**
 * 
 *Die Klasse Person ist eine Abstrakte Klasse und dient als Vorlage fuer Benutzer und Administrator
 */
@Entity
public abstract class Person implements Serializable {
	
	



	@Override
	public String toString() {
		return "Person [id=" + id + ", vorname=" + vorname + ", nachname=" + nachname + ", email=" + email + ", plz="
				+ plz + ", strasse=" + strasse + ", wohnort=" + wohnort + ", hausnummer=" + hausnummer + ", username="
				+ username + ", password=" + password + "]";
	}

	private static final long serialVersionUID = 1L;
	@Id
	private UUID id;
	private String vorname;
	private String nachname;
	private String email;
	
	private int plz;
	private String strasse;
	private String wohnort;
	private int hausnummer;
	
	@Column(unique=true)
	private String username;
	
	private String password;
	
	
	/**
	 * @param id Die id der jeweiligen Person.
	 * @param vorname Der Vorname der des jeweiligen Person.
	 * @param nachname Der Nachname der jeweiligen Person.
	 * @param email Die email der jeweiligen Person.
	 * @param strasse Die Strasse in der die jeweilige Person gemeldet ist.
	 * @param wohnort Der Wohnort, in dem die jeweilige Person gemeldet ist.
	 * @param username Der eindeutige Username der jeweiligen Person.(min 5 Zeichen)
	 * @param password Das Passwort der jeweiligen Person.(min 5 Zeichen) 
	 */
	public Person(UUID id, String vorname, String nachname, String email,
			int plz, String strasse, String wohnort, int hausnummer, String username, String password) {
		setId(id);
		setVorname(vorname);
		setNachname(nachname);
		setEmail(email);
		setPlz(plz);
		setStrasse(strasse);
		setWohnort(wohnort);
		setHausnummer(hausnummer);
		setUsername(username);
		setPassword(password);
	}
	
	/**
	 * Standardkonstruktor fuer Hibernate
	 */
	public Person(){}
	
	/**
	 * 
	 * @return Die id der jeweiligen Person.
	 */
	public UUID getId() {
		return id;
	}
	/**
	 * 
	 * @param id Die neue id der jeweiligen Person.
	 */
	public void setId(UUID id) {
		this.id = id;
	}
	
	/**
	 * 
	 * @return Der Vorname der jeweiligen Person
	 */
	public String getVorname() {
		return vorname;
	}
	
	/**
	 * 
	 * @param vorname Der neue Vorname der jeweiligen Person
	 */
	public void setVorname(String vorname) {
		this.vorname = vorname;
	}
	
	/**
	 * 
	 * @return Der Nachname der jeweiligen Person
	 */
	public String getNachname() {
		return nachname;
	}
	
	/**
	 * 
	 * @param nachname Der neue Nachname der jeweiligen Person
	 */
	public void setNachname(String nachname) {
		this.nachname = nachname;
	}
	
	/**
	 * 
	 * @return Die Email der Person.
	 */
	public String getEmail() {
		return email;
	}
	
	/**
	 * 
	 * @param email Der neue Email der jeweiligen Person
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	/**
	 * 
	 * @return Die Postleitzahl der Person
	 */
	public int getPlz() {
		return plz;
	}
	
	/**
	 * 
	 * @param plz Die Postleitzahl der Person
	 */
	public void setPlz(int plz) {
		this.plz = plz;
	}
	/**
	 * 
	 * @return Die Strasse der jeweiligen Person
	 */
	public String getStrasse() {
		return strasse;
	}
	
	/**
	 * 
	 * @param strasse Die neue Strasse der jeweiligen Person
	 */
	public void setStrasse(String strasse) {
		this.strasse = strasse;
	}
	
	/**
	 * 
	 * @return Der Wohnort der jeweiligen Person
	 */
	public String getWohnort() {
		return wohnort;
	}
	
	/**
	 * 
	 * @param wohnort Der neue Wohnort der jeweiligen Person
	 */
	public void setWohnort(String wohnort) {
		this.wohnort = wohnort;
	}
	
	/**
	 * 
	 * @return Die Hausnummer der Person
	 */
	public int getHausnummer() {
		return hausnummer;
	}
	
	/**
	 * 
	 * @param hausnummer Die Hausnummer der Person
	 */
	public void setHausnummer(int hausnummer) {
		this.hausnummer = hausnummer;
	}
	/**
	 * 
	 * @return Der Username der jeweiligen Person
	 */
	public String getUsername() {
		return username;
	}
	
	/**
	 * 
	 * @param username Der neue Username der jeweiligen Person
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	
	/**
	 * 
	 * @return Das Passwort der jeweiligen Person
	 */
	public String getPassword() {
		return password;
	}
	
	/**
	 * 
	 * @param password Das neue Passwort der jeweiligen Person
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
}
