package se.xell.util;

/**
 * An observer according the observer design pattern. 
 * (See nu.xell.util.Observable)
 * 
 * @author Tobias Axell
 * @version 0.1
 */
public interface Observer {
	
	/**
	 *   This method is the method that is called when this observer is
	 *   notified by any of the objects it's observing.
	 */
	public void onNotification();
}
