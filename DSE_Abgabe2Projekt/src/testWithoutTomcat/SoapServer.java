package testWithoutTomcat;

import org.apache.cxf.jaxws.JaxWsServerFactoryBean;
import soap.services.*;

public class SoapServer {
	protected SoapServer() throws Exception {
 System.out.println("Starting Server");
 Benutzerservices serviceImpl = new Benutzerservices();
 JaxWsServerFactoryBean svrFactory = new JaxWsServerFactoryBean();
 svrFactory.setServiceClass(Benutzerservices.class);
 svrFactory.setAddress("http://localhost:9000/Benutzerservice");
 svrFactory.setServiceBean(serviceImpl);
 svrFactory.create();
 }

	public static void main(String args[]) throws Exception {
		new SoapServer();
		System.out.println("Server ready...");
		Thread.sleep(5 * 60 * 1000);
		System.out.println("Server exiting");
		System.exit(0);
	}
}
