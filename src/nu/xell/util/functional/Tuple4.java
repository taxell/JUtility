package nu.xell.util.functional;

public class Tuple4<A, B, C, D> {

	public final A first;
	public final B second;
	public final C third;
	public final D fourth;
	
	public Tuple4(A a, B b, C c, D d) {
		first = a;
		second = b;
		third = c;
		fourth = d;
	}
}
