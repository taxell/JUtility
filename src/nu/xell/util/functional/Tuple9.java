package nu.xell.util.functional;

/**
 * 
 * @author Tobias Axell
 */
public class Tuple9<A, B, C, D, E, F, G, H, I> {

	public final A first;
	public final B second;
	public final C third;
	public final D fourth;
	public final E fifth;
	public final F sixth;
	public final G seventh;
	public final H eigth;
	public final I ninth;
	
	/**
	 * 
	 * @param a
	 * @param b
	 * @param c
	 * @param d
	 * @param e
	 * @param f
	 * @param g
	 * @param h
	 * @param i
	 */
	public Tuple9(A a, B b, C c, D d, E e, F f, G g, H h, I i) {
		first = a;
		second = b;
		third = c;
		fourth = d;
		fifth = e;
		sixth = f;
		seventh = g;
		eigth = h;
		ninth = i;
	}
}
