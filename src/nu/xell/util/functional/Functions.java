package nu.xell.util.functional;

/**
 * A utility class for functions. Contains methods for partial application 
 * (from both right and left), function composition, etc.
 * 
 * @author Tobias Axell
 */
public class Functions {

	private Functions() {}
	
	/**
	 * Partial application of a given function and a given argument to apply.
	 * This method applies <b>a</b> to the first argument of the function <b>fun</b>.
	 * The type of this method is with Haskell notation: <br></br>
	 * 
	 * A -> (A -> B -> C) -> (B -> C) <br></br>
	 * 
	 * The result of calling this method is a function with one less parameter than
	 * <b>fun</b> that is equal to <b>fun</b> with the first parameter 'bound' to <b>a</b>.<br></br>
	 * 
	 * appF(a, f) = r(b), where r(b) = f(a, b)
	 * 
	 * @param a The argument to apply to the function <b>fun</b>.
	 * @param f The function <b>fun</b>.
	 * @return A new function that is the result of partially applying <b>a</b> to <b>fun</b>.
	 */
	public static <A, B, C> Function1<B, C> appF(final A a, final Function2<A, B, C> f){
		
		return new Function1<B, C>() {
			@Override
			public C f(B b) {
				return f.f(a, b);
			}
		};
	}
	
	/**
	 * Partial application of a given function and a given argument to apply.
	 * This method applies <b>a</b> to the first argument of the function <b>fun</b>.
	 * The type of this method is with Haskell notation: <br></br>
	 * 
	 * A -> (A -> B -> C -> D) -> (B -> C -> D) <br></br>
	 * 
	 * The result of calling this method is a function with one less parameter than
	 * <b>fun</b> that is equal to <b>fun</b> with the first parameter 'bound' to <b>a</b>.<br></br>
	 * 
	 * appF(a, f) = r(b, c), where r(b, c) = f(a, b, c)
	 * 
	 * @param a The argument to apply to the function <b>fun</b>.
	 * @param f The function <b>fun</b>.
	 * @return A new function that is the result of partially applying <b>a</b> to <b>fun</b>.
	 */
	public static <A, B, C, D> Function2<B, C, D> appF(final A a, final Function3<A, B, C, D> f){
		return new Function2<B, C, D>() {

			@Override
			public D f(B b, C c) {
				return f.f(a, b, c);
			}
		};
	}
	
	/**
	 * Partial application of a given function and a given argument to apply.
	 * This method applies <b>a</b> to the first argument of the function <b>fun</b>.
	 * The type of this method is with Haskell notation: <br></br>
	 * 
	 * A -> (A -> B -> C -> D -> E) -> (B -> C -> D -> E) <br></br>
	 * 
	 * The result of calling this method is a function with one less parameter than
	 * <b>fun</b> that is equal to <b>fun</b> with the first parameter 'bound' to <b>a</b>.<br></br>
	 * 
	 * appF(a, f) = r(b, c, d, e), where r(b, c, d, e) = f(a, b, c, d, e)
	 * 
	 * @param a The argument to apply to the function <b>fun</b>.
	 * @param f The function <b>fun</b>.
	 * @return A new function that is the result of partially applying <b>a</b> to <b>fun</b>.
	 */
	public static <A, B, C, D, E> Function3<B, C, D, E> appF(final A a, final Function4<A, B, C, D, E> f){
		return new Function3<B, C, D, E>() {

			@Override
			public E f(B b, C c, D d) {
				return f.f(a, b, c, d);
			}
		};
	}
	
	/**
	 * Partial application of a given function and a given argument to apply.
	 * This method applies <b>a</b> to the first argument of the function <b>fun</b>.
	 * The type of this method is with Haskell notation: <br></br>
	 * 
	 * A -> (A -> B -> C -> D -> E -> F) -> (B -> C -> D -> E -> F) <br></br>
	 * 
	 * The result of calling this method is a function with one less parameter than
	 * <b>fun</b> that is equal to <b>fun</b> with the first parameter 'bound' to <b>a</b>.<br></br>
	 * 
	 * appF(a, f) = r(b, c, d, e, f), where r(b, c, d, e, f) = f(a, b, c, d, e, f)
	 * 
	 * @param a The argument to apply to the function <b>fun</b>.
	 * @param f The function <b>fun</b>.
	 * @return A new function that is the result of partially applying <b>a</b> to <b>fun</b>.
	 */
	public static <A, B, C, D, E, F> Function4<B, C, D, E, F> appF(final A a, final Function5<A, B, C, D, E, F> f){
		return new Function4<B, C, D, E, F>() {

			@Override
			public F f(B b, C c, D d, E e) {
				return f.f(a, b, c, d, e);
			}
		};
	}
	
	/**
	 * Partial application of a given function and a given argument to apply.
	 * This method applies <b>a</b> to the first argument of the function <b>fun</b>.
	 * The type of this method is with Haskell notation: <br></br>
	 * 
	 * A -> (A -> B -> C -> D -> E -> F -> G) -> (B -> C -> D -> E -> F -> G) <br></br>
	 * 
	 * The result of calling this method is a function with one less parameter than
	 * <b>fun</b> that is equal to <b>fun</b> with the first parameter 'bound' to <b>a</b>.<br></br>
	 * 
	 * appF(a, f) = r(b, c, d, e, f, g), where r(b, c, d, e, f, g) = f(a, b, c, d, e, f, g)
	 * 
	 * @param a The argument to apply to the function <b>fun</b>.
	 * @param f The function <b>fun</b>.
	 * @return A new function that is the result of partially applying <b>a</b> to <b>fun</b>.
	 */
	public static <A, B, C, D, E, F, G> Function5<B, C, D, E, F, G> appF(final A a, final Function6<A, B, C, D, E, F, G> fun){
		return new Function5<B, C, D, E, F, G>() {

			@Override
			public G f(B b, C c, D d, E e, F f) {
				return fun.f(a, b, c, d, e, f);
			}
		};
	}
	
	/**
	 * Partial application of a given function and a given argument to apply.
	 * This method applies <b>a</b> to the first argument of the function <b>fun</b>.
	 * The type of this method is with Haskell notation: <br></br>
	 * 
	 * A -> (A -> B -> C -> D -> E -> F -> G -> H) -> (B -> C -> D -> E -> F -> G -> H) <br></br>
	 * 
	 * The result of calling this method is a function with one less parameter than
	 * <b>fun</b> that is equal to <b>fun</b> with the first parameter 'bound' to <b>a</b>.<br></br>
	 * 
	 * appF(a, f) = r(b, c , d, e, f, g, h), where r(b, c , d, e, f, g, h) = f(a, b, c , d, e, f, g, h)
	 * 
	 * @param a The argument to apply to the function <b>fun</b>.
	 * @param f The function <b>fun</b>.
	 * @return A new function that is the result of partially applying <b>a</b> to <b>fun</b>.
	 */
	public static <A, B, C, D, E, F, G, H> Function6<B, C, D, E, F, G, H> 
					appF(final A a, final Function7<A, B, C, D, E, F, G, H> fun){
		return new Function6<B, C, D, E, F, G, H>() {

			@Override
			public H f(B b, C c, D d, E e, F f, G g) {
				return fun.f(a, b, c, d, e, f, g);
			}
		};
	}
	
	/**
	 * Partial application of a given function and a given argument to apply.
	 * This method applies <b>a</b> to the first argument of the function <b>fun</b>.
	 * The type of this method is with Haskell notation: <br></br>
	 * 
	 * A -> (A -> B -> C -> D -> E -> F -> G -> H -> I) -> (B -> C -> D -> E -> F -> G -> H -> I) <br></br>
	 * 
	 * The result of calling this method is a function with one less parameter than
	 * <b>fun</b> that is equal to <b>fun</b> with the first parameter 'bound' to <b>a</b>.<br></br>
	 * 
	 * appF(a, f) = r(b, c , d, e, f, g, h, i), where r(b, c , d, e, f, g, h, i) = f(a, b, c , d, e, f, g, h, i)
	 * 
	 * @param a The argument to apply to the function <b>fun</b>.
	 * @param f The function <b>fun</b>.
	 * @return A new function that is the result of partially applying <b>a</b> to <b>fun</b>.
	 */
	public static <A, B, C, D, E, F, G, H, I> Function7<B, C, D, E, F, G, H, I> 
					appF(final A a, final Function8<A, B, C, D, E, F, G, H, I> fun){
		return new Function7<B, C, D, E, F, G, H, I>() {

			@Override
			public I f(B b, C c, D d, E e, F f, G g, H h) {
				return fun.f(a, b, c, d, e, f, g, h);
			}
		};
	}
	
	/**
	 * Partial application of a given function and a given argument to apply.
	 * This method applies <b>a</b> to the first argument of the function <b>fun</b>.
	 * The type of this method is with Haskell notation: <br></br>
	 * 
	 * A -> (A -> B -> C -> D -> E -> F -> G -> H -> I -> J) -> (B -> C -> D -> E -> F -> G -> H -> I -> J) <br></br>
	 * 
	 * The result of calling this method is a function with one less parameter than
	 * <b>fun</b> that is equal to <b>fun</b> with the first parameter 'bound' to <b>a</b>.<br></br>
	 * 
	 * appF(a, f) = r(b, c , d, e, f, g, h, i, j), where r(b, c , d, e, f, g, h, i, j) = f(a, b, c , d, e, f, g, h, i, j)
	 * 
	 * @param a The argument to apply to the function <b>fun</b>.
	 * @param f The function <b>fun</b>.
	 * @return A new function that is the result of partially applying <b>a</b> to <b>fun</b>.
	 */
	public static <A, B, C, D, E, F, G, H, I, J> Function8<B, C, D, E, F, G, H, I, J> 
					appF(final A a, final Function9<A, B, C, D, E, F, G, H, I, J> fun){
		return new Function8<B, C, D, E, F, G, H, I, J>() {

			@Override
			public J f(B b, C c, D d, E e, F f, G g, H h, I i) {
				return fun.f(a, b, c, d, e, f, g, h, i);
			}
		};
	}
	
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	/**
	 * Partial application of a given function and a given argument to apply.
	 * This method applies <b>b</b> to the last argument of the function <b>fun</b>.
	 * The type of this method is with Haskell notation: <br></br>
	 * 
	 * (A -> B -> C) -> B -> (A -> C) <br></br>
	 * 
	 * The result of calling this method is a function with one less parameter than
	 * <b>fun</b> that is equal to <b>fun</b> with the last parameter 'bound' to <b>b</b>.<br></br>
	 * 
	 * appL(f, b) = r(a), where r(a) = f(a, b)
	 * 
	 * @param fun The function <b>fun</b>.
	 * @param b The argument to apply to the function <b>fun</b>.
	 * @return A new function that is the result of partially applying <b>b</b> to <b>fun</b>.
	 */
	public static <A, B, C> Function1<A, C> appL(final Function2<A, B, C> fun, final B b){
		return new Function1<A, C>() {

			@Override
			public C f(A a) {
				return fun.f(a, b);
			}
		};
	}
	
	/**
	 * Partial application of a given function and a given argument to apply.
	 * This method applies <b>c</b> to the last argument of the function <b>fun</b>.
	 * The type of this method is with Haskell notation: <br></br>
	 * 
	 * (A -> B -> C -> D) -> C -> (A -> B -> D) <br></br>
	 * 
	 * The result of calling this method is a function with one less parameter than
	 * <b>fun</b> that is equal to <b>fun</b> with the last parameter 'bound' to <b>c</b>.<br></br>
	 * 
	 * appL(f, c) = r(a, b), where r(a, b) = f(a, b, c)
	 * 
	 * @param fun The function <b>fun</b>.
	 * @param c The argument to apply to the function <b>fun</b>.
	 * @return A new function that is the result of partially applying <b>c</b> to <b>fun</b>.
	 */
	public static <A, B, C, D> Function2<A, B, D> appL(final Function3<A, B, C, D> fun, final C c){
		return new Function2<A, B, D>() {

			@Override
			public D f(A a, B b) {
				return fun.f(a, b, c);
			}
		};
	}
	
	/**
	 * Partial application of a given function and a given argument to apply.
	 * This method applies <b>d</b> to the last argument of the function <b>fun</b>.
	 * The type of this method is with Haskell notation: <br></br>
	 * 
	 * (A -> B -> C -> D -> E) -> D -> (A -> B -> C -> E) <br></br>
	 * 
	 * The result of calling this method is a function with one less parameter than
	 * <b>fun</b> that is equal to <b>fun</b> with the last parameter 'bound' to <b>d</b>.<br></br>
	 * 
	 * appL(f, d) = r(a, b, c), where r(a, b, c) = f(a, b, c, d)
	 * 
	 * @param fun The function <b>fun</b>.
	 * @param d The argument to apply to the function <b>fun</b>.
	 * @return A new function that is the result of partially applying <b>d</b> to <b>fun</b>.
	 */
	public static <A, B, C, D, E> Function3<A, B, C, E> appL(final Function4<A, B, C, D, E> fun, final D d){
		return new Function3<A, B, C, E>() {

			@Override
			public E f(A a, B b, C c) {
				return fun.f(a, b, c, d);
			}
		};
	}
	
	/**
	 * Partial application of a given function and a given argument to apply.
	 * This method applies <b>e</b> to the last argument of the function <b>fun</b>.
	 * The type of this method is with Haskell notation: <br></br>
	 * 
	 * (A -> B -> C -> D -> E -> F) -> E -> (A -> B -> C -> D -> F) <br></br>
	 * 
	 * The result of calling this method is a function with one less parameter than
	 * <b>fun</b> that is equal to <b>fun</b> with the last parameter 'bound' to <b>e</b>.<br></br>
	 * 
	 * appL(f, e) = r(a, b, c, d), where r(a, b, c, d) = f(a, b, c, d, e)
	 * 
	 * @param fun The function <b>fun</b>.
	 * @param e The argument to apply to the function <b>fun</b>.
	 * @return A new function that is the result of partially applying <b>e</b> to <b>fun</b>.
	 */
	public static <A, B, C, D, E, F> Function4<A, B, C, D, F> appL(final Function5<A, B, C, D, E, F> fun, final E e){
		return new Function4<A, B, C, D, F>() {

			@Override
			public F f(A a, B b, C c, D d) {
				return fun.f(a, b, c, d, e);
			}
		};
	}
	
	/**
	 * Partial application of a given function and a given argument to apply.
	 * This method applies <b>f</b> to the last argument of the function <b>fun</b>.
	 * The type of this method is with Haskell notation: <br></br>
	 * 
	 * (A -> B -> C -> D -> E -> F -> G) -> F -> (A -> B -> C -> D -> E -> G) <br></br>
	 * 
	 * The result of calling this method is a function with one less parameter than
	 * <b>fun</b> that is equal to <b>fun</b> with the last parameter 'bound' to <b>f</b>.<br></br>
	 * 
	 * appL(f, f) = r(a, b, c, d, e), where r(a, b, c, d, e) = f(a, b, c, d, e, f)
	 * 
	 * @param fun The function <b>fun</b>.
	 * @param f The argument to apply to the function <b>fun</b>.
	 * @return A new function that is the result of partially applying <b>f</b> to <b>fun</b>.
	 */
	public static <A, B, C, D, E, F, G> Function5<A, B, C, D, E, G> appL(final Function6<A, B, C, D, E, F, G> fun, final F f){
		return new Function5<A, B, C, D, E, G>() {

			@Override
			public G f(A a, B b, C c, D d, E e) {
				return fun.f(a, b, c, d, e, f);
			}
		};
	}
	
	/**
	 * Partial application of a given function and a given argument to apply.
	 * This method applies <b>g</b> to the last argument of the function <b>fun</b>.
	 * The type of this method is with Haskell notation: <br></br>
	 * 
	 * (A -> B -> C -> D -> E -> F -> G -> H) -> G -> (A -> B -> C -> D -> E -> F -> H) <br></br>
	 * 
	 * The result of calling this method is a function with one less parameter than
	 * <b>fun</b> that is equal to <b>fun</b> with the last parameter 'bound' to <b>g</b>.<br></br>
	 * 
	 * appL(f, g) = r(a, b, c, d, e, f), where r(a, b, c, d, e, f) = f(a, b, c, d, e, f, g)
	 * 
	 * @param fun The function <b>fun</b>.
	 * @param g The argument to apply to the function <b>fun</b>.
	 * @return A new function that is the result of partially applying <b>g</b> to <b>fun</b>.
	 */
	public static <A, B, C, D, E, F, G, H> Function6<A, B, C, D, E, F, H> appL(final Function7<A, B, C, D, E, F, G, H> fun, final G g){
		return new Function6<A, B, C, D, E, F, H>() {

			@Override
			public H f(A a, B b, C c, D d, E e, F f) {
				return fun.f(a, b, c, d, e, f, g);
			}
		};
	}
	
	/**
	 * Partial application of a given function and a given argument to apply.
	 * This method applies <b>h</b> to the last argument of the function <b>fun</b>.
	 * The type of this method is with Haskell notation: <br></br>
	 * 
	 * (A -> B -> C -> D -> E -> F -> G -> H -> I) -> H -> (A -> B -> C -> D -> E -> F -> G -> I) <br></br>
	 * 
	 * The result of calling this method is a function with one less parameter than
	 * <b>fun</b> that is equal to <b>fun</b> with the last parameter 'bound' to <b>h</b>.<br></br>
	 * 
	 * appL(f, h) = r(a, b, c, d, e, f, g), where r(a, b, c, d, e, f, g) = f(a, b, c, d, e, f, g, h)
	 * 
	 * @param fun The function <b>fun</b>.
	 * @param h The argument to apply to the function <b>fun</b>.
	 * @return A new function that is the result of partially applying <b>h</b> to <b>fun</b>.
	 */
	public static <A, B, C, D, E, F, G, H, I> Function7<A, B, C, D, E, F, G, I> appL(final Function8<A, B, C, D, E, F, G, H, I> fun, final H h){
		return new Function7<A, B, C, D, E, F, G, I>() {

			@Override
			public I f(A a, B b, C c, D d, E e, F f, G g) {
				return fun.f(a, b, c, d, e, f, g, h);
			}
		};
	}
	
	/**
	 * Partial application of a given function and a given argument to apply.
	 * This method applies <b>i</b> to the last argument of the function <b>fun</b>.
	 * The type of this method is with Haskell notation: <br></br>
	 * 
	 * (A -> B -> C -> D -> E -> F -> G -> H -> I -> J) -> I -> (A -> B -> C -> D -> E -> F -> G -> H -> J) <br></br>
	 * 
	 * The result of calling this method is a function with one less parameter than
	 * <b>fun</b> that is equal to <b>fun</b> with the last parameter 'bound' to <b>i</b>.<br></br>
	 * 
	 * appL(f, i) = r(a, b, c, d, e, f, g, h), where r(a, b, c, d, e, f, g, h) = f(a, b, c, d, e, f, g, h, i)
	 * 
	 * @param fun The function <b>fun</b>.
	 * @param i The argument to apply to the function <b>fun</b>.
	 * @return A new function that is the result of partially applying <b>i</b> to <b>fun</b>.
	 */
	public static <A, B, C, D, E, F, G, H, I, J> Function8<A, B, C, D, E, F, G, H, J> appL(final Function9<A, B, C, D, E, F, G, H, I, J> fun, final I i){
		return new Function8<A, B, C, D, E, F, G, H, J>() {

			@Override
			public J f(A a, B b, C c, D d, E e, F f, G g, H h) {
				return fun.f(a, b, c, d, e, f, g, h, i);
			}
		};
	}
	
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	/**
	 * Function composition. Takes two functions <b>f1</b> and <b>f2</b>
	 * and gives the function f1( f2( a ) ).
	 * 
	 * @param f1 The <i>outer</i> function.
	 * @param f2 The <i>inner</i> function.
	 * @return The function f1( f2( a ) ).
	 */
	public static <A, B, C> Function1<A, C> fOf(final Function1<B, C> f1, final Function1<A, B> f2){
		return new Function1<A, C>(){

			@Override
			public C f(A a) {
				return f1.f(f2.f(a));
			}
		};
	}
	
	/**
	 * Function composition. Takes two functions <b>f1</b> and <b>f2</b>
	 * and gives the function f1( f2( a, b ) ).
	 * 
	 * @param f1 The <i>outer</i> function.
	 * @param f2 The <i>inner</i> function.
	 * @return The function f1( f2( a, b ) ).
	 */
	public static <A, B, C, D> Function2<A, B, D> fOf(final Function1<C, D> f1, final Function2<A, B, C> f2){
		return new Function2<A, B, D>(){

			@Override
			public D f(A a, B b) {
				return f1.f(f2.f(a, b));
			}
		};
	}
	
	/**
	 * Function composition. Takes two functions <b>f1</b> and <b>f2</b>
	 * and gives the function f1( f2( a, b, c ) ).
	 * 
	 * @param f1 The <i>outer</i> function.
	 * @param f2 The <i>inner</i> function.
	 * @return The function f1( f2( a, b, c ) ).
	 */
	public static <A, B, C, D, E> Function3<A, B, C, E> fOf(final Function1<D, E> f1, final Function3<A, B, C, D> f2){
		return new Function3<A, B, C, E>(){

			@Override
			public E f(A a, B b, C c) {
				return f1.f(f2.f(a, b, c));
			}
		};
	}
	
	/**
	 * Function composition. Takes two functions <b>f1</b> and <b>f2</b>
	 * and gives the function f1( f2( a, b, c, d ) ).
	 * 
	 * @param f1 The <i>outer</i> function.
	 * @param f2 The <i>inner</i> function.
	 * @return The function f1( f2( a, b, c, d ) ).
	 */
	public static <A, B, C, D, E, F> Function4<A, B, C, D, F> fOf(final Function1<E, F> f1, final Function4<A, B, C, D, E> f2){
		return new Function4<A, B, C, D, F>(){

			@Override
			public F f(A a, B b, C c, D d) {
				return f1.f(f2.f(a, b, c, d));
			}
		};
	}
	
	/**
	 * Function composition. Takes two functions <b>f1</b> and <b>f2</b>
	 * and gives the function f1( f2( a, b, c, d, e ) ).
	 * 
	 * @param f1 The <i>outer</i> function.
	 * @param f2 The <i>inner</i> function.
	 * @return The function f1( f2( a, b, c, d, e ) ).
	 */
	public static <A, B, C, D, E, F, G> Function5<A, B, C, D, E, G> fOf(final Function1<F, G> f1, final Function5<A, B, C, D, E, F> f2){
		return new Function5<A, B, C, D, E, G>(){

			@Override
			public G f(A a, B b, C c, D d, E e) {
				return f1.f(f2.f(a, b, c, d, e));
			}
		};
	}
	
	/**
	 * Function composition. Takes two functions <b>f1</b> and <b>f2</b>
	 * and gives the function f1( f2( a, b, c, d, e, f ) ).
	 * 
	 * @param f1 The <i>outer</i> function.
	 * @param f2 The <i>inner</i> function.
	 * @return The function f1( f2( a, b, c, d, e, f ) ).
	 */
	public static <A, B, C, D, E, F, G, H> Function6<A, B, C, D, E, F, H> fOf(final Function1<G, H> f1, final Function6<A, B, C, D, E, F, G> f2){
		return new Function6<A, B, C, D, E, F, H>(){

			@Override
			public H f(A a, B b, C c, D d, E e, F f) {
				return f1.f(f2.f(a, b, c, d, e, f));
			}
		};
	}
	
	/**
	 * Function composition. Takes two functions <b>f1</b> and <b>f2</b>
	 * and gives the function f1( f2( a, b, c, d, e, f, g ) ).
	 * 
	 * @param f1 The <i>outer</i> function.
	 * @param f2 The <i>inner</i> function.
	 * @return The function f1( f2( a, b, c, d, e, f, g ) ).
	 */
	public static <A, B, C, D, E, F, G, H, I> Function7<A, B, C, D, E, F, G, I> fOf(final Function1<H, I> f1, final Function7<A, B, C, D, E, F, G, H> f2){
		return new Function7<A, B, C, D, E, F, G, I>(){

			@Override
			public I f(A a, B b, C c, D d, E e, F f, G g) {
				return f1.f(f2.f(a, b, c, d, e, f, g));
			}
		};
	}
	
	/**
	 * Function composition. Takes two functions <b>f1</b> and <b>f2</b>
	 * and gives the function f1( f2( a, b, c, d, e, f, g, h ) ).
	 * 
	 * @param f1 The <i>outer</i> function.
	 * @param f2 The <i>inner</i> function.
	 * @return The function f1( f2( a, b, c, d, e, f, g, h ) ).
	 */
	public static <A, B, C, D, E, F, G, H, I, J> Function8<A, B, C, D, E, F, G, H, J> fOf(final Function1<I, J> f1, final Function8<A, B, C, D, E, F, G, H, I> f2){
		return new Function8<A, B, C, D, E, F, G, H, J>(){

			@Override
			public J f(A a, B b, C c, D d, E e, F f, G g, H h) {
				return f1.f(f2.f(a, b, c, d, e, f, g, h));
			}
		};
	}
	
	/**
	 * Function composition. Takes two functions <b>f1</b> and <b>f2</b>
	 * and gives the function f1( f2( a, b, c, d, e, f, g, h, i ) ).
	 * 
	 * @param f1 The <i>outer</i> function.
	 * @param f2 The <i>inner</i> function.
	 * @return The function f1( f2( a, b, c, d, e, f, g, h, i ) ).
	 */
	public static <A, B, C, D, E, F, G, H, I, J, K> Function9<A, B, C, D, E, F, G, H, I, K> fOf(final Function1<J, K> f1, final Function9<A, B, C, D, E, F, G, H, I, J> f2){
		return new Function9<A, B, C, D, E, F, G, H, I, K>(){

			@Override
			public K f(A a, B b, C c, D d, E e, F f, G g, H h, I i) {
				return f1.f(f2.f(a, b, c, d, e, f, g, h, i));
			}
		};
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	/**
	 * 
	 * @param f
	 * @return
	 */
	public static <A, B, C> Function2<A, B, C> curry(final Function1<Tuple2<A, B>, C> f){
		return new Function2<A, B, C>() {

			@Override
			public C f(A a, B b) {
				return f.f(new Tuple2<A, B>(a, b));
			}
		};
	}
	
	/**
	 * 
	 * @param f
	 * @return
	 */
	public static <A, B, C> Function1<Tuple2<A, B>, C> uncurry(final Function2<A, B, C> f){
		return new Function1<Tuple2<A,B>, C>() {

			@Override
			public C f(Tuple2<A, B> t) {
				return f.f(t.first, t.second);
			}
		};
	}
}
