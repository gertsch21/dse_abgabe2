package exceptions;

public class ServerException extends Exception{

	private static final long serialVersionUID = 1L;

	/**
	 * Standardkonstruktor, eigentlich sehr sinnlos, weil er nicht auf die Umstände eingeht, 
	 * aber zu testzwecken praktisch
	 */
	public ServerException(){
		this("Ein Fehler ist aufgetreten");
    }
	
	/**
	 * Hier kann man speziell einen Text eines Events eingeben, bei der die Exception geworfen wurde
	 * @param message Der Text der Exception
	 */
    public ServerException(String message){
    	super(message);
    }
}