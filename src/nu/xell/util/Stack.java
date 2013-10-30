package nu.xell.util;

import java.util.Collection;

/**
 * 
 * @author Tobias Axell
 *
 * @param <E> The type of the element stored in this stack.
 */
public interface Stack<E> extends Collection<E> {

	/**
	 * Pushes an element onto the stack.
	 * 
	 * @param element The element to push.
	 */
	public void push(E elem);
	
	/**
	 * Removes the top element from the stack and returns that element.
	 * 
	 * @return The former top element of the stack.
	 */
	public E pop();
	
	/**
	 * Gives the top element of the stack without modifying the stack.
	 * 
	 * @return The top element of the stack.
	 */
	public E peek();
}
