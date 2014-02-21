package nu.xell.util.functional;

/**
 * NilListException is an exception to be thrown when
 * an list operation that is not defined for nil lists
 * is applied on nil.
 * 
 * @author Tobias Axell
 */
public class NilListException extends UndefinedOperationException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5852900075086902781L;

	/**
	 * Constructor for NilListException.
	 */
	public NilListException() {
		super();
	}

	/**
	 * Constructor for NilListException.
	 * 
	 * @param message A string message.
	 */
	public NilListException(String message) {
		super(message);
	}

	/**
	 * Constructor for NilListException.
	 * 
	 * @param cause A Throwable that caused this exception to be thrown.
	 */
	public NilListException(Throwable cause) {
		super(cause);
	}

	/**
	 * Constructor for NilListException.
	 * 
	 * @param message A string message.
	 * @param cause A Throwable that caused this exception to be thrown.
	 */
	public NilListException(String message, Throwable cause) {
		super(message, cause);
	}
	
	/**
	 * Constructor for NilListException.
	 * 
	 * @param message A String message.
	 * @param cause A Throwable that caused this exception to be thrown.
	 * @param enableSuppression Whether or not suppression is enabled or disabled.
	 * @param writableStackTrace Whether or not the stack trace should be writable.
	 */
	protected NilListException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}
