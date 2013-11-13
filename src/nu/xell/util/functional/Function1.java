package nu.xell.util.functional;

/**
 * The Function1 is an interface describing a
 * single variable function, f : A -> B, using
 * the strategy pattern.
 * 
 * @author Tobias Axell
 */
public interface Function1<A, B> {
	
	/**
	 * <p>The function f : A -> B</p>
	 * 
	 * <p>NOTE: If an instance of this interface should be able to be
	 * used in a more functional manner it is important that:</p>
	 * 
	 * <p>1) The implementation of <i>f</i> does not modify the argument
	 * <i>a</i>.</p>
	 * <p>2) The implementation of <i>f</i> returns a <strong>new</strong>
	 * or an <strong>immutable</strong> object.</p>
	 * 
	 * @param a - The function argument.
	 * @return The result of computing <code>f(a)</code>
	 */
	public B f(A a);
}
