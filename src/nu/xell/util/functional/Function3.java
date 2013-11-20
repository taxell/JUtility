package nu.xell.util.functional;

/**
 * The Function3 is an interface describing a
 * three variable function, f : A -> B -> C -> D, using
 * the strategy pattern.
 * 
 * @author Tobias Axell
 */
public interface Function3<A, B, C, D> {
	
	/**
	 * <p>The function f : A -> B -> C -> D</p>
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
	 * @param c The third function argument.
	 * @return The result of computing <code>f(a, b, c)</code>
	 */
	public D f(A a, B b, C c);
}
