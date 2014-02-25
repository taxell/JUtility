package nu.xell.util.functional.monad;

import nu.xell.util.functional.Function1;

/**
 * "In functional programming, a monad is a structure that represents
 * computations defined as sequences of steps" 
 * <a href="http://en.wikipedia.org/wiki/Monad_(functional_programming)">[1]</a>. 
 * Monads can be used for a variety of tasks; error handling, I/O handling, logging, 
 * are just a few examples. For more information and heavy theory: <br></br>
 * 
 * <ul>
 * <li><a href="http://en.wikipedia.org/wiki/Monad_(functional_programming)">[1]; Wikipedia</a></li>
 * <li><a href="http://learnyouahaskell.com/a-fistful-of-monads">Learn You A Haskell</a></li>
 * <li><a href="http://www.haskell.org/haskellwiki/Monad">Haskell Wiki</a></li>
 * </ul>
 * <br></br><br></br>
 * 
 * Except for the methods specified by this interface each non-abstract class implementing
 * this interface shall have two static methods <i>unitS</i> and <i>failS</i> that are static
 * versions of the methods <i>insert</i> and <i>fail</i>. The type signatures and implementations 
 * of insert compared to insertS and fail compared to failS shall be identical.
 * <br></br><br></br>
 * 
 * Also; for all implementations of Monad the following equivalences, <i>the monad laws</i>, has
 * to hold: <br></br><br></br>
 * <code>insertS( x ).bind( f ) &lt;=&gt; f.f( x )</code> <br></br>
 * <code>m.bind( insert )       &lt;=&gt; m </code> <br></br>
 * <code>m.bind( f ).bind( g )  &lt;=&gt; m.bind( function h(x) = f.f( x ).bind( g ) ) </code> <br></br>
 * <br></br>
 * 
 * Here they are expressed in Haskell: <br></br><br></br>
 * 
 * <code>(return x) >>= f  &lt;=&gt;  f x</code> <br></br>
 * <code>m >>= return  	   &lt;=&gt;  m</code> <br></br>
 * <code>(m >>= f) >>= g   &lt;=&gt;  m >>= ( \x -> (f x >>= g) )</code> <br></br>
 * 
 * @author Tobias Axell
 *
 * @param <M> This should be set to be the concrete class (without type parameters) that imlpements 
 * 				the monad interface. Example: if you want MyClass&lt;V&gt; to be a monad then you should 
 * 				declare it as: <code>MyClass&lt;V&gt; implements Monad&lt;MyClass, V&gt; </code>.
 * 				Your compiler and/or IDE may warn you for "rawtypes", i haven't however found a good way
 * 				to get around this without losing some really nice features of the monad.
 * @param <A> The type of the value(s) "handled" by the monad.
 */
public interface Monad<M, A> {
	
	/**
	 * The bind function is the function that <i>binds</i> the computational "steps" together.
	 * It takes the value(s) of this monadic object and passes it to the given function creating
	 * a new monadic object. Corresponds to the (>>=) operator in Haskell.
	 * 
	 * @param f The function to apply to the value(s) held in this monadic object.
	 * @return The result of applying to the function <i>f</i> to the value(s) held in this monadic object.
	 */
	public <B, N extends Monad<M, B>> N bind(Function1<A, N> f);
	
	/**
	 * The then function is derived from the bind function. Calling <i>then</i> with argument <i>m</i> 
	 * is equivalent to <i>bind</i> with a function that takes an argument, does nothing with it 
	 * and returns <i>m</i>. Then is used when one wants to execute some computation step in a sequence
	 * but does not care about keeping the result. Then is defined by:<br></br><br></br>
	 * 
	 * <code>m.then( v ) = m.bind( (function f(x) = v ) )</code> <br></br><br></br>
	 * 
	 * Corresponds to the (>>) operator in Haskell.
	 * 
	 * @param m The monadic value that the function passed to bind always should return.
	 * @return The result of calling bind with a function that always return <i>m</i>.
	 */
	public <B, N extends Monad<M, B>> N then(final N m);
	
	/**
	 * Inserts a value into the monad. This method
	 * corresponds to the "return" function in Haskell.
	 * 
	 * @param value The value to insert.
	 * @return The argument value wrapped in the monad.
	 */
	public <B, N extends Monad<M, B>> N unit(B value);
	
	/**
	 * The fail method should be called when a monadic computation fails. The
	 * fail method should either throw a MonadFailException with the
	 * argument message passed on, or return a suitable value of the concrete
	 * monadic type that represents a failed computation.
	 * 
	 * @param msg A String message describing what went wrong.
	 * @return A monadic value representing a failed computation, if such a value exists.
	 * @throws MonadFailException If no suitable value representing failure exists for 
	 * 			the concrete class implementing this interface, this method should throw 
	 * 			a MonadFailException.
	 */
	public <B, N extends Monad<M, B>> N fail(String msg) throws MonadFailException;
}
