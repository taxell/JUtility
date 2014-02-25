package nu.xell.util.functional;

/**
 * A eight element tuple.
 * 
 * @author Tobias Axell
 *
 * @param <A> The type of the first element.
 * @param <B> The type of the second element.
 * @param <C> The type of the third element.
 * @param <D> The type of the fourth element.
 * @param <E> The type of the fifth element.
 * @param <F> The type of the sixth element.
 * @param <G> The type of the seventh element.
 * @param <H> The type of the eighth element.
 */
public class Tuple8<A, B, C, D, E, F, G, H> {

	public final A first;
	public final B second;
	public final C third;
	public final D fourth;
	public final E fifth;
	public final F sixth;
	public final G seventh;
	public final H eigth;
	
	/**
	 * Constructor for Tuple8.
	 * 
	 * @param a The first element of the tuple.
	 * @param b The second element of the tuple.
	 * @param c The third element of the tuple.
	 * @param d The fourth element of the tuple.
	 * @param e The fifth element of the tuple.
	 * @param f The sixth element of the tuple.
	 * @param g The seventh element of the tuple.
	 * @param h The eighth element of the tuple.
	 */
	public Tuple8(A a, B b, C c, D d, E e, F f, G g, H h) {
		if(a == null || 
		   b == null ||
		   c == null ||
		   d == null ||
		   e == null ||
		   f == null ||
		   g == null ||
		   h == null){
															
			throw new NullPointerException("Tuples do not allow null elements");
		}
		
		first = a;
		second = b;
		third = c;
		fourth = d;
		fifth = e;
		sixth = f;
		seventh = g;
		eigth = h;
	}
}
