
package webservice.rest;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import management.Auktionsverwaltung;
import management.Benutzerverwaltung;
import management.Produktgruppeverwaltung;
import management.Produktverwaltung;
import modell.Benutzer;
import modell.Produkt;

@Path("/json/")
public class UserServiceJSON{

	Benutzerverwaltung ben_ver = Benutzerverwaltung.getInstance();
	Produktverwaltung pr_ver = Produktverwaltung.getinstance();
	Auktionsverwaltung ak_ver = Auktionsverwaltung.getInstance();
	Produktgruppeverwaltung pr_gr = Produktgruppeverwaltung.getinstance();


	public UserServiceJSON() {
	}


	

	@GET
	@Path("/benutzer")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getBenutzerJSON() {
		GenericEntity<List<Benutzer>> entity =  new GenericEntity<List<Benutzer>>((List<Benutzer>) ben_ver.getBenutzerListe()) {};
		return Response.ok()
        		.entity(entity)
        		.header("Access-Control-Allow-Origin", "*")
    			.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
    			.allow("OPTIONS").build();
	}

	@GET
	@Path("/produkte")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getProdukteJSON() {
		
		GenericEntity<List<Produkt>> entity =  new GenericEntity<List<Produkt>>((List<Produkt>) pr_ver.getProduktListe()) {};
        return Response.ok()
        		.entity(entity)
        		.header("Access-Control-Allow-Origin", "*")
    			.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
    			.allow("OPTIONS").build();
	}
	
	@GET
    @Path("/benutzer/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getBenutzerByUsernameJSON(@PathParam("name") String name) {
		
        return Response.ok()
        		.entity((Benutzer) ben_ver.getPersonByUsername(name))
        		.header("Access-Control-Allow-Origin", "*")
    			.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
    			.allow("OPTIONS").build();
    }

	@GET
    @Path("/produkte/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getProduktByIDJSON(@PathParam("name") String name) {
		 GenericEntity<List<Produkt>> entity =  new GenericEntity<List<Produkt>>((List<Produkt>) pr_ver.sucheProdukt(name)) {};

        return Response.ok()
        		.entity(entity)
        		.header("Access-Control-Allow-Origin", "*")
    			.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
    			.allow("OPTIONS").build();
    }



}
