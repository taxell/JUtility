package se.xell.util;

import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;

/**
 * An abstract stack implementing the parts of the Collection interface
 * that is specific to stacks.
 * 
 * @author Tobias Axell
 *
 * @param <E> The type of the elements stored in the stack.
 */
public abstract class AbstractStack<E> extends AbstractCollection<E> implements
		Stack<E>, Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5578359535826957467L;

	/**
	 * {@inheritDoc}
	 * <br></br>
	 * This implementation pushes all elements onto this stack in the order 
	 * that they are given by the iterator given by <code>arg0.iterator()<code>
	 */
	@Override
	public boolean addAll(Collection<? extends E> arg0) {
		int start = size();
		
		Iterator<? extends E> i = arg0.iterator();
		
		while(i.hasNext()){
			push(i.next());
		}
		
		return size() != start;
	}
	
	/**
	 * {@inheritDoc}
	 * <br></br>
	 * NOTE: Throws UnsupportedOperationException; 
	 * the only way to remove elements from a stack
	 * should be by popping the top elements off the
	 * stack, or clear the entire stack.
	 */
	@Override
	public final boolean remove(Object o){
		throw new UnsupportedOperationException();
	}
	
	/**
	 * {@inheritDoc}
	 * <br></br>
	 * NOTE: Throws UnsupportedOperationException; 
	 * the only way to remove elements from a stack
	 * should be by popping the top elements off the
	 * stack, or clear the entire stack.
	 */
	@Override
	public final boolean removeAll(Collection<?> c){
		throw new UnsupportedOperationException();
	}
	
	/**
	 * {@inheritDoc}
	 * <br></br>
	 * NOTE: Throws UnsupportedOperationException; 
	 * the only way to remove elements from a stack
	 * should be by popping the top elements off the
	 * stack, or clear the entire stack.
	 */
	@Override
	public final boolean retainAll(Collection<?> c){
		throw new UnsupportedOperationException();
	}
	
	/**
	 * An abstract iterator for stacks
	 * 
	 * @author Tobias Axell
	 */
	public abstract class StackIterator implements Iterator<E>{
		
		/**
		 * {@inheritDoc}
		 * <br></br>
		 * NOTE: Throws UnsupportedOperationException; 
		 * the only way to remove elements from a stack
		 * should be by popping the top elements off the
		 * stack, or clear the entire stack.
		 */
		@Override
		public final void remove(){
			throw new UnsupportedOperationException();
		}
	}
}
