package nu.xell.util.functional;

/**
 * A four element tuple.
 * 
 * @author Tobias Axell
 *
 * @param <A> The type of the first element.
 * @param <B> The type of the second element.
 * @param <C> The type of the third element.
 * @param <D> The type of the fourth element.
 */
public class Tuple4<A, B, C, D> {

	public final A first;
	public final B second;
	public final C third;
	public final D fourth;
	
	/**
	 * Constructor for Tuple4.
	 * 
	 * @param a The first element of the tuple.
	 * @param b The second element of the tuple.
	 * @param c The third element of the tuple.
	 * @param d The fourth element of the tuple.
	 */
	public Tuple4(A a, B b, C c, D d) {
		if(a == null || 
		   b == null ||
		   c == null ||
		   d == null){
							
			throw new NullPointerException("Tuples do not allow null elements");
		}
		
		first = a;
		second = b;
		third = c;
		fourth = d;
	}
}
