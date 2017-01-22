
package webservice.rest;

import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;
import org.apache.cxf.jaxrs.lifecycle.SingletonResourceProvider;

public class ServerStartUp {
	
			protected ServerStartUp() throws Exception {
				
				
				JAXRSServerFactoryBean sf = new JAXRSServerFactoryBean();
				sf.setResourceClasses(UserServiceHTML.class);
				sf.setResourceProvider(UserServiceHTML.class,
				new SingletonResourceProvider(new UserServiceHTML()));
				sf.setResourceClasses(UserService.class);
				sf.setResourceProvider(UserService.class,
				new SingletonResourceProvider(new UserService()));
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




