package nu.xell.util.functional;

/**
 * The Function7 is an interface describing a
 * seven variable function, f : A -> B -> C -> D -> E -> F -> G -> H, using
 * the strategy pattern.
 * 
 * @author Tobias Axell
 */
public interface Function7<A, B, C, D, E, F, G, H> {
	
	/**
	 * <p>The function f : A -> B -> C -> D -> E -> F -> G -> H</p>
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
	 * @param d The fourth function argument.
	 * @param e The fifth function argument.
	 * @param f The sixth function argument.
	 * @param g The seventh function argument.
	 * @return The result of computing <code>f(a, b, c, d, e, f, g)</code>
	 */
	public H f(A a, B b, C c, D d, E e, F f, G g);
}
