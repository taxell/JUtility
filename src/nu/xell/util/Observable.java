package nu.xell.util;

/**
 * An observable according to the observer pattern. 
 * 
 * An observable object is an object that observer objects can "observe" 
 * by "subscribing to" the observable. The observable can then
 * notify its observers about state changes, events etc. depending on
 * the concrete implementation of the observable.
 * <br></br>
 * 
 * This observable is pretty much the same as java.util.Observable, the main
 * difference is that this is an interface, while java.util.Observable is
 * a class.
 * 
 * @author Tobias Axell
 * @version 0.1
 */
public interface Observable {
	
	/**
	 * Adds an observer to this observable. The observer will from now
	 * on receive notifications from this observable.
	 * 
	 * @param o The observer to add.
	 */
	public void addObserver(nu.xell.util.Observer o);
	
	/**
	 * Removes an observer from this observable.
	 * 
	 * @param o The observer to remove.
	 */
	public void removeObserver(nu.xell.util.Observer o);
	
	/**
	 * Notifies all observers currently observing this object.
	 * <br></br>
	 * NOTE: This should always be implemented by calling the
	 * 'onNotification()' method for each observer currently observing 
	 * this object.
	 */
	public void notifyObservers();
}
