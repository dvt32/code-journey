package net.dvt32.designpatterns.task6;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * This class represents a SUBJECT (an observable object),
 * which provides information about available stocks and their quantities
 * to its observers (SoldOutStocks objects are expected)
 * 
 * The stock information is contained in an internal map. 
 * A LinkedHashMap is used, so that the insertion order of the elements is kept.
 * 
 * @author Dimitar Trifonov (dvt32)
 */
public class AvailableStocks 
	implements Observable 
{
	private List<Observer> observers;
	private StringBuilder dataForObservers;
	private Map<String, Integer> availableStockQuantities;
	
	/**
	 * This constructor initializes the list of observers, 
	 * the update data to be sent and the map, containing the stock info.
	 */
	public AvailableStocks() {
		observers = new ArrayList<Observer>();
		dataForObservers = new StringBuilder();
		availableStockQuantities = new LinkedHashMap<String, Integer>();
	}
	
	/**
	 * This method:
	 * - sets the quantity for a particular stock in the map
	 * - sets the update data to be sent to all observers
	 * - notifies all observers by sending them the update data String
	 * 
	 * The passed quantity MUST NOT be a negative number 
	 * or else an IllegalArgumentException is thrown.
	 * 
	 * In case the passed quantity value is 0,
	 * that means this stock is no longer available
	 * and the update data will contain:
	 * - a special line "Removed: name-of-removed-stock" at the start
	 * - a line containing the String representation of the internal map
	 * 
	 * Otherwise the stock is considered "new" (even if only its quantity has changed)
	 * and the update data will contain:
	 * - a special line "Added: name-of-added-stock" at the start
	 * - a line containing the String representation of the internal map 
	 * 
	 * The special lines are needed, so that the SoldOutStocks observer can know how to handle the data.
	 * 
	 * After the observers have been notified, the subject class' update data is reset,
	 * so that the next update data won't contain the old information.
	 * 
	 * @param stockName The name of the stock whose quantity will be set
	 * @param quantity The new quantity of that stock
	 */
	public void setStockQuantity(String stockName, int quantity) {
		if (quantity < 0) {
			throw new IllegalArgumentException("The quantity cannot be a negative number!");
		}
		
		availableStockQuantities.put(stockName, quantity);
		if (quantity == 0) {
			availableStockQuantities.remove(stockName);
			dataForObservers.append( "Removed: " + stockName + System.getProperty("line.separator") );
		}
		else {
			dataForObservers.append( "Added: " + stockName + System.getProperty("line.separator") );
		}
		dataForObservers.append( availableStockQuantities.toString() );
		notifyObservers();
		dataForObservers.setLength(0);
	}
	
	/*
	 * The following methods implement the Observable interface.
	 * - Registering an observer is done by adding him to the class' observer list.
	 * - Removing an observer is done by removing him from the class' observer list.
	 * - Notifying observers is done by iterating over all observers and sending them the update data (as a String).
	  */
	@Override
	public void registerObserver(Observer observer) {
		observers.add(observer);
	}

	@Override
	public void removeObserver(Observer observer) {
		observers.remove(observer);
	}

	@Override
	public void notifyObservers() {
		for (Observer observer : observers) {
			observer.update( dataForObservers.toString() );
		}
	}
}