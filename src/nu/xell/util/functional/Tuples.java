package nu.xell.util.functional;

/**
 * A class with static tuple realated help functions.
 * 
 * @author Tobias Axell
 */
public final class Tuples {

	private Tuples() {}
	
	/**
	 * Gives the first element of a given tuple.
	 * 
	 * @param t The tuple to get the first element from.
	 * @return The first element of the tuple, <i>t</i>.
	 */
	public static <A> A fst(Tuple2<A, ?> t){
		return t.first;
	}
	
	/**
	 * Gives the first element of a given tuple.
	 * 
	 * @param t The tuple to get the first element from.
	 * @return The first element of the tuple, <i>t</i>.
	 */
	public static <A> A fst(Tuple3<A, ?, ?> t){
		return t.first;
	}
	
	/**
	 * Gives the first element of a given tuple.
	 * 
	 * @param t The tuple to get the first element from.
	 * @return The first element of the tuple, <i>t</i>.
	 */
	public static <A> A fst(Tuple4<A, ?, ?, ?> t){
		return t.first;
	}
	
	/**
	 * Gives the first element of a given tuple.
	 * 
	 * @param t The tuple to get the first element from.
	 * @return The first element of the tuple, <i>t</i>.
	 */
	public static <A> A fst(Tuple5<A, ?, ?, ?, ?> t){
		return t.first;
	}
	
	/**
	 * Gives the first element of a given tuple.
	 * 
	 * @param t The tuple to get the first element from.
	 * @return The first element of the tuple, <i>t</i>.
	 */
	public static <A> A fst(Tuple6<A, ?, ?, ?, ?, ?> t){
		return t.first;
	}
	
	/**
	 * Gives the first element of a given tuple.
	 * 
	 * @param t The tuple to get the first element from.
	 * @return The first element of the tuple, <i>t</i>.
	 */
	public static <A> A fst(Tuple7<A, ?, ?, ?, ?, ?, ?> t){
		return t.first;
	}
	
	/**
	 * Gives the first element of a given tuple.
	 * 
	 * @param t The tuple to get the first element from.
	 * @return The first element of the tuple, <i>t</i>.
	 */
	public static <A> A fst(Tuple8<A, ?, ?, ?, ?, ?, ?, ?> t){
		return t.first;
	}
	
	/**
	 * Gives the first element of a given tuple.
	 * 
	 * @param t The tuple to get the first element from.
	 * @return The first element of the tuple, <i>t</i>.
	 */
	public static <A> A fst(Tuple9<A, ?, ?, ?, ?, ?, ?, ?, ?> t){
		return t.first;
	}
	
	/**
	 * Gives the second element of a given tuple.
	 * 
	 * @param t The tuple to get the second element from.
	 * @return The second element of the tuple, <i>t</i>.
	 */
	public static <B> B snd(Tuple2<?, B> t){
		return t.second;
	}
	
	/**
	 * Gives the second element of a given tuple.
	 * 
	 * @param t The tuple to get the second element from.
	 * @return The second element of the tuple, <i>t</i>.
	 */
	public static <B> B snd(Tuple3<?, B, ?> t){
		return t.second;
	}
	
	/**
	 * Gives the second element of a given tuple.
	 * 
	 * @param t The tuple to get the second element from.
	 * @return The second element of the tuple, <i>t</i>.
	 */
	public static <B> B snd(Tuple4<?, B, ?, ?> t){
		return t.second;
	}
	
	/**
	 * Gives the second element of a given tuple.
	 * 
	 * @param t The tuple to get the second element from.
	 * @return The second element of the tuple, <i>t</i>.
	 */
	public static <B> B snd(Tuple5<?, B, ?, ?, ?> t){
		return t.second;
	}
	
	/**
	 * Gives the second element of a given tuple.
	 * 
	 * @param t The tuple to get the second element from.
	 * @return The second element of the tuple, <i>t</i>.
	 */
	public static <B> B snd(Tuple6<?, B, ?, ?, ?, ?> t){
		return t.second;
	}
	
	/**
	 * Gives the second element of a given tuple.
	 * 
	 * @param t The tuple to get the second element from.
	 * @return The second element of the tuple, <i>t</i>.
	 */
	public static <B> B snd(Tuple7<?, B, ?, ?, ? ,?, ?> t){
		return t.second;
	}
	
	/**
	 * Gives the second element of a given tuple.
	 * 
	 * @param t The tuple to get the second element from.
	 * @return The second element of the tuple, <i>t</i>.
	 */
	public static <B> B snd(Tuple8<?, B, ?, ?, ?, ?, ?, ?> t){
		return t.second;
	}
	
	/**
	 * Gives the second element of a given tuple.
	 * 
	 * @param t The tuple to get the second element from.
	 * @return The second element of the tuple, <i>t</i>.
	 */
	public static <B> B snd(Tuple9<?, B, ?, ?, ?, ?, ?, ?, ?> t){
		return t.second;
	}
	
	/**
	 * Swaps place on the elements of a 2-tuple.
	 * 
	 * @param t The tuple to swap the order of elemnts on.
	 * @return A new 2-tuple with the same elements as <i>t</i> but in opposite order.
	 */
	public static <A, B> Tuple2<B, A> swap(Tuple2<A, B> t){
		return new Tuple2<B, A>(t.second, t.first);
	}
}
