package management;

/**
 * 
 * Nur eine Exception, die einen bestimmten Text ausgiebt, um speziell Exceptions werfen zu können, 
 * auf bestimmte Anforderungen im Client-, Servercode
 *
 */
public class MyException extends Exception
{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Standardkonstruktor, eigentlich sehr sinnlos, weil er nicht auf die Umstände eingeht, 
	 * aber zu testzwecken praktisch
	 */
	public MyException(){
		this("Ein Fehler ist aufgetreten");
    }
	
	/**
	 * Hier kann man speziell einen Text eines Events eingeben, bei der die Exception geworfen wurde
	 * @param message Der Text der Exception
	 */
    public MyException(String message){
    	super(message);
    }
}