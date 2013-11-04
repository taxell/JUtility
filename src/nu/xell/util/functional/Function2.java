package nu.xell.util.functional;

/**
 * The Function1 is an interface describing a
 * two variable function, f : A -> B -> C, using
 * the strategy pattern.
 * 
 * @author Tobias Axell
 */
public interface Function2<A, B, C> {
	
	/**
	 * <p>The function f : A -> B -> C</p>
	 * 
	 * <p>NOTE: If an instance of this interface should be able to be
	 * used in a more functional manner it is important that:</p>
	 * 
	 * <p>1) The implementation of <i>f</i> does not modify the arguments
	 * <i>a</i> and <i>b</i>.</p>
	 * <p>2) The implementation of <i>f</i> returns a <strong>new</strong>
	 * or an <strong>immutable</strong> object.</p>
	 * 
	 * @param a The first function argument.
	 * @param b The second function argument.
	 * @return The result of computing <code>f(a, b)</code>
	 */
	public C f(A a, B b);
}
