package webservice.soap;

import org.apache.cxf.endpoint.Server;
import org.apache.cxf.jaxws.JaxWsServerFactoryBean;
import org.apache.cxf.service.Service;

import soap.services.*;

public class SoapServer {
	/**
	 * Dieser Konstruktor macht es moeglich, dass man auf eine URI die Services abrufen kann
	 * @throws Exception wird nur geworfen, wenn ein grober Fehler entstanden ist, Gruende darfuer koennen mannigfach sein
	 */
	protected SoapServer() throws Exception {
		System.out.println("Starting Server");
		AlleServicesSEI serviceImpl = new AlleServices();
		JaxWsServerFactoryBean svrFactory = new JaxWsServerFactoryBean();
		svrFactory.setServiceClass(AlleServices.class);
		svrFactory.setAddress("http://localhost:9000/AlleServices");
		svrFactory.setServiceBean(serviceImpl);
		Server server =  svrFactory.create();
		Service service = server.getEndpoint().getService();
	 }

	
	/**
	 * Diese Methode startet den Server, indem es eine Instanz von dieser Klasse anlegt
	 * @param args nicht benoetigt hier
	 * @throws Exception 
	 */
	public static void main(String args[]) {
		try{
			new SoapServer();
			System.out.println("Server wurde erfolgreich gestartet...");
		}catch(Exception e){
			System.err.println("Server konnte nicht gestartet werden: "+e.getMessage());
			System.exit(0);
		}
	}
}
