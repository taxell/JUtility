package nu.xell.util.functional;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * A class with static list functions.
 * 
 * @author Tobias Axell
 */
public final class Lists {
	
	private Lists(){}
	
	/**
	 * Converts a FunctionalList to a java.util.List.
	 * This method takes a java.util.List, clears it,
	 * and fills it with the content of the given
	 * FunctionalList.
	 * 
	 * Converts a FunctionalList to a java.util.List.
	 * 
	 * @param fl The FunctionalList to convert.
	 * @param l The List to convert <i>fl</i> into.
	 * @return The list <i>l</i> containing the elements of <i>fl</i>
	 * 			in the same order as in <i>fl</i>.
	 */
	public static <T> List<T> toList(FunctionalList<T> fl, List<T> l){
		l.clear();
		
		Iterator<T> i = fl.iterator();
		while (i.hasNext()) {
			l.add(i.next());
		}
		
		return l;
	}
	
	/**
	 * Converts a FunctionalList to a java.util.List.
	 * 
	 * @param fl The FunctionalList to convert.
	 * @return A List containing the elements of <i>fl</i>
	 * 			in the same order as in <i>fl</i>.
	 */
	public static <T> List<T> toList(FunctionalList<T> fl){
		List<T> result = new ArrayList<>(fl.length());
		
		Iterator<T> i = fl.iterator();
		while (i.hasNext()) {
			result.add(i.next());
		}
		
		return result;
	}
	
	/**
	 * Converts a java.util.List into a FunctionalList
	 * @param l The List to convert.
	 * @return A FunctionalList containing the elements of <i>fl</i>
	 * 			in the same order as in <i>fl</i>.
	 */
	public static <T> FunctionalList<T> fromList(List<T> l){
		// May be changed later, but for now FList is my
		// default implementation of FunctionalList.
		return FList.fromList(l);
	}
	
	/**
	 * Checks if a list is nil (is empty).
	 * 
	 * @param l The list to check.
	 * @return True if the list is nil, false otherwise.
	 */
	public static boolean isNil(FunctionalList<?> l){
		return l.isNil();
	}
	
	/**
	 * Gives the length of a list.
	 * 
	 * @param l The list to get the length of.
	 * @return The length of the list.
	 */
	public static int length(FunctionalList<?> l){
		return l.length();
	}
	
	/**
	 * Splits up a list in head and tail.
	 * 
	 * @param l The list to split.
	 * @return A 2-tuple containing the head and tail of the list. 
	 */
	public static <E> Tuple2<E, FunctionalList<E>> split(FunctionalList<E> l){
		return l.split();
	}
	
	/**
	 * Gives the head of a list.
	 * 
	 * @param l The list to get the head of.
	 * @return The head of the list.
	 */
	public static <E> E head(FunctionalList<E> l){
		return l.head();
	}
	
	/**
	 * Gives the tail of a list.
	 * 
	 * @param l The list to get the tail of.
	 * @return The tail of the list.
	 */
	public static <E> FunctionalList<E> tail(FunctionalList<E> l){
		return l.tail();
	}
	
	/**
	 * Takes the <i>i</i> first elements of a list. If <i>i</i>
	 * is 0 or smaller, the empty list is returned, if <i>i</i> is
	 * greater than the length of the list, the entire list is
	 * returned.
	 * 
	 * @param i The number of elements to take.
	 * @param l The list to take elements from.
	 * @return A list containing the <b>i</b> first elements of the list <i>l</i>.
	 */
	public static <E> FunctionalList<E> take(int n, FunctionalList<E> l){
		return l.take(n);
	}
	
	/**
	 * Takes a list <b>l</b> and a number <b>i</b> and returns a
	 * list of all elements of this list except for the <b>i</b>
	 * first i.e. the elements of this list that is <i>not</i>
	 * returned by <i>take( <b>i</b> )</i>.
	 * 
	 * @param i The number of elements to drop.
	 * @param l The list to drop elements from.
	 * @return A list containing all elements of the list <i>l</i>, except the <b>i</b> first.
	 */
	public static <E> FunctionalList<E> drop(int n, FunctionalList<E> l){
		return l.drop(n);
	}
	
	/**
	 * Gives the element on index <i>i</i> in the list <i>l</i>.
	 * 
	 * @param i The index of the element to get.
	 * @param l The list to retrieve an element from.
	 * @return The <i>i</i>:th element of the list <i>l</i>.
	 */
	public static <E> E get(int i, FunctionalList<E> l){
		return l.get(i);
	}
	
	/**
	 * Concatenates two functional lists.
	 * 
	 * @param l1 The first list.
	 * @param l2 The second list.
	 * @return The concatenation; <i>l1</i>+<i>l2</i>
	 */
	public static <E> FunctionalList<E> concat(FunctionalList<E> l1, FunctionalList<E> l2){
		return l1.concat(l2);
	}
	
	/**
	 * Takes a list of lists and concatenates these to one big list.
	 * 
	 * @param l The list of lists to concatenate.
	 * @return The result of concatenating all lists of <i>l</i>.
	 */
	public static <E> FunctionalList<E> concat2(FunctionalList<FunctionalList<E>> l){
		return foldl1(new Function2<FunctionalList<E>, FunctionalList<E>, FunctionalList<E>>() {

			@Override
			public FunctionalList<E> f(FunctionalList<E> a, FunctionalList<E> b) {
				return a.concat(b);
			}

		}, l);
	}
	
	/**
	 * 
	 * @param f
	 * @return
	 */
	public <E,D> FunctionalList<D> map(Function1<E,D> f, FunctionalList<E> l){
		return l.map(f);
	}
	
	/**
	 * 
	 * @param f
	 * @param d
	 * @return
	 */
	public <E, D> D foldr(Function2<E, D, D> f, D d, FunctionalList<E> l){
		return l.foldr(f, d);
	}
	
	/**
	 * 
	 * @param f
	 * @return
	 */
	public <E> E foldr1(Function2<E, E, E> f, FunctionalList<E> l){
		return l.foldr1(f);
	}
	
	/**
	 * 
	 * @param f
	 * @param a
	 * @return
	 */
	public <E, D> D foldl(Function2<D, E, D> f, D a, FunctionalList<E> l){
		return l.foldl(f, a);
	}
	
	/**
	 * 
	 * @param f
	 * @return
	 */
	public static <E> E foldl1(Function2<E, E, E> f, FunctionalList<E> l){
		return l.foldl1(f);
	}
	
	//////////////////////////////////////////////////////////////////////////////////////////
	
	/**
	 * The map function is a common higher order function in functional
	 * programming. The map function takes a list of elements of any type
	 * <i>K</i> and a function of type <i>f : K -> V</i> and creates a new
	 * list containing the results of applying the argument function to all
	 * elements in the argument list.
	 * 
	 * @param fun A function <i>f : K -> V</i>
	 * @param list A list with elements of type K
	 * @return A list <i>L</i> with elements of type <i>V</i> where the element
	 * 			at index <i>i</i> is computed by applying the argument 
	 * 			function to the element at index <i>i</i> in the argument
	 * 			list.
	 */
	public static <V, K> List<V> map(Function1<K, V> fun, List<K> list){
		ArrayList<V> newList = new ArrayList<>(list.size());
		for(int i = 0; i < list.size(); i++){
			newList.add(fun.f(list.get(i)));
		}
		return newList;
	}
	
	/**
	 * <p>The map function is a common higher order function in functional
	 * programming. The map function takes a list of elements of any type
	 * <i>K</i> and a function of type <i>f : K -> V</i> and creates a new
	 * list containing the results of applying the argument function to all
	 * elements in the argument list.</p>
	 * 
	 * <p>The pmap function is a <i>parallelized</i> version of map. This
	 * one calculates all values of the new list in a separate thread.</p>
	 * 
	 * @param fun A function <i>f : K -> V</i>
	 * @param list A list with elements of type K
	 * @return A list <i>L</i> with elements of type <i>V</i> where the element
	 * 			at index <i>i</i> is computed by applying the argument 
	 * 			function to the element at index <i>i</i> in the argument
	 * 			list.
	 */
	public static <V, K> List<V> pmap(Function1<K, V> fun, List<K> list){
		@SuppressWarnings("unchecked")
		V[] newList = (V[])(new Object[list.size()]);
		Thread[] threads = new Thread[list.size()];
		
		for(int i = 0; i < list.size(); i++){
			threads[i] = new Thread(new MapWorker<K, V>(fun, list.get(i), i, newList));
			threads[i].start();
		}
		
		for(int i = 0; i < threads.length; i++){
			try {
				threads[i].join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		ArrayList<V> result = new ArrayList<>(newList.length);
		for(int i = 0; i < newList.length; i++){
			result.add(newList[i]);
		}
		
		return result;
	}
	
	/**
	 * <p>The map function is a common higher order function in functional
	 * programming. The map function takes a list of elements of any type
	 * <i>K</i> and a function of type <i>f : K -> V</i> and creates a new
	 * list containing the results of applying the argument function to all
	 * elements in the argument list.</p>
	 * 
	 * <p>The pmap function is a <i>parallelized</i> version of map. This
	 * one calculates all values of the new list in a specified number of
	 * threads.</p>
	 * 
	 * @param fun A function <i>f : K -> V</i>
	 * @param list A list with elements of type K
	 * @param threads The number of threads to use
	 * @return A list <i>L</i> with elements of type <i>V</i> where the element
	 * 			at index <i>i</i> is computed by applying the argument 
	 * 			function to the element at index <i>i</i> in the argument
	 * 			list.
	 */
	public static <V, K> List<V> pmap(Function1<K, V> fun, List<K> list, int threads){
		@SuppressWarnings("unchecked")
		V[] newList = (V[])(new Object[list.size()]);
		
		if(threads < 1){
			throw new IllegalArgumentException("The number of threads must be greater than 0");
		}
		
		Thread[] ts = new Thread[threads];
		
		int ptr = 0;
		int chunkSize = list.size() / threads;
		
		
		for(int i = 0; i < ts.length && ptr < list.size(); i++){
			ts[i] = new Thread(new MapWorker2<>(fun, list, newList, ptr, ptr + chunkSize));
			ptr += chunkSize;
		}
		
		if(ts[ts.length - 1] == null){
			ts[ts.length - 1] = new Thread(new MapWorker2<>(fun, list, newList, ptr, list.size() - 1));
		}
		
		for(int i = 0; i < ts.length; i++){
			ts[i].start();
		}
		
		for(int i = 0; i < ts.length; i++){
			try {
				ts[i].join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		List<V> ret = new ArrayList<>(newList.length);
		for(int i = 0; i < newList.length; i++){
			ret.add(newList[i]);
		}
		return ret;
	}
	
	
	private static class MapWorker<K, V> implements Runnable{
		
		protected final Function1<K, V> mappingStrategy;
		protected final int index;
		protected final V[] results;
		protected final K key;
		
		public MapWorker(Function1<K, V> mappingStrategy, K key, int i, V[] res){
			this.mappingStrategy = mappingStrategy;
			this.key = key;
			this.index = i;
			this.results = res;
		}
		
		@Override
		public void run() {
			results[index] = mappingStrategy.f(key);
		}
		
	}
	
	protected static class MapWorker2<K, V> implements Runnable{
		protected final Function1<K, V> mappingStrategy;
		protected final int 	fromI;
		protected final int 	toI;
		protected final List<K> keys;
		protected final V[] 	results;
		
		public MapWorker2(Function1<K, V> ms, List<K> keys, V[] res, int from, int to){
			this.mappingStrategy = ms;
			this.keys = keys;
			this.results = res;
			fromI = from;
			toI = to;
		}
		
		@Override
		public void run() {
			for(int i = fromI; i < toI; i++){
				results[i] = mappingStrategy.f(keys.get(i));
			}
		}
	}
}
