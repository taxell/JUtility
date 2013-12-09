package nu.xell.util.functional;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 
 * @author Tobias Axell
 */
public class Tuples {

	private Tuples() {}
	
	/**
	 * 
	 * @param t
	 * @return
	 */
	public static <A> A fst(Tuple2<A, ?> t){
		return t.first;
	}
	
	/**
	 * 
	 * @param t
	 * @return
	 */
	public static <A> A fst(Tuple3<A, ?, ?> t){
		return t.first;
	}
	
	/**
	 * 
	 * @param t
	 * @return
	 */
	public static <A> A fst(Tuple4<A, ?, ?, ?> t){
		return t.first;
	}
	
	/**
	 * 
	 * @param t
	 * @return
	 */
	public static <A> A fst(Tuple5<A, ?, ?, ?, ?> t){
		return t.first;
	}
	
	/**
	 * 
	 * @param t
	 * @return
	 */
	public static <A> A fst(Tuple6<A, ?, ?, ?, ?, ?> t){
		return t.first;
	}
	
	/**
	 * 
	 * @param t
	 * @return
	 */
	public static <A> A fst(Tuple7<A, ?, ?, ?, ?, ?, ?> t){
		return t.first;
	}
	
	/**
	 * 
	 * @param t
	 * @return
	 */
	public static <A> A fst(Tuple8<A, ?, ?, ?, ?, ?, ?, ?> t){
		return t.first;
	}
	
	/**
	 * 
	 * @param t
	 * @return
	 */
	public static <A> A fst(Tuple9<A, ?, ?, ?, ?, ?, ?, ?, ?> t){
		return t.first;
	}
	
	/**
	 * 
	 * @param t
	 * @return
	 */
	public static <B> B snd(Tuple2<?, B> t){
		return t.second;
	}
	
	/**
	 * 
	 * @param t
	 * @return
	 */
	public static <B> B snd(Tuple3<?, B, ?> t){
		return t.second;
	}
	
	/**
	 * 
	 * @param t
	 * @return
	 */
	public static <B> B snd(Tuple4<?, B, ?, ?> t){
		return t.second;
	}
	
	/**
	 * 
	 * @param t
	 * @return
	 */
	public static <B> B snd(Tuple5<?, B, ?, ?, ?> t){
		return t.second;
	}
	
	/**
	 * 
	 * @param t
	 * @return
	 */
	public static <B> B snd(Tuple6<?, B, ?, ?, ?, ?> t){
		return t.second;
	}
	
	/**
	 * 
	 * @param t
	 * @return
	 */
	public static <B> B snd(Tuple7<?, B, ?, ?, ? ,?, ?> t){
		return t.second;
	}
	
	/**
	 * 
	 * @param t
	 * @return
	 */
	public static <B> B snd(Tuple8<?, B, ?, ?, ?, ?, ?, ?> t){
		return t.second;
	}
	
	/**
	 * 
	 * @param t
	 * @return
	 */
	public static <B> B snd(Tuple9<?, B, ?, ?, ?, ?, ?, ?, ?> t){
		return t.second;
	}
	
	/**
	 * 
	 * @param t
	 * @return
	 */
	public static <A, B> Tuple2<B, A> swap(Tuple2<A, B> t){
		return new Tuple2<B, A>(t.second, t.first);
	}
	
	/**
	 * 
	 * @param as
	 * @param bs
	 * @return
	 */
	public static <A, B> List<Tuple2<A, B>> zip(List<A> as, List<B> bs){
		return zipWith(new Function2<A, B, Tuple2<A, B>>() {
			@Override
			public Tuple2<A, B> f(A a, B b) {
				return new Tuple2<>(a,b);
			}
		}, as, bs);
	}
	
	/**
	 * 
	 * @param ts
	 * @return
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
	 * 
	 * @param f
	 * @param as
	 * @param bs
	 * @return
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
