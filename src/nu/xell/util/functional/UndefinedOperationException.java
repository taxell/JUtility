package nu.xell.util.functional;

/**
 * The UndefinedOperationException is sort of a generalization of
 * IllegalArgumentException and IllegalStateException. It should be thrown
 * when an operation is called on an object that is in a state where
 * the operation is not defined or if an operation is called with
 * parameters for which the operation is not defined.
 * 
 * @author Tobias Axell
 */
public class UndefinedOperationException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3096248169764137278L;

	/**
	 * Constructor for UndefinedOperationException.
	 */
	public UndefinedOperationException() {}

	/**
	 * Constructor for UndefinedOperationException.
	 * 
	 * @param message A String message.
	 */
	public UndefinedOperationException(String message) {
		super(message);
	}

	/**
	 * Constructor for UndefinedOperationException.
	 * 
	 * @param cause A Throwable that caused this exception to be thrown.
	 */
	public UndefinedOperationException(Throwable cause) {
		super(cause);
	}

	/**
	 * Constructor for UndefinedOperationException.
	 * 
	 * @param message A String message.
	 * @param cause A Throwable that caused this exception to be thrown.
	 */
	public UndefinedOperationException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * Constructor for UndefinedOperationException.
	 * 
	 * @param message A String message.
	 * @param cause A Throwable that caused this exception to be thrown.
	 * @param enableSuppression Whether or not suppression is enabled or disabled.
	 * @param writableStackTrace Whether or not the stack trace should be writable.
	 */
	protected UndefinedOperationException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}
