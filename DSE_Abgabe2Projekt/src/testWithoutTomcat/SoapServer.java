package testWithoutTomcat;

import org.apache.cxf.endpoint.Server;
import org.apache.cxf.jaxws.JaxWsServerFactoryBean;
import org.apache.cxf.service.Service;

import soap.services.*;

public class SoapServer {
	protected SoapServer() throws Exception {
		System.out.println("Starting Server");
		Benutzerservices serviceImpl = new Benutzerservices();
		JaxWsServerFactoryBean svrFactory = new JaxWsServerFactoryBean();
		svrFactory.setServiceClass(Benutzerservices.class);
		svrFactory.setAddress("http://localhost:9000/Benutzerservice");
		svrFactory.setServiceBean(serviceImpl);
		Server server =  svrFactory.create();
		Service service = server.getEndpoint().getService();
		
		System.out.println("SoapServer: verfügbare Services: " + service.toString());
	 }

	public static void main(String args[]) throws Exception {
		new SoapServer();
		System.out.println("Server ready...");
		Thread.sleep(20 * 60 * 1000); //20 min online
		System.out.println("Server exiting");
		System.exit(0);
	}
}
