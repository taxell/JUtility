package nu.xell.util.functional;

/**
 * A two element tuple.
 * 
 * @author Tobias Axell
 *
 * @param <A> The type of the first element.
 * @param <B> The type of the second element.
 */
public final class Tuple2<A, B> {

	public final A first;
	public final B second;
	
	/**
	 * Constructor for Tuple2.
	 * 
	 * @param a The first element of the tuple.
	 * @param b The second element of the tuple.
	 */
	public Tuple2(A a, B b) {
		if(a == null || 
		   b == null){
			
			throw new NullPointerException("Tuples do not allow null elements");
		}
		
		first = a;
		second = b;
	}
}
