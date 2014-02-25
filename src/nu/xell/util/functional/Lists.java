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
	 * Applies the given function to all elements of the given
	 * list and returns a list of all the results.
	 * 
	 * @param f The function to apply on all elements of the given list.
	 * @param l The list to map over.
	 * @return A list of the results of applying the function
	 * 			<i>f</i> to the elements of the list <i>l</i>.
	 */
	public <E,D> FunctionalList<D> map(Function1<E,D> f, FunctionalList<E> l){
		return l.map(f);
	}
	
	/**
	 * Folds a given list <i>l</i> from the right with a given function 
	 * <i>f</i> and a given base element <i>d</i>. For more information
	 * about fold operations, please read: <br></br>
	 * <a href="http://en.wikipedia.org/wiki/Fold_(higher-order_function)">This related wikipedia article</a> <br></br>
	 * <a href="http://learnyouahaskell.com/higher-order-functions#folds">Learn you a Haskell</a>
	 * 
	 * @param f The function to fold with.
	 * @param d The base element for the fold operation.
	 * @param l The list to fold over.
	 * @return The result of reducing the given list with the given function and base element.
	 */
	public <E, D> D foldr(Function2<E, D, D> f, D d, FunctionalList<E> l){
		return l.foldr(f, d);
	}
	
	/**
	 * Foldr1 is a special case of foldr, that has the same return type as
	 * the type of the elements in the given list and has no base element. Foldr1 is
	 * therefore undefined for the empty list. <br></br><br></br>
	 * 
	 * Example: foldr1 on the list [1, 2, 3, 4] with the function +, (as in addition),
	 * is 1 + 2 + 3 + 4.
	 * 
	 * @param f The function to fold with.
	 * @param l The list to fold over.
	 * @return The result of reducing this list with the given function.
	 * @throws NilListException If this list is nil.
	 */
	public <E> E foldr1(Function2<E, E, E> f, FunctionalList<E> l){
		return l.foldr1(f);
	}
	
	/**
	 * Folds a given list <i>l</i> from the left with a given function 
	 * <i>f</i> and a given base element <i>d</i>. For more information
	 * about fold operations, please read: <br></br>
	 * <a href="http://en.wikipedia.org/wiki/Fold_(higher-order_function)">This related wikipedia article</a> <br></br>
	 * <a href="http://learnyouahaskell.com/higher-order-functions#folds">Learn you a Haskell</a>
	 * 
	 * @param f The function to fold with.
	 * @param d The base element for the fold operation.
	 * @param l The list to fold over.
	 * @return The result of reducing the given list with the given function and base element.
	 */
	public <E, D> D foldl(Function2<D, E, D> f, D a, FunctionalList<E> l){
		return l.foldl(f, a);
	}
	
	/**
	 * Foldl1 is a special case of foldl, that has the same return type as
	 * the type of the elements in the given list and has no base element. Foldl1 is
	 * therefore undefined for the empty list. <br></br><br></br>
	 * 
	 * Example: foldl1 on the list [1, 2, 3, 4] with the function +, (as in addition),
	 * is 1 + 2 + 3 + 4.
	 * 
	 * @param f The function to fold with.
	 * @param l The list to fold over.
	 * @return The result of reducing this list with the given function.
	 * @throws NilListException If this list is nil.
	 */
	public static <E> E foldl1(Function2<E, E, E> f, FunctionalList<E> l){
		return l.foldl1(f);
	}
	
	//////////////////////////////////////////////////////////////////////////////////////////
	/////////////////// Higher order functions on java.util.List lists ///////////////////////
	
	// MAP
	
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
	
	private static class MapWorker2<K, V> implements Runnable{
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
	
	//////////////////////////////////////////////////////////////////////////////////////////
	// ZIP
	
	/**
	 * Zip takes two lists containing elements of any two types and
	 * pairs the elements together creating a list of tuples, where each tuple contains one element
	 * from each list. If one list has more elements than the other the "extra" elements are
	 * left out.
	 * 
	 * @param as One of the lists to pick elements from.
	 * @param bs The other list to pick elements from.
	 * @return A single list of pairs of elements from the lists <i>as</i> and <i>bs</i>.
	 */
	public static <A, B> List<Tuple2<A, B>> zip(List<A> as, List<B> bs){
		//TODO (low level) optimize by implementing "manually" without zipWith
		return zipWith(new Function2<A, B, Tuple2<A, B>>() {
			@Override
			public Tuple2<A, B> f(A a, B b) {
				return new Tuple2<>(a,b);
			}
		}, as, bs);
	}
	
	/**
	 * The "inverted" zip function. Unzip takes a list of pairs (2-tuples) and
	 * splits the pairs, returning a pair of lists, each list containing one "side" of the pair
	 * elements of the argument list.
	 * 
	 * @param ts A list of pairs of elements to split up.
	 * @return Two lists (in a tuple) containing the elements from the tuples in the original 
	 * 			list separated.
	 */
	public static <A, B> Tuple2<List<A>, List<B>> unzip(List<Tuple2<A, B>> ts){
		List<A> as = new ArrayList<>(ts.size());
		List<B> bs = new ArrayList<>(ts.size());
		
		Iterator<Tuple2<A, B>> i = ts.iterator();
		
		while (i.hasNext()) {
			Tuple2<A, B> t = (Tuple2<A, B>) i.next();
			as.add(t.first);
			bs.add(t.second);
		}
		return new Tuple2<List<A>, List<B>>(as, bs);
	}
	
	/**
	 * ZipWith is a generalized version of zip. It takes two lists and instead of just combining the
	 * elements to a tuple, it takes an arbitrary function that is used to pairwise combine the
	 * of the two lists.
	 * 
	 * @param f The function to "combine" elements with.
	 * @param as The first list.
	 * @param bs The other list.
	 * @return A list that contains the results of pairwise combining the elements of the given lists
	 * 			with the function, <i>f</i>.
	 */
	public static <A, B, C> List<C> zipWith(Function2<A, B, C> f, List<A> as, List <B> bs){
		int newSize = Math.min(as.size(), bs.size());
		List<C> rs = new ArrayList<>(newSize);
		Iterator<A> ia = as.iterator();
		Iterator<B> ib = bs.iterator();
		
		for(int i = 0; i < newSize; i++){
			rs.add(f.f(ia.next(), ib.next()));
		}
		
		return rs;
	}
}
