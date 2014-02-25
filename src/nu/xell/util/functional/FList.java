package nu.xell.util.functional;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

import nu.xell.util.functional.monad.AbstractMonad;
import nu.xell.util.functional.monad.Monad;

/**
 * A functional style linked list where a list is either empty (nil) or an
 * element followed by a list.
 * 
 * Note: FList is an immutable class and cannot be modified, however the
 * elements of the list can be of any type and those types may be mutable
 * and that can cause problems if elements are changed while they are
 * elements in a list.
 * 
 * @author Tobias Axell
 *
 * @param <E> The type of the elements stored in the list.
 */
@SuppressWarnings("rawtypes")
public class FList<E> extends AbstractMonad<FunctionalList, E> implements FunctionalList<E>, Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4130129922402814000L;
	
	protected final ListType type;
	protected final E head;
	private FList<E> tail;
	
	/**
	 * Constructor for FList.
	 * 
	 * @param elem The head element of the list.
	 * @param tail The tail of the list.
	 * @param constructionType Either NIL or CONS if this is an empty or constructed
	 * list.
	 */
	protected FList(E elem, FList<E> tail, ListType constructionType) {
		this.type = constructionType;
		if(constructionType == ListType.CONS){
			this.head = elem;
			this.tail = tail;
		} else {
			this.head = null;
			this.tail = null;
		}
	}

	@Override
	public Iterator<E> iterator() {
		return new FListIterator<>(this);
	}
	
	/////////////////////////////////////////////////////////////////////////////////////
	// CONSTRUCTOR FUNCTIONS
	
	/**
	 * Gives a nil list.
	 * 
	 * @return Nil.
	 */
	public static <T> FList<T> nil(){
		return new FList<>(null, null, ListType.NIL);
	}
	
	/**
	 * Constructs a new list <b>(t:ts)</b> from an element <b>t</b> and a list
	 * <b>ts</b>.
	 * 
	 * @param t An element to be the head of the new list.
	 * @param ts A list to be the tail of the new list.
	 * @return A new list <b>(t:ts)</b>.
	 */
	public static <T> FList<T> cons(T t, FList<T> ts){
		if(t == null || ts == null){
			throw new NullPointerException();
		}
		return constr(t, ts);
	}
	
	/*
	 * Same as cons, but allows null. ONLY to use internally
	 * or internally in subclasses.
	 */
	protected static <T> FList<T> constr(T t, FList<T> ts){
		return new FList<>(t, ts, ListType.CONS);
	}
	
	/**
	 * Constructs an FList from a java.util.List with
	 * the same elements in the same order. 
	 * 
	 * @param l The list to construct the new FList from.
	 * @return A new FList with the same elements as <i>l</i>
	 * 			in the same order as in <i>l</i>
	 */
	public static <T> FList<T> fromList(List<T> l){
		if(l.isEmpty()){
			return nil();
		} else {
			Iterator<T> i = l.iterator();
			T elem = i.next();
			
			if(elem == null){
				throw new NullPointerException("FList does not allow null elements");
			}
			
			FList<T> newList = constr(elem, null);
			FList<T> ptr = newList;
			
			while(i.hasNext()){
				elem = i.next();
				
				if(elem == null){
					throw new NullPointerException("FList does not allow null elements");
				}
				
				ptr.tail = constr(elem, null);
				ptr = ptr.tail;
			}
			ptr.tail = nil();
			
			return newList;
		}
	}
	
	/////////////////////////////////////////////////////////////////////////////////////
	// LIST FUNCTIONS
	
	@Override
	public Tuple2<E, FunctionalList<E>> split(){
		if(isNil()){
			throw new NilListException();
		}
		return new Tuple2<>(head, (FunctionalList<E>)tail);
	}
	
	@Override
	public E head(){
		if(isNil()){
			throw new NilListException();
		}
		return head;
	}
	
	@Override
	public FunctionalList<E> tail(){
		if(isNil()){
			throw new NilListException();
		}
		return tail;
	}
	
	@Override
	public boolean isNil(){
		return type == ListType.NIL;
	}
	
	@Override
	public int length(){
		if(isNil()){
			return 0;
		} else {
			FList<?> ptr = this;
			int counter = 1;
			
			while(ptr.type != ListType.NIL){
				counter++;
				ptr = ptr.tail;
			}
			return counter;
		}
	}
	
	@Override
	public FList<E> take(int i){
		if(isNil() || i <= 0){
			return nil();
		} else {
			
			FList<E> head = new FList<E>(this.head, null, ListType.CONS);
			FList<E> ptrOld = this;
			FList<E> ptrNew = head;
			int c = 0;
			
			while(!ptrOld.tail.isNil() && c < i){
				ptrOld = ptrOld.tail;
				ptrNew.tail = new FList<E>(ptrOld.head, null, ListType.CONS);
				ptrNew = ptrNew.tail;
				c++;
			}
			ptrNew.tail = nil();
			
			return head;
		}
	}
	
	@Override
	public FList<E> drop(int i){
		FList<E> ptr = this;

		try{
			for(int c = 0; c < i; c++){
				ptr = ptr.tail;
			}
		}catch(NullPointerException e){
			return nil();
		}
		return ptr;
	}
	
	/**
	 * Copies a list. Note: this is a shallow copy,
	 * the elements in <b>ts</b> are not copied
	 * 
	 * @return A shallow copy of <b>ts</b>.
	 */
	public FList<E> copy(){
		if(isNil()){
			return nil();
		} else {
			
			FList<E> head = new FList<>(this.head, null, ListType.CONS);
			FList<E> ptrOld = this;
			FList<E> ptrNew = head;
			
			while(!ptrOld.tail.isNil()){
				ptrOld = ptrOld.tail;
				ptrNew.tail = new FList<E>(ptrOld.head, null, ListType.CONS);
				ptrNew = ptrNew.tail;
			}
			ptrNew.tail = nil();
			return head;
		}
	}
	
	@Override
	public E get(int i) {
		if(i < 0){
			throw new IndexOutOfBoundsException("Negative index");
		}
		try{
			return drop(i).head();
		} catch (NilListException e){
			throw new IndexOutOfBoundsException("Index too high");
		}
	}

	@Override
	public FunctionalList<E> concat(FunctionalList<E> l) {
		if(isNil()){
			return l;
		} else if (l.isNil()){
			return this;
		} else if (l instanceof FList<?>){
			return concat((FList<E>)l);
		}
		
		FList<E> newList = copy();
		FList<E> ptr = newList;
		
		while(!ptr.tail.isNil()){
			ptr = ptr.tail;
		}
		
		Iterator<E> i = l.iterator();
		while(i.hasNext()){
			ptr.tail = new FList<E>(i.next(), null, ListType.CONS);
			ptr = ptr.tail;
		}
		ptr.tail = nil();
		
		return newList;
	}
	
	/**
	 * Concatenates two lists <b>l1</b> and <b>l2</b>.
	 * 
	 * @param l2 The second part of the new list.
	 * @return A list that is a concatenation: <b>l1</b> + <b>l2</b>.
	 */
	public FList<E> concat(FList<E> l2){
		if(isNil()){
			return l2;
		} else if (l2.isNil()){
			return this;
		} else {
			FList<E> ll1 = copy();
			FList<E> c = ll1;
			
			while(!c.tail.isNil()){
				c = c.tail;
			}
			
			c.tail = l2;			
			return ll1;
		}
	}
	
	/////////////////////////////////////////////////////////////////////////////////////
	// HIGHER ORDER LIST FUNCTIONS
	
	@Override
	public <D> FunctionalList<D> map(Function1<E, D> f) {
		if(isNil()){
			return nil();
		}
		
		FList<D> newList = constr(f.f(head), null);
		FList<E> oldPtr = tail;
		FList<D> newPtr = newList;
		
		while(!oldPtr.isNil()){
			newPtr.tail = constr(f.f(oldPtr.head), null);
			oldPtr = oldPtr.tail;
			newPtr = newPtr.tail;
		}
		newPtr.tail = nil();
		
		return newList;
	}

	@Override
	public <D> D foldr(Function2<E, D, D> f, D d) {
		//TODO Optimize with iterative algorithm.
		if(isNil()){
			return d;
		} else {
			return f.f(head, tail.foldr(f, d));
		}
	}

	@Override
	public E foldr1(Function2<E, E, E> f) {
		//TODO Optimize with iterative algorithm.
		if(isNil()){
			throw new NilListException();
		} else if(tail.isNil()){
			return head;
		} else {
			return f.f(head, tail.foldr1(f));
		}
	}

	@Override
	public <D> D foldl(Function2<D, E, D> f, D a) {
		if(isNil()){
			return a;
		} else {
			D acc = a;
			Iterator<E> i = iterator();
			
			while (i.hasNext()) {
				acc = f.f(acc, i.next());
			}
			return acc;
		}
	}

	@Override
	public E foldl1(Function2<E, E, E> f) {
		if(isNil()){
			throw new NilListException();
		}
		
		Iterator<E> i = iterator();
		E elem = i.next();
		
		while (i.hasNext()) {
			elem = f.f(elem, i.next());
		}
		
		return elem;
	}
	
	/////////////////////////////////////////////////////////////////////////////////////
	// Monad methods
	
	@SuppressWarnings({ "unchecked" })
	@Override
	public <B, N extends Monad<FunctionalList, B>> N bind(Function1<E, N> f) {
		return (N) Lists.concat2((FunctionalList<FunctionalList<E>>) map(f));
	}

	@SuppressWarnings({ "unchecked" })
	@Override
	public <B, N extends Monad<FunctionalList, B>> N unit(B value) {
		FList<B> n = nil();
		return (N) cons(value, n);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public <B, N extends Monad<FunctionalList, B>> N fail(String msg) {
		return (N) nil();
	}
	
	// The static unitS and failS
	
	@SuppressWarnings({ "unchecked" })
	public static <B, N extends Monad<FunctionalList, B>> N unitS(B value) {
		FList<B> n = nil();
		return (N) cons(value, n);
	}
	
	@SuppressWarnings("unchecked")
	public static <B, N extends Monad<FunctionalList, B>> N failS(String msg) {
		return (N) nil();
	}
	
	/////////////////////////////////////////////////////////////////////////////////////
	// Functor methods
	
	@Override
	public <D> Functor<D> fMap(Function1<E, D> f) {
		return map(f);
	}

	//////////////////////////////////////////////////////////////////////////////////////
	// Monoid methods
	
	@Override
	public FunctionalList<E> mAppend(FunctionalList<E> m) {
		return concat((FunctionalList<E>)m);
	}

	@Override
	public FunctionalList<E> mConcat(FunctionalList<FunctionalList<E>> l) {
		FunctionalList<E> res = this;
		Iterator<FunctionalList<E>> i = l.iterator();
		
		while(i.hasNext()){
			res = res.mAppend(i.next());
		}
		return res;
	}

	@Override
	public FunctionalList<E> mEmpty() {
		return nil();
	}
	
	/////////////////////////////////////////////////////////////////////////////////////
	
	/**
	 * A marker for if a list is nil or a "constructed", non-nil, list.
	 * 
	 * @author Tobias Axell
	 */
	protected static enum ListType{
		NIL, CONS;
	}
	
	/**
	 * Iterator for FList.
	 * 
	 * @author Tobias Axell
	 *
	 * @param <T>
	 */
	protected static class FListIterator<T> implements Iterator<T>{
		
		protected FList<T> ptr;
		
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
