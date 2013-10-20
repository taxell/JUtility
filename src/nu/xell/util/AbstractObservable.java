package nu.xell.util;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * An implementation of nu.xell.util.Observable that can be used as a 
 * foundation for observable classes.
 * 
 * @author Tobias Axell
 * @version 0.1
 */
public abstract class AbstractObservable implements nu.xell.util.Observable {
	
	private final List<Observer> observers;
	
	/**
	 * Constructor for AbstractObservable.
	 */
	protected AbstractObservable(){
		observers = new LinkedList<>();
	}

	@Override
	public void addObserver(Observer o) {
		observers.add(o);
	}

	@Override
	public void removeObserver(Observer o) {
		Iterator<Observer> iter = observers.iterator();
		
		while (iter.hasNext()) {
			if(iter.next() == o){
				iter.remove();
			}
		}
	}

	@Override
	public void notifyObservers() {
		for(Observer o : observers){
			o.onNotification();
		}
	}
}
