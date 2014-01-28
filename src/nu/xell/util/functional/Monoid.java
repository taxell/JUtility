package nu.xell.util.functional;

/**
 * A monoid is a type <i>T</i> that has an identity value <i>I</i> and an append operation;
 * <i>*</i> : <i>T</i> -> <i>T</i> -> <i>T</i> such that: <br></br>
 * 
 * <ul>
 * 	<li>The operation * is associative.</li>
 * 	<li>The operation * is total.</li>
 * 	<li>Applying * to any element <i>D</i> and the identity element <i>I</i> results in <i>D</i>; 
 * 		<i>D * I = I * D = D</i></li>
 * </ul>
 * 
 * <br></br><br></br>
 * 
 * For example integers are monoids with addition as the append operation and the number 0 as
 * the identity value. Lists are also monoids with list concatenation as append operation and
 * the empty list as identity element.
 * 
 * @author Tobias Axell
 */
public interface Monoid {
	
	/**
	 * The append operation. Appends a the given object to this object.
	 * 
	 * @param m The object to append to this object.
	 * @return The result of appending <b>m</b> to this object.
	 */
	public Monoid mAppend(Monoid m);
	
	/**
	 * Concatenates all elements in the given list using the mAppend operation and appends
	 * the result to <b>this</b> object.
	 * 
	 * @param l The list of elements to concatenate.
	 * @return this object and all elements of the list <b>l</b> concatenated using mAppend.
	 */
	public Monoid mConcat(FunctionalList<Monoid> l);
	
	/**
	 * Gives the identity element of this monoid type.
	 * 
	 * @return The identity element.
	 */
	public Monoid mEmpty();
}
