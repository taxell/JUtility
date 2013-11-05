package nu.xell.util.functional;

import java.util.ArrayList;
import java.util.List;

/**
 * A class with static methods for mapping, functional style.
 * 
 * @author Tobias Axell
 */
public class Mapping {
	
	private Mapping(){}
	
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
