
package webservice.rest;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import management.Auktionsverwaltung;
import management.Benutzerverwaltung;
import management.Produktgruppeverwaltung;
import management.Produktverwaltung;
import modell.Benutzer;
import modell.Produkt;

@Path("/html/")
public class UserServiceHTML {

	Benutzerverwaltung ben_ver = Benutzerverwaltung.getInstance();
	Produktverwaltung pr_ver = Produktverwaltung.getinstance();
	Auktionsverwaltung ak_ver = Auktionsverwaltung.getInstance();
	Produktgruppeverwaltung pr_gr = Produktgruppeverwaltung.getinstance();

	private static final String SUCCESS_RESULT = "<result>success</result>";
	private static final String FAILURE_RESULT = "<result>failure</result>";

	public UserServiceHTML() {
	}

	// Benutzerverwaltung

	@GET
	@Path("/benutzer")
	@Produces(MediaType.TEXT_HTML)
	public String getBenutzerHTML() {
		List<Benutzer> benutzer = ben_ver.getBenutzerListe();
		StringBuffer html = new StringBuffer("<h1>Benutzer</h1><ul>");
		for (Benutzer b : benutzer) {
			html.append("<li>" + b.getUsername() + "</li>");
		}
		html.append("</ul><br/>");
		html.append("<a href='/html/produkte'>Produkte</a><br/>");
		html.append("<a href='/html/benutzer'>Benutzer</a>");
		html.append("<form action='http://localhost:9999/html/einfrierenBenutzerHTML' method='post'>  "
				+ "Username:<br><input type='text' name='name' id='name'>"
				+ "<br><br> <input type='submit' value='Submit'></form> <br/><br/> "

				+ "<form action='http://localhost:9999/html/benutzerdelete' method='post'>  "
				+ "Username:<br><input type='text' name='name' id='name'>"
				+ " <input type='submit' value='Submit'></form><br/><br/><br/> "
				
				+ "<form action='http://localhost:9999/html/produktAnlegen' method='post'>  "
				+ "Produktname:<input type='text' name='name' >"
				+ "Kategorie:<input type='text' name='kategorie'><br/>"
				+ "Username:<input type='text' name='uname'><br/>"
				+ "Startpreis:<input type='text' name='startpreis'><br/>"
				+ "Dauer:<input type='text' name='dauer'><br/>"
				+ "Beschreibung:<input type='text' name='beschreibung'><br/>"
				+ "<input type='submit' value='Submit'></form> ");
		
		
		return html.toString();
	}

	@GET
	@Path("/produkte")
	@Produces(MediaType.TEXT_HTML)
	public String getProdukteHTML() {
		List<Produkt> produkte = pr_ver.getProduktListe();
		StringBuffer html = new StringBuffer("<h1>Produkte</h1><ul>");
		for (Produkt p : produkte) {
			html.append("<li>" + p.getName() + "</li>");
		}
		html.append("</ul><br/>");
		html.append("<a href='/html/produkte'>Produkte</a><br/>");
		html.append("<a href='/html/benutzer'>Benutzer</a>");
		return html.toString();
	}

	@POST
	@Path("/einfrierenBenutzerHTML")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public String einfrierenBenutzer(@FormParam("name") String name) {

		System.out.println(name);
		boolean einfri = ben_ver.benutzerEinfrieren(name.trim());

		if (einfri == true) {
			return SUCCESS_RESULT;
		} else {
			return FAILURE_RESULT;
		}
	}

	@POST
	@Path("/benutzerdelete")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public String deleteBenutzer(@FormParam("name") String usern) {

		if (ben_ver.benutzerloeschen(usern)) {
			return SUCCESS_RESULT;
		} else {
			return FAILURE_RESULT;
		}
	}

	@POST
	@Path("/produktAnlegen")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public String produktAnlegen(@FormParam("name") String produktname, @FormParam("startpreis") double sp,
			@FormParam("uname") String uname, @FormParam("kategorie") String kate, @FormParam("dauer") int dauer,
			@FormParam("beschreibung") String be) {

		if (pr_ver.produktAnlegen(produktname, sp, uname, kate, dauer, be)) {
			return SUCCESS_RESULT;
		} else {
			return FAILURE_RESULT;
		}
	}

}
