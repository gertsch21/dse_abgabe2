/**
 * Das Packet dient zum persistenten speichern der Benutzer und Produktdaten um spaeter 
*	wieder darauf zugreifen zu koennen.
 */

package dao;

import java.util.List;
import java.util.Set;
import java.util.UUID;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import modell.Produkt;
import modell.Produktgruppe;
/**
 * Diese Klasse implementiert die Interface Klasse ProduktDAO 

 */


public class SerializedProduktDAOHibernate implements ProduktDAO {
	SessionFactory sessionFactory;
	Session session;
	
	public SerializedProduktDAOHibernate() {
		this.sessionFactory = new Configuration().configure().buildSessionFactory();
		this.session = sessionFactory.openSession();
	}
	
 
	/* (non-Javadoc)
	 * @see dao.ProduktDAO#getProduktList()
	 */
	@Override
	public List<Produkt> getProduktList() { 
		this.session = sessionFactory.openSession();
		List<Produkt> retour = (List<Produkt>) session.createQuery( "from Produkt" ).list();
		this.session.close();
		return retour;		
	}

	@Override
	public Produkt getProduktByID(String id) { 
		this.session = sessionFactory.openSession();
		List<Produkt> produktliste = (List<Produkt>) session.createQuery( "from Produkt" ).list();
		Produkt retour = null;
		
		for(Produkt p : produktliste){
			if(p.getProduktID().toString().equals(id)){
				retour = p;
				break;
			}
		}
		this.session.close();
		return retour;
	}
	

	/* (non-Javadoc)
	 * @see dao.ProduktDAO#produktAnlegen(modell.Produkt)
	 */
	@Override
	public boolean produktAnlegen(Produkt newProdukt) {
		this.session = sessionFactory.openSession();
		try{
			
			session.beginTransaction();
			session.save(newProdukt);
			session.getTransaction().commit();
			this.session.close();
			return true;
		}catch(Exception e){
			this.session.close();
			return false;
		}
	}

	/* (non-Javadoc)
	 * @see dao.ProduktDAO#produktLoeschen(java.lang.String)
	 */
	@Override
	public boolean produktLoeschen(String deleteID) { // löschen  mit  ProduktID - Verbesserung ?
		this.session = sessionFactory.openSession();
		List<Produkt> produktliste = (List<Produkt>) session.createQuery( "from Produkt" ).list();
		Produkt zuLoeschen = null;
		
		for(Produkt p : produktliste){
			if(p.getProduktID().toString().equals(deleteID)){
				System.out.println(deleteID + " , " + p.getProduktID());
				zuLoeschen = p;
				break;
			}
		}
		System.out.println("Es wird gelöscht: "+deleteID + ", " + zuLoeschen);
		if(zuLoeschen == null){
			this.session.close();
			return false;//keine Person
		}
		System.out.println("Es wird gelöscht: "+deleteID);
		session.beginTransaction();
		session.delete(zuLoeschen);
		session.getTransaction().commit();
		this.session.close();
		return false;
		
	}
	
	
	@Override
	public boolean produktVerschieben(UUID id,String kategorie){
		this.session = sessionFactory.openSession();
		Produkt produktZuVerschieben = this.getProduktByID(id.toString());
		Produktgruppe neuePG = new SerializedProduktgruppeDAOHibernate().getProduktgruppeByName(kategorie);
		
		if(produktZuVerschieben==null){
			System.err.println("SerializedProduktDAOHibernate:ProduktVerschieben: Das Produkt mit der id('"+id+") existiert nicht!");
			this.session.close();
			return false;
		}
		if(neuePG==null){
			System.err.println("SerializedProduktDAOHibernate:ProduktVerschieben: Die Produktgruppe mit dem Namen '"+kategorie+"' existiert nicht!");
			this.session.close();
			return false;
		}
		
		
		Produktgruppe altePG = produktZuVerschieben.getProduktgruppe();
		
		Set<Produkt> produktlisteDerAltenPG = altePG.getListe();
		produktlisteDerAltenPG.remove(produktZuVerschieben);
		altePG.setListe(produktlisteDerAltenPG);
		
		Set<Produkt> produktlisteDerNeuenPG = neuePG.getListe();
		produktlisteDerNeuenPG.add(produktZuVerschieben);
		neuePG.setListe(produktlisteDerNeuenPG);
		
		produktZuVerschieben.setProduktgruppe(neuePG);
		
		session.beginTransaction();
		session.update(produktZuVerschieben);
		session.update(altePG);
		session.update(neuePG);
		session.getTransaction().commit();
		
		this.session.close();
		return true;
	}
	
	

	@Override
	public boolean produktBekommtNeuesGebot(String produktID, String username, double gebot) {
		this.session = sessionFactory.openSession();
		Produkt p = this.getProduktByID(produktID);
		if(p == null){
			this.session.close();
			return false; //person nicht in db
		}
		
		p.setHoechstbietender(username);
		p.setAktuellesGebot(gebot);
			
		session.beginTransaction();
		session.update(p);
		session.getTransaction().commit();
		
		this.session.close();
		return true;
	}
	

}
