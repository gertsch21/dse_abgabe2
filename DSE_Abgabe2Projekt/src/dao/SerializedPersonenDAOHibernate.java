package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import modell.Benutzer;
import modell.Person;

public class SerializedPersonenDAOHibernate implements PersonDAO{

	SessionFactory sessionFactory;
	Session session;
	
	public SerializedPersonenDAOHibernate() {
		this.sessionFactory = new Configuration().configure().buildSessionFactory();
	}
	
	@SuppressWarnings({ "unchecked", "deprecation" })
	@Override
	public List<Person> getPersonList() {
		this.session = sessionFactory.openSession();
		List<Person> retour = (List<Person>) session.createQuery( "from Person" ).list();
		this.session.close();
		return retour;
	}

	@SuppressWarnings({ "unchecked", "deprecation" })
	@Override
	public List<Benutzer> getBenutzerList() {
		this.session = sessionFactory.openSession();
		List<Benutzer> retour = (List<Benutzer>) session.createQuery( "from Benutzer" ).list();
		session.close();
		this.session.close();
		return retour;
	}

	@SuppressWarnings({ "unchecked", "deprecation" })
	@Override
	public Person getPersonById(String id) {
		this.session = sessionFactory.openSession();
		List<Person> personenliste = (List<Person>) session.createQuery( "from Person" ).list();
		Person retour = null;
		
		for(Person p : personenliste){
			if(p.getId().toString().equals(id)){
				retour = p;
				break;
			}
		}
		this.session.close();
		return retour;
	}

	@SuppressWarnings({ "unchecked", "deprecation" })
	@Override
	public Person getPersonByUsername(String username) {
		this.session = sessionFactory.openSession();
		
		List<Person> personenliste = (List<Person>) session.createQuery( "from Person" ).list();
		
		for(Person p : personenliste)
			if(p.getUsername().equals(username)){
				this.session.close();
				return p;
			}
		this.session.close();
		return null;
	}

	@Override
	public boolean speicherePerson(Person benutzer) {
		
		if(benutzer.getUsername().length()<=5 || benutzer.getPassword().length()<=5){
			System.err.println("SerializedPersonenDAOHibernate:speicherePerson:Username oder Passwort zu kurz('"+benutzer.getUsername()+", "+benutzer.getPassword()+"')");
			return false;
		}

		
		try{
			this.session = sessionFactory.openSession();
			session.beginTransaction();
			session.save(benutzer);
			session.getTransaction().commit();
			this.session.close();
			return true;
		}catch(Exception e){
			this.session.close();
			return false;
		}
	}

	@SuppressWarnings({ "unchecked", "deprecation" })
	@Override
	public boolean loeschePerson(String username) {
		this.session = sessionFactory.openSession();
		List<Person> personenliste = (List<Person>) session.createQuery( "from Person" ).list();
		Person zuLoeschen = null;
		
		for(Person p : personenliste){
			if(p.getUsername().equals(username)){
				zuLoeschen = p;
				break;
			}
		}
		if(zuLoeschen == null) {
			this.session.close();
			return false;//keine Person
		}
		
		session.beginTransaction();
		session.delete(zuLoeschen);
		session.getTransaction().commit();
		this.session.close();
		return true;
	}

	@Override
	public boolean einfrierenPerson(String benutzer) {
		this.session = sessionFactory.openSession();
		Person p = this.getPersonByUsername(benutzer);
		if(p == null){
			this.session.close();
			return false;//person nicht in db
		}
		if(!(p instanceof Benutzer)){
			this.session.close();
			return false;
		}
		
		((Benutzer)p).setIstEingefroren(true);
		
		session.beginTransaction();
		session.update(p);
		session.getTransaction().commit();
		this.session.close();
		return true;
	}

	@Override
	public boolean einfrierenAufheben(String benutzer) {
		this.session = sessionFactory.openSession();
		Person p = this.getPersonByUsername(benutzer);
		if(p == null) {
			this.session.close();
			return false; //person nicht in db
		}
		if(!(p instanceof Benutzer)){
			this.session.close();
			return false;
		}
		
		((Benutzer)p).setIstEingefroren(false);
		
		session.beginTransaction();
		session.update(p);
		session.getTransaction().commit();
		
		this.session.close();
		return true;
	}

	@Override
	public boolean passwortAendern(String username, String neuesPasswort) {
		this.session = sessionFactory.openSession();
		Person p = this.getPersonByUsername(username);
		if(p == null) {
			this.session.close();
			return false; //person nicht in db
		}
		
		if(neuesPasswort.length()<=5){
			System.err.println("SerializedPersonenDAOHibernate:passwortAendern:neuesPasswort zu kurz");
			return false;
		}
		
		p.setPassword(neuesPasswort);
		
		session.beginTransaction();
		session.update(p);
		session.getTransaction().commit();
		
		this.session.close();
		return true;
	}

	@Override
	public boolean adressdatenAendern(String username, int plz, String strasse, String wohnort, int hausnummer) {
		this.session = sessionFactory.openSession();
		Person p = this.getPersonByUsername(username);
		if(p == null){
			this.session.close();
			return false; //person nicht in db
		}
		
		p.setPlz(plz);
		p.setStrasse(strasse);
		p.setWohnort(wohnort);
		p.setHausnummer(hausnummer);
		
		session.beginTransaction();
		session.update(p);
		session.getTransaction().commit();
		
		this.session.close();
		return true;
	}
}
