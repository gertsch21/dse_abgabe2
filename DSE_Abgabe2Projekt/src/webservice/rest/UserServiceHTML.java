package webservice.rest;

import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.CacheControl;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.core.Response.Status;

import management.Auktionsverwaltung;
import management.Benutzerverwaltung;
import management.Produktgruppeverwaltung;
import management.Produktverwaltung;
import modell.Benutzer;
import modell.Produkt;
import modell.Produktgruppe;

@Path("/html/")
public class UserServiceHTML {

	Benutzerverwaltung ben_ver = Benutzerverwaltung.getInstance();
	Produktverwaltung pr_ver = Produktverwaltung.getinstance();
	Auktionsverwaltung ak_ver = Auktionsverwaltung.getInstance();
	Produktgruppeverwaltung pr_gr = Produktgruppeverwaltung.getinstance();

	
	private static final String path = "/html";
	private static final String SUCCESS_RESULT = "<result>success</result>";
	private static final String FAILURE_RESULT = "<result>failure</result>";

	// Benutzerverwaltung

	@GET
	@Path("/benutzer")
	@Produces(MediaType.TEXT_HTML)
	public String getProdukteHTML() {
		List<Benutzer> benutzer = ben_ver.getBenutzerListe();
		StringBuffer html = new StringBuffer("<h1>Benutzer</h1><ul>");
		for(Benutzer b : benutzer){
			html.append("<li>"+b.getUsername()+"/li");
		}
		html.append("</ul><br/>");
		html.append("");
		return html.toString();
	}
	
	@GET
	@Path("/produkte")
	@Produces(MediaType.TEXT_HTML)
	public String getprodukteHTML() {
		List<Produkt> produkte = pr_ver.getProduktListe();
		StringBuffer html = new StringBuffer("<h1>Produkte</h1><ul>");
		for(Produkt p : produkte){
			html.append("<li>"+p.getName()+"/li");
		}
		html.append("</ul><br/>");
		html.append("");
		return html.toString();
	}
	
	
}
