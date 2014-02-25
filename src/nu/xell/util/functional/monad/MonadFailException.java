package nu.xell.util.functional.monad;

/**
 * The MonadFailException is to be thrown when a monadic computation fails
 * and no 'default fail return value' exists.
 * 
 * @author Tobias Axell
 */
public class MonadFailException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3999300431413587388L;

	/**
	 * Constructor for MonadFailException.
	 */
	public MonadFailException() {
		super();
	}

	/**
	 * Constructor for MonadFailException.
	 * 
	 * @param message A message describing why this exception is thrown.
	 */
	public MonadFailException(String message) {
		super(message);
	}

	/**
	 * Constructor for MonadFailException.
	 * 
	 * @param cause The Throwable that caused this exception.
	 */
	public MonadFailException(Throwable cause) {
		super(cause);
	}

	/**
	 * Constructor for MonadFailException.
	 * 
	 * @param message A message describing why this exception is thrown.
	 * @param cause The Throwable that caused this exception.
	 */
	public MonadFailException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * Constructor for MonadFailException.
	 * 
	 * @param message A message describing why this exception is thrown.
	 * @param cause The Throwable that caused this exception.
	 * @param enableSuppression Whether or not suppression is enabled or disabled.
	 * @param writableStackTrace Whether or not the stack trace should be writable.
	 */
	protected MonadFailException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}
