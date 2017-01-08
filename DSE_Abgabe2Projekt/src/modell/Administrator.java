package modell;

import java.util.UUID;

import javax.persistence.Entity;

/**
 * Die Klasse Administrator dient zur Verwaltung aller Benutzer und Produkte die registriert sind. 
 */
@Entity
public class Administrator extends Benutzer {
	

	@Override
	public String toString() {
		return "Administrator [gehalt=" + gehalt + ", toString()=" + super.toString() + ", getIstEingefroren()="
				+ getIstEingefroren() + ", getId()=" + getId() + ", getVorname()=" + getVorname() + ", getNachname()="
				+ getNachname() + ", getEmail()=" + getEmail() + ", getPlz()=" + getPlz() + ", getStrasse()="
				+ getStrasse() + ", getWohnort()=" + getWohnort() + ", getHausnummer()=" + getHausnummer()
				+ ", getUsername()=" + getUsername() + ", getPassword()=" + getPassword() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + "]";
	}

	private static final long serialVersionUID = 1L;
	double gehalt;
	
	/**
	 * @param id Die id des jeweiligen Administrators.
	 * @param vorname Der Vorname des des jeweiligen Administrators.
	 * @param nachname Der Nachname des jeweiligen Administrators.
	 * @param email Die email des jeweiligen Administrators.
	 * @param strasse Die Strasse in der der jeweilige Administrator gemeldet ist.
	 * @param wohnort Der Wohnort, in dem der jeweilige Administrator gemeldet ist.
	 * @param username Der eindeutige Username des jeweiligen Administrators.(min 5 Zeichen)
	 * @param password Das Passwort des jeweiligen Administrators.(min 5 Zeichen) 
	 * @param gehalt Das Gehalt des Administrators.
	 */
	public Administrator(UUID id, String vorname, String nachname, String email, 
			 int plz, String strasse, String wohnort, int hausnummer, String username,
			String password,double gehalt) {
		super(id, vorname, nachname, email, plz, strasse, wohnort, hausnummer, username,
				password);
		setGehalt(gehalt);
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Standardkonstruktor fuer Hibernate
	 */
	public Administrator(){}
	
	/**
	 * 
	 * @return Das Gehalt des Administrators.
	 */
	public double getGehalt() {
		return gehalt;
	}
	
	/**
	 * 
	 * @param gehalt Das Gehalt des Administrators.
	 */
	public void setGehalt(double gehalt) {
		this.gehalt = gehalt;
	}

}
