package nu.xell.util.functional;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Tobias Axell
 *
 */
public class Mapping {
	
	/**
	 * 
	 * @param fun
	 * @param list
	 * @return
	 */
	public static <V, K> List<V> map(Function1<K, V> fun, List<K> list){
		ArrayList<V> newList = new ArrayList<>(list.size());
		for(int i = 0; i < list.size(); i++){
			newList.add(fun.f(list.get(i)));
		}
		return newList;
	}
	
	/**
	 * 
	 * @param fun
	 * @param list
	 * @return
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
	 * 
	 * @param fun
	 * @param list
	 * @param threads
	 * @return
	 */
	public static <V, K> List<V> pmap(Function1<K, V> fun, List<K> list, int threads){
		@SuppressWarnings("unchecked")
		V[] newList = (V[])(new Object[list.size()]);
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
	
	/**
	 * 
	 * @author Tobias Axell
	 *
	 * @param <K>
	 * @param <V>
	 */
	protected static class MapWorker<K, V> implements Runnable{
		
		protected final Function1<K, V> mappingStrategy;
		protected final int index;
		protected final V[] results;
		protected final K key;
		
		/**
		 * 
		 * @param mappingStrategy
		 * @param key
		 * @param i
		 * @param res
		 */
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
	
	/**
	 * 
	 * @author Tobias Axell
	 *
	 * @param <K>
	 * @param <V>
	 */
	protected static class MapWorker2<K, V> implements Runnable{
		protected final Function1<K, V> mappingStrategy;
		protected final int 	fromI;
		protected final int 	toI;
		protected final List<K> keys;
		protected final V[] 	results;
		
		/**
		 * 
		 * @param ms
		 * @param keys
		 * @param res
		 * @param from
		 * @param to
		 */
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
