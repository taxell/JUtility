package nu.xell.util.functional;

/**
 * A three element tuple.
 * 
 * @author Tobias Axell
 *
 * @param <A> The type of the first element.
 * @param <B> The type of the second element.
 * @param <C> The type of the third element.
 */
public class Tuple3<A, B, C> {

	public final A first;
	public final B second;
	public final C third;
	
	/**
	 * Constructor for Tuple3.
	 * 
	 * @param a The first element of the tuple.
	 * @param b The second element of the tuple.
	 * @param c The third element of the tuple.
	 */
	public Tuple3(A a, B b, C c) {
		if(a == null || 
		   b == null ||
		   c == null){
					
			throw new NullPointerException("Tuples do not allow null elements");
		}
		
		first = a;
		second = b;
		third = c;
	}
}
