package se.xell.util.statemachine;

/**
 * 
 * @author Tobias Axell
 *
 * @param <S>
 * @param <T>
 */
public interface StateMachine<S, T> {
	
	public S getCurrentState();
	
	public void signal(T signal);
}
