package nu.xell.util.functional.monad;

import nu.xell.util.functional.Function1;

/**
 * A default implementation of the monadic <i>then</i> and <i>fail</i>
 * methods.
 * 
 * @author Tobias Axell
 *
 * @param <M> The concrete type of the monad.
 * @param <A> The type of the value within the monad.
 */
public abstract class AbstractMonad<M, A> implements Monad<M, A> {

	@Override
	public <B, N extends Monad<M, B>> N then(final N m) {
		return bind(new Function1<A, N>(){
			@Override
			public N f(A a) {
				return m;
			}
		});
	}

	@Override
	public <B, N extends Monad<M, B>> N fail(String msg) {
		throw new MonadFailException(msg);
	}
}
