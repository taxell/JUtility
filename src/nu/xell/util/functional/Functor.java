package nu.xell.util.functional;

/**
 * A functor is a data type that can be mapped over. A functor can be seen as 
 * a box containing some item(s) of type A on which a function <i>f : A -> B</i>
 * can be applied resulting in a box containing item(s) of type B. Note, a
 * functor does not necessarily have to be a container, the box analogy is just
 * a good way of explaining functors.<br></br><br></br>
 * 
 * For more information, visit: <a href="http://en.wikipedia.org/wiki/Functor">Wikipedia</a>, 
 * <a href="http://learnyouahaskell.com/functors-applicative-functors-and-monoids">Learn you a Haskell</a>,
 * or <a href="http://www.haskellforall.com/2012/09/the-functor-design-pattern.html">Haskell for all</a>.
 * 
 * @author Tobias Axell
 *
 * @param <E> The type of the element(s) in the "box".
 */
public interface Functor<E> {

	/**
	 * The mapping function, maps a given function over the functor.
	 * 
	 * @param f The function to map over the functor.
	 * @return A functor 'containing element(s)' that is the result of applying
	 * the function <i>f</i> to the 'element(s)' of this functor.
	 */
	public <D> Functor<D> fMap(Function1<E, D> f);
}
