/**
*	Das Packet dient zum persistenten speichern der Benutzer und Produktdaten um spaeter 
*	wieder darauf zugreifen zu koennen.
 * 
 */

package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


import modell.Produktgruppe;

/**
 * Diese Klasse implementiert die Interface Klasse ProduktgruppeDAO 

 *
 */
public class SerializedProduktgruppeDAOHibernate implements ProduktgruppeDAO {

	SessionFactory sessionFactory;
	Session session;
	
	public SerializedProduktgruppeDAOHibernate() {
		this.sessionFactory = new Configuration().configure().buildSessionFactory();
		this.session = sessionFactory.openSession();
	}
	
	/* (non-Javadoc)
	 * @see dao.ProduktgruppeDAO#getProduktgruppeList()
	 */
	public List<Produktgruppe> getProduktgruppeList() {
		List<Produktgruppe> retour = (List<Produktgruppe>) session.createQuery( "from Produktgruppe" ).list();
		return retour;
	}

	/* (non-Javadoc)
	 * @see dao.ProduktgruppeDAO#getProduktgruppeByName(java.lang.String)
	 */
	public Produktgruppe getProduktgruppeByName(String name) { 
		
		List<Produktgruppe> produktgruppeliste = (List<Produktgruppe>) session.createQuery( "from Produktgruppe" ).list();
		Produktgruppe retour = null;
		
		for(Produktgruppe p : produktgruppeliste){
			if(p.getName().toString().equals(name)){
				System.out.println(p);
				retour = p;
				break;
			}
		}
		
		session.close();
		return retour;
		
	}

	/* (non-Javadoc)
	 * @see dao.ProduktgruppeDAO#produktgruppeAnlegen(modell.Produktgruppe)
	 */
	public boolean produktgruppeAnlegen(Produktgruppe newProduktgruppe) {
		try{
			session.beginTransaction();
			session.save(newProduktgruppe);
			session.getTransaction().commit();
			return true;
		}catch(Exception e){
			return false;
		}
	}


	public boolean produktgruppeLoeschen(String name) { // löschen  mit  ProduktID - Verbesserung ?
		return false;
	}
	
	
	
	@Override
	public boolean produktgruppeAendern(String alterName, String neuerName) {
		return false;
	}
}

