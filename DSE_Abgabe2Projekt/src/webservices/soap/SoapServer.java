package webservices.soap;

import org.apache.cxf.endpoint.Server;
import org.apache.cxf.jaxws.JaxWsServerFactoryBean;
import org.apache.cxf.service.Service;

import soap.services.*;

public class SoapServer {
	protected SoapServer() throws Exception {
		System.out.println("Starting Server");
		AlleServicesSEI serviceImpl = new AlleServices();
		JaxWsServerFactoryBean svrFactory = new JaxWsServerFactoryBean();
		svrFactory.setServiceClass(AlleServices.class);
		svrFactory.setAddress("http://localhost:9000/AlleServices");
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
