/**
 * Das Packet dient zum persistenten speichern der Benutzer und Produktdaten um spaeter 
*	wieder darauf zugreifen zu koennen.
 */

package dao;

import java.util.List;
import java.util.UUID;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import modell.Produkt;
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
		List<Produkt> retour = (List<Produkt>) session.createQuery( "from Produkt" ).list();
		return retour;		
	}

	@Override
	public Produkt getProduktByID(String id) { 
		List<Produkt> produktliste = (List<Produkt>) session.createQuery( "from Produkt" ).list();
		Produkt retour = null;
		
		for(Produkt p : produktliste){
			if(p.getProduktID().toString().equals(id)){
				retour = p;
				break;
			}
		}
		return retour;
	}
	

	/* (non-Javadoc)
	 * @see dao.ProduktDAO#produktAnlegen(modell.Produkt)
	 */
	@Override
	public boolean produktAnlegen(Produkt newProdukt) {
		try{
			session.beginTransaction();
			session.save(newProdukt);
			session.getTransaction().commit();
			return true;
		}catch(Exception e){
			return false;
		}
	}

	/* (non-Javadoc)
	 * @see dao.ProduktDAO#produktLoeschen(java.lang.String)
	 */
	@Override
	public boolean produktLoeschen(String deleteID) { // löschen  mit  ProduktID - Verbesserung ?
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
		if(zuLoeschen == null) return false;//keine Person
		System.out.println("Es wird gelöscht: "+deleteID);
		session.beginTransaction();
		session.delete(zuLoeschen);
		session.getTransaction().commit();
		return false;
		
	}
	
	
	@Override
	public boolean produktVerschieben(UUID id,String kategorie){
		
		return false;
	}
	

}
