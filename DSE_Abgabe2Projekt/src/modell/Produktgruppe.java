/**
 * Das Package Modell dient fuer alle Akteure die Akionen und Verwaltungen durchfuehren koennen 
 */
package modell;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Die Klasse Produktgruppe dient als Grundlage fuer alle Produkte, um sie in Kategorien zu Verwalten.
 *
 */
@Entity
@Table(name="Produktgruppe")
public class Produktgruppe implements Serializable{

	@Override
	public String toString() {
		return "Produktgruppe [name=" + name + ", liste=" + liste + "]";
	}

	
	@Id
	@Column(name = "produktgruppenname")
	private String name;
	
	@OneToMany()
	private List<Produkt> liste;
	
	
	public Produktgruppe(String name){
		setName(name);
		setListe(new ArrayList<Produkt>());
	}
	
	/**
	 * Fuer Hibernate
	 */
	public Produktgruppe(){}

	/**
	 * @return gibt den Namen der Produktgruppe zurueck
	 */
	public String getName(){
		return name;
	}

	/**
	 * @param aendert den Namen der Produktgruppe auf einen gewuenschten Wert
	 */
	public void setName(String name){
		this.name = name;
	}

	/**
	 * @return gibt eine Liste mit allen Produkten zurueck
	 */
	public List<Produkt> getListe(){
		return liste;
	}

	/**
	 * @param aendert eine Liste mit den Produkten
	 */
	public void setListe(List<Produkt> liste){
		this.liste = new ArrayList<Produkt>();
	}	
	
	public Produkt getProduct(String id){
		for(Produkt p : liste)
			if(p.getProduktID().toString().equals(id))
				return p;
		return null;
	}
}