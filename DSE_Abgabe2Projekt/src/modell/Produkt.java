/**
 * Das Package Modell dient fuer alle Akteure die Akionen und Verwaltungen durchfuehren koennen 
 */
package modell;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import dao.SerializedPersonenDAOHibernate;
import dao.SerializedProduktgruppeDAOHibernate;
/** 
 *  Die Klasse Produkt,dient uns zur Erzeugung von Artikeln, welche zur Auktion benoetigt werden
 */
@Entity
@Table(name = "Produkt")
@XmlRootElement(name = "Produkt")
@XmlAccessorType( XmlAccessType.FIELD)
public class Produkt implements Serializable{
	
	

	@Override
	public String toString(){
		return "Produkt [Name=" + name + ", startpreis="  + startpreis + ", Produkt-Besitzer=" + ownerUsername  +
				", Produktgruppe: "+ produktgruppe.getName() +", Hoechstb.: "+hoechstbietender+", Gebot: "+aktuellesGebot+"]";  
						  
	}
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private UUID produktID;
	private String name;
	private double startpreis;
	private String ownerUsername;
	
	private int dauer;
	private String beschreibung;
	
	@Temporal(TemporalType.DATE)
	private Date startdatum;
	
	@Temporal(TemporalType.DATE)
	private Date enddatum;
	
	private String hoechstbietender;
	private double aktuellesGebot;
	private boolean verkauft = false;
	
	@XmlTransient
	@ManyToOne
	private Produktgruppe produktgruppe;
	
	@XmlTransient
	@ManyToOne
	private Person besitzer;
	
/**
 * 
 * @param Id des Produktes
 * @param name Der Name des Produktes
 * @param startpreis Der Startpreis des Produktes 
 * @param Uname Der Username des Benutzers, welcher das Produkt anlegt
 * @param kategorie Ist eine Kategorie in welcher das Produkt am besten identifiziert wird
 * @param dauer gibt die Dauer der Auktion des Produktes an
 * @param beschreibung Die genau Beschreibung des Produktes
 */
	
	public Produkt(UUID id, String name, double startpreis, String Uname, String produktgruppename, int dauer, String beschreibung){
		setProduktID(id);
		setName(name);
		setStartpreis(startpreis);
		setOwnerUsername(Uname);
		setDauer(dauer);
		setBeschreibung(beschreibung);
		setStartdatum(new Date());
		setEnddatum(dauer);
		setHoechstbietender(Uname);
		setAktuellesGebot(startpreis);
		setProduktgruppe(new SerializedProduktgruppeDAOHibernate().getProduktgruppeByName(produktgruppename));
		setBesitzer(new SerializedPersonenDAOHibernate().getPersonByUsername(Uname));
	}
	
	/**
	 * Fuer Hibernate
	 */
	public Produkt(){}
	
	/**
	 * @return gibt die Auktionsdauer in Tagen zurueck
	 */
	public int getDauer(){
		return dauer;
	}

	/**
	 * @param dauer aendert den Wert der Auktionsdauer 
	 */
	public void setDauer(int dauer){
		this.dauer = dauer;
	}

	/**
	 * @return gibt die genau Produktbeschreibung zurueck
	 */
	public String getBeschreibung(){
		return beschreibung;
	}

	/**
	 * @param beschreibung aendert die Beschreibung des Produktes 
	 */
	public void setBeschreibung(String beschreibung){
		this.beschreibung = beschreibung;
	}



	/**
	 * @return gibt die ID des Produktes zurueck
	 */
	public UUID getProduktID(){
		return produktID;
	}
	/**
	 * @param produktID aendert die ID des Produktes
	 */
	public void setProduktID(UUID produktID){
		this.produktID = produktID;
	}


	/**
	 * @return gibt den Namen des Produktes zurueck
	 */
	public String getName(){
		return name;
	}


	/**
	 * @param name aendert den Namen des Produktes
	 */
	public void setName(String name){
		this.name = name;
	}


	/**
	 * @return gibt den Startpreis des Produktes zurueck
	 */
	public double getStartpreis(){
		return startpreis;
	}


	/**
	 * @param startpreis aendert den Startpreis des Produktes
	 */
	public void setStartpreis(double startpreis){
		this.startpreis = startpreis;
	}


	/**
	 * @return gibt den Usernamen des angelegten Produktes zurueck
	 */
	public String getOwnerUsername(){
		return ownerUsername;
	}


	/**
	 * @param ownerUsername aendert den Besitzername des angelegten Produktes
	 */
	public void setOwnerUsername(String ownerUsername){
		this.ownerUsername = ownerUsername;
	}


	/**
	 * @return gibt den Status des Produktes zurueck
	 */
	public boolean isVerkauft(){
		return verkauft;
	}


	public Person getBesitzer() {
		return besitzer;
	}

	public void setBesitzer(Person besitzer) {
		this.besitzer = besitzer;
	}

	/**
	 * @param verkauft aendert den Status der Produktes 
	 */
	public void setVerkauft(boolean verkauft){
		this.verkauft = verkauft;
	}



	/**
	 * @return gibt das Startdatum des Produktes zurueck
	 */
	public Date getStartdatum(){
		return startdatum;
	}

	/**
	 * @param startdatum wird fuer das Produkt geaendert
	 */
	public void setStartdatum(Date startdatum){
		this.startdatum = startdatum;
	}

	/**
	 * @return gibt den aktuellen Hoechstbietenden zurueck
	 */
	public String getHoechstbietender(){
		return hoechstbietender;
	}

	/**
	 * @param hoechstbietender aendert den Hoechstbietenden
	 */
	public void setHoechstbietender(String hoechstbietender){
		this.hoechstbietender = hoechstbietender;
	}

	/**
	 * @return gibt das aktuelle Gebot zurueck
	 */
	public double getAktuellesGebot(){
		return aktuellesGebot;
	}

	/**
	 * @param aktuelles Gebot wird geaendert 
	 */
	public void setAktuellesGebot(double aktuellesGebot){
		this.aktuellesGebot = aktuellesGebot;
	}
	/**
	 * @return das Enddatum wird zurueckgeliefert
	 */
	public Date getEnddatum(){
		return enddatum;
	}

	/**
	 * @param dauer des Produkts wird geaendert
	 */
	public void setEnddatum(int dauer){
		
			Date now = new Date();
	        Calendar calendar = new GregorianCalendar();
	        
	        calendar.setTime(now);
	        calendar.add(Calendar.DAY_OF_MONTH, dauer);
	        Date future = calendar.getTime();
	        DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy 'um' HH:mm:ss");
	        
	        System.out.println("Now:    " + dateFormat.format(now));
	        System.out.println("Future: " + dateFormat.format(future));
	        this.enddatum = future;

	}
	
	public Produktgruppe getProduktgruppe() {
		return produktgruppe;
	}
	public void setProduktgruppe(Produktgruppe produktgruppe) {
		this.produktgruppe = produktgruppe;
	}
	public void setEnddatum(Date enddatum) {
		this.enddatum = enddatum;
	}
}
