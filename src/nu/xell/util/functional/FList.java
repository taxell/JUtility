package nu.xell.util.functional;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * 
 * @author Tobias Axell
 *
 * @param <E>
 */
public class FList<E> implements Iterable<E>{
	
	private final E head;
	private FList<E> tail;
	
	/**
	 * 
	 * @param elem
	 * @param tail
	 */
	protected FList(E elem, FList<E> tail) {
		this.head = elem;
		this.tail = tail;
	}

	@Override
	public Iterator<E> iterator() {
		return new FListIterator<>(this);
	}
	
	/////////////////////////////////////////////////////////////////////////////////////
	
	/**
	 * 
	 * @return
	 */
	public static <T> FList<T> nil(){
		return null;
	}
	
	/**
	 * 
	 * @param t
	 * @param ts
	 * @return
	 */
	public static <T> FList<T> cons(T t, FList<T> ts){
		return new FList<T>(t, ts);
	}
	
	/**
	 * 
	 * @param ts
	 * @return
	 */
	public static <T> Tuple2<T, FList<T>> split(FList<T> ts){
		return new Tuple2<>(ts.head, ts.tail);
	}
	
	/**
	 * 
	 * @param l
	 * @return
	 */
	public static <T> T head(FList<T> l){
		return l.head;
	}
	
	/**
	 * 
	 * @param l
	 * @return
	 */
	public static <T> FList<T> tail(FList<T> l){
		return l.tail;
	}
	
	/**
	 * 
	 * @param t
	 * @return
	 */
	public static boolean isNil(FList<?> t){
		return t == null;
	}
	
	/**
	 * 
	 * @param l
	 * @return
	 */
	public static int length(FList<?> l){
		if(l == null){
			return 0;
		} else {
			FList<?> ptr = l;
			int counter = 1;
			
			while(ptr.tail != null){
				counter++;
				ptr = ptr.tail;
			}
			return counter;
		}
	}
	
	/**
	 * 
	 * @param l
	 * @param i
	 * @return
	 */
	public static <T> FList<T> take(FList<T> l, int i){
		if(l == null || i <= 0){
			return null;
		} else {
			FList<T> head = new FList<T>(l.head, null);
			FList<T> ptrOld = l;
			FList<T> ptrNew = head;
			int c = 0;
			
			while(ptrOld.tail != null && c < i){
				ptrOld = ptrOld.tail;
				ptrNew.tail = new FList<T>(ptrOld.head, null);
				ptrNew = ptrNew.tail;
				c++;
			}
			return head;
		}
	}
	
	/**
	 * 
	 * @param l
	 * @param i
	 * @return
	 */
	public static <T> FList<T> drop(FList<T> l, int i){
		FList<T> ptr = l;

		try{
			for(int c = 0; c < i; c++){
				ptr = ptr.tail;
			}
		}catch(NullPointerException e){
			return null;
		}
		
		return ptr;
	}
	
	/**
	 * 
	 * @param ts
	 * @return
	 */
	public static <T> FList<T> copy(FList<T> ts){
		if(ts == null){
			return null;
		} else {
			FList<T> head = new FList<T>(ts.head, null);
			FList<T> ptrOld = ts;
			FList<T> ptrNew = head;
			
			while(ptrOld.tail != null){
				ptrOld = ptrOld.tail;
				ptrNew.tail = new FList<T>(ptrOld.head, null);
				ptrNew = ptrNew.tail;
			}
			return head;
		}
	}
	
	/**
	 * 
	 * @param l1
	 * @param l2
	 * @return
	 */
	public static <T> FList<T> append(FList<T> l1, FList<T> l2){
		if(l1 == null){
			return l2;
		} else if (l2 == null){
			return l1;
		} else {
			FList<T> ll1 = copy(l1);
			FList<T> c = ll1;
			while(c.tail != null){
				c = c.tail;
			}
			c.tail = l2;			
			return ll1;
		}
	}
	
	/////////////////////////////////////////////////////////////////////////////////////
	
	/**
	 * 
	 * @author grobbe
	 *
	 * @param <T>
	 */
	protected static class FListIterator<T> implements Iterator<T>{
		
		protected FList<T> ptr;
		
		/**
		 * 
		 * @param ptr
		 */
		public FListIterator(FList<T> ptr){
			this.ptr = ptr;
		}
		
		@Override
		public boolean hasNext() {
			if(ptr == null || ptr.tail == null){
				return false;
			}
			return true;
		}

		@Override
		public T next() {
			if(hasNext()){
				ptr = ptr.tail;
				return ptr.head;
			}
			throw new NoSuchElementException();
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		}
	}
}
