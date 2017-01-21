/**
 * Das Package Modell dient fuer alle Akteure die Akionen und Verwaltungen durchfuehren koennen 
 */
package modell;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Die Klasse Produktgruppe dient als Grundlage fuer alle Produkte, um sie in Kategorien zu Verwalten.
 *
 */
@Entity
@Table(name="Produktgruppe")
@XmlRootElement(name = "Produktgruppe")
public class Produktgruppe implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "produktgruppenname")
	private String name;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy="produktgruppe")
	private Set<Produkt> liste;
	
	

	@Override
	public String toString() {
		return "Produktgruppe [name=" + name + ", listeProdukte=" + liste + "]";
	}

	

	public Produktgruppe(String name){
		setName(name);
		setListe(new HashSet<Produkt>());
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
	public Set<Produkt> getListe(){
		return liste;
	}

	/**
	 * @param aendert eine Liste mit den Produkten
	 */
	public void setListe(Set<Produkt> liste){
		this.liste = liste;
	}	
	
	public Produkt getProduct(String id){
		for(Produkt p : liste)
			if(p.getProduktID().toString().equals(id))
				return p;
		return null;
	}
}