package se.xell.util;

import java.io.Serializable;

/**
 * A <i>disjoint set</i> or <i>union-find set</i> is a data structure
 * for representing groupings of "elements". The disjoint set
 * doesn't actually store any data elements - what it does is keeping track
 * of to which group an "element" belongs.
 * <br></br>
 * 
 * Groupings are represented as inverted tree structures (inverted in the sense that all
 * pointers goes towards the root rather than away from it), where the root node acts as
 * a "representative" for the group. A DisjointSet object is simply a tree node in this
 * kind of tree.
 * <br></br>
 * 
 * For more detailed information, please check 
 * <a href="http://en.wikipedia.org/wiki/Disjoint-set_data_structure">the wikipedia article</a>.
 * 
 * @author Tobias Axell
 * @version 1.0
 */
public class DisjointSet implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8192907382119215401L;
	private DisjointSet root;
	private int rank;
	
	/**
	 * Constructor for DisjointSet. Creates a new tree with only one 
	 * node - the root.
	 */
	public DisjointSet(){
		root = this;
		rank = 0;
	}

	/**
	 * Gives the group to which this disjoint set belongs
	 * by returning the disjoint set element that is the
	 * root of the tree that this element is part of.
	 * 
	 * @return A disjoint set representing the group to which 
	 * this elements belong.
	 */
	public DisjointSet find() {
		if(root == this){
			return this;
		} else {
			root = root.find();
			return root;
		}
	}
	
	/**
	 * Unions this set with a given set. If this set and the given
	 * set are already the same this method does nothing.
	 * 
	 * @param set The set to union this disjoint set with.
	 */
	public void union(DisjointSet set){
		DisjointSet x = find();
		DisjointSet y = set.find();
		
		if(x == y){
			return;
		}
		
		if(x.rank < y.rank){
			x.root = y;
		} else if (y.rank < x.rank){
			y.root = x;
		} else {
			y.root = x;
			++x.rank;
		}
	}
}
