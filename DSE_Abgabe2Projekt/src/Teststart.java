import java.io.IOException;

public class Teststart {

	public static void main(String[] args) {

		try {
			start();
			System.out.println("Server laeuft");
			Thread.sleep(60 * 1000);
			System.out.println("Server stoppen");
			stop();
		} catch (IOException e) {
			System.err.println("Fehler beim Tomcat: " + e.getMessage());
		} catch (InterruptedException e) {
			System.err.println("Thread bezogener Fehler");
		}

	}

	public static void start() throws IOException {
		String command = "C:\\Users\\Gerhard\\Downloads\\apache-tomcat-8.0.15-windows-x86\\apache-tomcat-8.0.15\\bin\\startup.bat";// for																														// .sh
		Process child = Runtime.getRuntime().exec(command);
	}
	 public static void stop() throws IOException{
		 String command = "C:\\Users\\Gerhard\\Downloads\\apache-tomcat-8.0.15-windows-x86\\apache-tomcat-8.0.15\\bin\\shutdown.bat";//for linux use .sh
		 Process child = Runtime.getRuntime().exec(command);
	 }
}
