/**
*	Das Packet dient zum persistenten speichern der Benutzer und Produktdaten um spaeter 
*	wieder darauf zugreifen zu koennen.
 * 
 */

package dao;

import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import modell.Produkt;
import modell.Produktgruppe;

/**
 * Diese Klasse implementiert die Interface Klasse ProduktgruppeDAO 

 *
 */
public class SerializedProduktgruppeDAOHibernate implements ProduktgruppeDAO {

	SessionFactory sessionFactory;
	
	public SerializedProduktgruppeDAOHibernate() {
		this.sessionFactory = new Configuration().configure().buildSessionFactory();
	}
	
	/* (non-Javadoc)
	 * @see dao.ProduktgruppeDAO#getProduktgruppeList()
	 */
	@SuppressWarnings({ "unchecked", "deprecation" })
	public List<Produktgruppe> getProduktgruppeList() {
		Session session = sessionFactory.openSession();
		List<Produktgruppe> retour = (List<Produktgruppe>) session.createQuery( "from Produktgruppe" ).list();
		session.close();
		return retour;
	}

	/* (non-Javadoc)
	 * @see dao.ProduktgruppeDAO#getProduktgruppeByName(java.lang.String)
	 */
	@SuppressWarnings({ "unchecked", "deprecation" })
	public Produktgruppe getProduktgruppeByName(String name) { 
		Session session = sessionFactory.openSession();
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
		Session session = sessionFactory.openSession();
		try{
			session.beginTransaction();
			session.save(newProduktgruppe);
			session.getTransaction().commit();
			session.close();
			return true;
		}catch(Exception e){
			session.close();
			return false;
		}
	}


	public boolean produktgruppeLoeschen(String name) { // löschen  mit  ProduktID - Verbesserung ?
		Session session = this.sessionFactory.openSession();
		Produktgruppe pg = this.getProduktgruppeByName(name);
		
		session.beginTransaction();
		
		session.delete(pg);
		
		session.getTransaction().commit();
		session.close();
		return true;	
	}
	
	
	
	@Override
	public boolean produktgruppeAendern(String alterName, String neuerName) {
		Session session = this.sessionFactory.openSession();
		Produktgruppe pg = this.getProduktgruppeByName(alterName);
		if(pg == null){
			System.err.println("SerializedProduktgruppeDAOHibernate:produktgruppeAendern: Produktgruppe mit dem Namen '"+alterName+"' nicht vorhanden!");
			return false;
		}
		if(neuerName.trim().length() == 0 || neuerName.trim().length()!=neuerName.length()){
			System.err.println("SerializedProduktgruppeDAOHibernate:produktgruppeAendern: Der neue Name ist nicht korrekt(leer, oder enthaelt Leerzeichen)!");
			return false;
		}
		if(this.getProduktgruppeByName(neuerName)!=null){
			System.err.println("SerializedProduktgruppeDAOHibernate:produktgruppeAendern: Der Name('"+neuerName+"') ist schon vergeben!");
			return false;
		}
		
		if(!session.isOpen()) session = sessionFactory.openSession();
		session.beginTransaction();
		
		Produktgruppe neu = new Produktgruppe(neuerName);
		
		session.save(neu);
		
		Set<Produkt> liste = pg.getListe();
		for(Produkt p : liste){
			p.setProduktgruppe(neu);
			session.update(p);
		}
		
		session.delete(pg);
		
		session.getTransaction().commit();
		session.close();
		return true;
	}
}

