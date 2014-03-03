package se.xell.util;

import java.io.Serializable;
import java.util.EmptyStackException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * A stack based on a linked data structure.
 * 
 * LinkedStack doesn't allow null elements.
 * 
 * @author Tobias Axell
 *
 * @param <E> The type of the element stored in this stack.
 */
public class LinkedStack<E> extends AbstractStack<E> implements Stack<E>, Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7467813494323533072L;
	
	protected Node<E> head;
	protected int size;
	
	/**
	 * Constructor for LinkedStack.
	 */
	public LinkedStack(){
		size = 0;
		head = null;
	}
	
	@Override
	public void push(E element){
		add(element);
	}
	
	@Override
	public E pop(){
		if(size == 0){ 
			throw new EmptyStackException();
		}
		final E r = head.element;
		head = head.next;
		size--;
		return r;
	}
	
	@Override
	public E peek(){
		if(size == 0){
			throw new EmptyStackException();
		}
		return head.element;
	}
	
	@Override
	public boolean add(E arg0) {
		if(arg0 == null){
			throw new NullPointerException("nu.xell.util.LinkedStack does not permit null elements");
		}
		head = new Node<>(arg0, head);
		size++;
		return true;
	}

	@Override
	public void clear() {
		head = null;
		size = 0;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public Iterator<E> iterator() {
		return new LinkedStackIterator();
	}

	@Override
	public int size() {
		return size;
	}
	
	/**
	 * A node for the link structure. A node has
	 * an element, and a reference to the next node.
	 * 
	 * @author Tobias Axell
	 *
	 * @param <E> The type of the element of this node.
	 */
	protected static class Node<E>{
		
		/**
		 * 
		 */
		public final E element;
		
		/**
		 * 
		 */
		protected Node<E> next;
		
		/**
		 * Constructor for Node.
		 * 
		 * @param elem The element to store in this node.
		 */
		public Node(E elem){
			element = elem;
		}
		
		/**
		 * Constructor for Node.
		 * 
		 * @param elem The element to store in this node.
		 * @param next The node to link this node to.
		 */
		public Node(E elem, Node<E> next){
			element = elem;
			this.next = next;
		}
	}
	
	/**
	 * Iterator for LinkedStack
	 * 
	 * @author Tobias Axell
	 */
	protected class LinkedStackIterator extends AbstractStack<E>.StackIterator{
		
		private Node<E> current;
		
		/**
		 * Constructor for LinkedStackIterator.
		 */
		public LinkedStackIterator(){
			current = head;
		}
		
		@Override
		public boolean hasNext() {
			return current != null;
		}

		@Override
		public E next() {
			if(current == null){
				throw new NoSuchElementException();
			}
			final E r = current.element;
			current = current.next;
			return r;
		}
	}
}
