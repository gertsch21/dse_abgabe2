/**
 * Das Package Modell dient fuer alle Akteure die Akionen und Verwaltungen durchfuehren koennen 
 */
package modell;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

public class ProduktOhneGruppe implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private UUID produktID;
	private String name;
	private double startpreis;
	private String ownerUsername;

	private int dauer;
	private String beschreibung;

	private Date startdatum;

	private Date enddatum;

	private String hoechstbietender;
	private double aktuellesGebot;
	private boolean verkauft = false;

	private String produktgruppe;

	private String besitzer;

	
	
	
	@Override
	public String toString() {
		return "ProduktOhneGruppe [produktID=" + produktID + ", name=" + name + ", startpreis=" + startpreis
				+ ", ownerUsername=" + ownerUsername + ", dauer=" + dauer + ", beschreibung=" + beschreibung
				+ ", startdatum=" + startdatum + ", enddatum=" + enddatum + ", hoechstbietender=" + hoechstbietender
				+ ", aktuellesGebot=" + aktuellesGebot + ", verkauft=" + verkauft + ", produktgruppe=" + produktgruppe
				+ ", besitzer=" + besitzer + "]";
	}

	public ProduktOhneGruppe(UUID produktID, String name, double startpreis, String ownerUsername, int dauer,
			String beschreibung, Date startdatum, Date enddatum, String hoechstbietender, double aktuellesGebot,
			boolean verkauft, String produktgruppe, String besitzer) {
		super();
		this.produktID = produktID;
		this.name = name;
		this.startpreis = startpreis;
		this.ownerUsername = ownerUsername;
		this.dauer = dauer;
		this.beschreibung = beschreibung;
		this.startdatum = startdatum;
		this.enddatum = enddatum;
		this.hoechstbietender = hoechstbietender;
		this.aktuellesGebot = aktuellesGebot;
		this.verkauft = verkauft;
		this.produktgruppe = produktgruppe;
		this.besitzer = besitzer;
	}

	public UUID getProduktID() {
		return produktID;
	}

	public void setProduktID(UUID produktID) {
		this.produktID = produktID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getStartpreis() {
		return startpreis;
	}

	public void setStartpreis(double startpreis) {
		this.startpreis = startpreis;
	}

	public String getOwnerUsername() {
		return ownerUsername;
	}

	public void setOwnerUsername(String ownerUsername) {
		this.ownerUsername = ownerUsername;
	}

	public int getDauer() {
		return dauer;
	}

	public void setDauer(int dauer) {
		this.dauer = dauer;
	}

	public String getBeschreibung() {
		return beschreibung;
	}

	public void setBeschreibung(String beschreibung) {
		this.beschreibung = beschreibung;
	}

	public Date getStartdatum() {
		return startdatum;
	}

	public void setStartdatum(Date startdatum) {
		this.startdatum = startdatum;
	}

	public Date getEnddatum() {
		return enddatum;
	}

	public void setEnddatum(Date enddatum) {
		this.enddatum = enddatum;
	}

	public String getHoechstbietender() {
		return hoechstbietender;
	}

	public void setHoechstbietender(String hoechstbietender) {
		this.hoechstbietender = hoechstbietender;
	}

	public double getAktuellesGebot() {
		return aktuellesGebot;
	}

	public void setAktuellesGebot(double aktuellesGebot) {
		this.aktuellesGebot = aktuellesGebot;
	}

	public boolean isVerkauft() {
		return verkauft;
	}

	public void setVerkauft(boolean verkauft) {
		this.verkauft = verkauft;
	}

	public String getProduktgruppe() {
		return produktgruppe;
	}

	public void setProduktgruppe(String produktgruppe) {
		this.produktgruppe = produktgruppe;
	}

	public String getBesitzer() {
		return besitzer;
	}

	public void setBesitzer(String besitzer) {
		this.besitzer = besitzer;
	}

}
