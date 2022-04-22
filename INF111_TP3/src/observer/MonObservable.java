package observer;

/**
 * Classe abstraite du patron Observable
 * @author Fred Simard | ETS
 * @version ETE 2018 - TP2
 */

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.locks.ReentrantLock;

public abstract class MonObservable {
	
	static ReentrantLock lock = new ReentrantLock();
	
	// liste des observers
	ArrayList<MonObserver> observers = new ArrayList<MonObserver>();
	
	/**
	 * méthode pour attacher un Observer
	 * @param observer
	 */
	public void attacherObserver(MonObserver observer){
		observers.add(observer);
	}
	
	/**
	 * méthode pour avertir tous les observers
	 */
	public void avertirLesObservers(){
		for (int i = 0; i < observers.size(); i++) {
			observers.get(i).avertir();
		}
	}
		
}
