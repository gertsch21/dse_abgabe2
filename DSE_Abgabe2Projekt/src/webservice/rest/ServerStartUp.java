package webservice.rest;

import org.apache.cxf.endpoint.Server;
import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;
import org.apache.cxf.jaxrs.lifecycle.SingletonResourceProvider;

public class ServerStartUp {
	
			protected ServerStartUp() throws Exception {
				
				
				JAXRSServerFactoryBean sf = new JAXRSServerFactoryBean();
				sf.setResourceClasses(UserService1.class);
				sf.setResourceProvider(UserService1.class,
				new SingletonResourceProvider(new UserService1()));
				sf.setAddress("http://localhost:9999/");
				sf.create();
			
      }
	    public static void main(String args[]) throws Exception {
	
				new ServerStartUp();
				System.out.println("Server ready...");
				Thread.sleep(5 * 6000 * 1000);
				System.out.println("Server exiting");
				System.exit(0);
				}

		}




