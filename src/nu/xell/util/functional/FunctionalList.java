package nu.xell.util.functional;

import nu.xell.util.functional.monad.Monad;

/**
 * A functional list is a type of list inspired by lists in functional programming languages.
 * Functional lists are, seen from a high level perspective, linked lists with a head and a
 * tail, however they do not necessarily have to be implemented as such.
 * 
 * Functional lists should apart form implementing this interface fulfill the following 
 * criteria:
 * 
 * <ul>
 * 		<li>They should be immutable; list operations shall return new lists, not modifying
 * 			current ones.</li>
 * 		<li>They should have two static constructor functions:
 * 				 <dl>
 * 				    <dt>public static &lt;T&gt; MyList&lt;T&gt; nil()</dt>
 * 						<dd>Constructs a nil list.</dd>
 * 				 	<dt>public static &lt;T&gt; MyList&lt;T&gt; cons(T head, MyList&lt;T&gt; tail)</dt>
 * 						<dd>Constructs a list from an element and a given list by putting the given
 * 							element "in front of" the given list.</dd>
 * 				 </dl>
 * 
 * 				 Other constructors should, if they do not directly correspond to the above mentioned
 * 				 methods be protected or final.
 * 		</li>
 * 
 * </ul>
 * 
 * @author Tobias Axell
 *
 * @param <E> The type of the elements in the list.
 */
@SuppressWarnings("rawtypes")
public interface FunctionalList<E> extends Iterable<E>, Monad<FunctionalList, E>, Functor<E>, Monoid<FunctionalList<E>> {
	
	/**
	 * Checks if the list is nil (is empty).
	 * 
	 * @return True if this list is nil, false otherwise.
	 */
	public boolean isNil();
	
	/**
	 * Gives the length of a list.
	 * 
	 * @return The length of this list.
	 */
	public int length();
	
	/**
	 * Splits up the list in its head and tail.
	 * 
	 * @return A 2-tuple containing the head and tail of the list. 
	 */
	public Tuple2<E, FunctionalList<E>> split();
	
	/**
	 * Gives the head of a list.
	 * 
	 * @return The head of this list.
	 */
	public E head();
	
	/**
	 * Gives the tail of the list.
	 * 
	 * @return The tail of the list.
	 */
	public FunctionalList<E> tail();
	
	/**
	 * Takes the <i>i</i> first elements of a list. If <i>i</i>
	 * is 0 or smaller, the empty list is returned, if <i>i</i> is
	 * greater than the length of the list, the entire list is
	 * returned.
	 * 
	 * @param i The number of elements to take.
	 * @return A list containing the <b>i</b> first elements of this list.
	 */
	public FunctionalList<E> take(int i);
	
	/**
	 * Takes a list <b>l</b> and a number <b>i</b> and returns a
	 * list of all elements of this list except for the <b>i</b>
	 * first i.e. the elements of this list that is <i>not</i>
	 * returned by <i>take( <b>i</b> )</i>.
	 * 
	 * @param i The number of elements to drop.
	 * @return A list containing all elements of this list, except the <b>i</b> first.
	 */
	public FunctionalList<E> drop(int n);
	
	/**
	 * Gives the element on index <i>i</i>.
	 * 
	 * @param i The index of the element to get.
	 * @return The <i>i</i>:th element of this list
	 */
	public E get(int i);
	
	/**
	 * Concatenates this list with a given list.
	 * 
	 * @param l The list to concatenate this list with.
	 * @return The concatenation; <i>this</i>+<i>l</i>.
	 */
	public FunctionalList<E> concat(FunctionalList<E> l);
	
	/**
	 * Applies the given function to all elements of this
	 * list and returns a list of all the results.
	 * 
	 * @param f The function to apply on all elements.
	 * @return A list of the results of applying the function
	 * 			<i>f</i> to the elements of this list.
	 */
	public <D> FunctionalList<D> map(Function1<E,D> f);
	
	/**
	 * Folds this list from the right with a given function 
	 * <i>f</i> and a given base element <i>d</i>. For more information
	 * about fold operations, please read: <br></br>
	 * <a href="http://en.wikipedia.org/wiki/Fold_(higher-order_function)">This related wikipedia article</a> <br></br>
	 * <a href="http://learnyouahaskell.com/higher-order-functions#folds">Learn you a Haskell</a>
	 * 
	 * @param f The function to fold with.
	 * @param d The base element for the fold operation.
	 * @return The result of reducing this list with the given function and base element.
	 */
	public <D> D foldr(Function2<E, D, D> f, D d);
	
	/**
	 * Foldr1 is a special case of foldr, that has the same return type as
	 * the type of the elements in the list and has no base element. Foldr1 is
	 * therefore undefined for the empty list. <br></br><br></br>
	 * 
	 * Example: foldr1 on the list [1, 2, 3, 4] with the function +, (as in addition),
	 * is 1 + 2 + 3 + 4.
	 * 
	 * @param f The function to fold with.
	 * @return The result of reducing this list with the given function.
	 * @throws UndefinedOperationException If this list is nil.
	 */
	public E foldr1(Function2<E, E, E> f);
	
	/**
	 * Folds this list from the left with a given function 
	 * <i>f</i> and a given base element <i>d</i>. For more information
	 * about fold operations, please read: <br></br>
	 * <a href="http://en.wikipedia.org/wiki/Fold_(higher-order_function)">This related wikipedia article</a> <br></br>
	 * <a href="http://learnyouahaskell.com/higher-order-functions#folds">Learn you a Haskell</a>
	 * 
	 * @param f The function to fold with.
	 * @param d The base element for the fold operation.
	 * @return The result of reducing this list with the given function and base element.
	 */
	public <D> D foldl(Function2<D, E, D> f, D d);
	
	/**
	 * Foldl1 is a special case of foldl, that has the same return type as
	 * the type of the elements in the list and has no base element. Foldl1 is
	 * therefore undefined for the empty list. <br></br><br></br>
	 * 
	 * Example: foldl1 on the list [1, 2, 3, 4] with the function +, (as in addition),
	 * is 1 + 2 + 3 + 4.
	 * 
	 * @param f The function to fold with.
	 * @return The result of reducing this list with the given function.
	 * @throws UndefinedOperationException If this list is nil.
	 */
	public E foldl1(Function2<E, E, E> f);
}