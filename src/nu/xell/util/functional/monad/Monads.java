package nu.xell.util.functional.monad;

import nu.xell.util.functional.Function1;

/**
 * A class with static monad related functions.
 * 
 * @author Tobias Axell
 */
public final class Monads {

	private Monads() {}

	/**
	 * The bind function is the function that <i>binds</i> the computational "steps" together.
	 * It takes the value(s) of a given monadic object and passes it to a given function creating
	 * a new monadic object. Corresponds to the (>>=) operator in Haskell.
	 * 
	 * @param m The monadic object to bind from.
	 * @param f The function to apply to the value(s) held in the monadic object, <i>m</i>.
	 * @return The result of applying to the function <i>f</i> to the value(s) held in the monadic object, <i>m</i>.
	 */
	public static <A, B, M extends Monad<M, A>, N extends Monad<M, B>> N bind(M m, Function1<A, N> f) {
		try{
			return m.bind(f);
		} catch (Throwable t){
			return m.fail(t.getMessage());
		}
	}
	
	/**
	 * The then function is derived from the bind function. Calling <i>then</i> with argument <i>a</i> and 
	 * <i>b</i> is equivalent to <i>bind</i> the monadic object <i>a</i> with a function that takes an argument, 
	 * does nothing with it and returns <i>b</i>. Then is used when one wants to perform some action/computation 
	 * step in a sequence but does not care about keeping the result. Then is defined by:<br></br><br></br>
	 * 
	 * <code>m.then( v ) = m.bind( (function f(x) = v ) )</code> <br></br><br></br>
	 * 
	 * Corresponds to the (>>) operator in Haskell.
	 * 
	 * @param a The monadic object to "bind" from.
	 * @param b The monadic value that the function passed to bind always should return.
	 * @return The result of calling bind with a function that always return <i>m</i>.
	 */
	public static <A, B, M extends Monad<M, A>, N extends Monad<M, B>> N then(M a, N b) {
		try{
			return a.then(b);
		} catch (Throwable t){
			return a.fail(t.getMessage());
		}
	}
}
