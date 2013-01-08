/**
 * 
 */
package mx.com.gahm.conenctel.exceptions;



/**
 * El Class CotizadorMappingException.
 * 
 * @author carlos.leyva
 * @version 1.0
 */
public class ConectelMappingException extends ConectelException {

	/** La constante serialVersionUID. */
	private static final long serialVersionUID = -7272557921073521124L;

	/**
	 * Instancia del nuevo cotizador mapping exception.
	 *
	 * @param message la message.
	 * @param cause la cause.
	 */
	public ConectelMappingException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * Instancia del nuevo cotizador mapping exception.
	 *
	 * @param message la message.
	 */
	public ConectelMappingException(String message) {
		super(message);
	}

}
