package net.dvt32.designpatterns.task6;

import java.util.ArrayList;
import java.util.List;

/**
 * This class represents both a SUBJECT and an OBSERVER for stock information.
 * 
 * This class is expected to observe an AvailableStocks subject
 * and to be observable by other classes, which want available/sold out stock information.
 * 
 * The class stores a list of all sold out stock names, which changes
 * based on the updates received by the AvailableStocks subject.
 * 
 * It has access to the available stocks and their quantities, so that 
 * it can forward that information to all of its own observers.
 * 
 * @author Dimitar Trifonov (dvt32)
 */
public class SoldOutStocks 
	implements Observable, Observer
{
	Observable stockData;
	private List<Observer> observers;
	private StringBuilder dataForObservers;
	private List<String> soldOutStockNames;
	
	/**
	 * This constructor registers the object as an observer
	 * and also initializes its own list of observers 
	 * and of sold out stock names.
	 */
	public SoldOutStocks(Observable stockData) {
		this.stockData = stockData;
		stockData.registerObserver(this);
		
		this.observers = new ArrayList<Observer>();
		this.dataForObservers = new StringBuilder();
		this.soldOutStockNames = new ArrayList<String>();
	}
	
	/**
	 * This method receives information from an AvailableStocks object
	 * and handles it accordingly.
	 * 
	 * If the update data starts with "Removed",
	 * this means there is a new sold out stock name to be added
	 * and that stock name is added to the internal class' sold out stock name list.
	 * 
	 * If the update data starts with "Added",
	 * this means that a new stock has been added or its quantity has changed.
	 * In case that stock was previously considered sold out,
	 * it is removed from the internal class' sold out stock name list. 
	 * 
	 * In both cases, all observers are notified of the current stock info at the end.
	 * 
	 * After the observers have been notified, the subject class' update data is reset,
	 * so that the next update data won't contain the old information.
	 * 
	 * @param updateData The data received by the subject
	 */
	@Override
	public void update(String updateData) {
		int endLineIndex = updateData.indexOf( System.getProperty("line.separator") );
		if (updateData.startsWith("Removed")) {
			int updateDataFlagEndIndex = updateData.indexOf("Removed: ") + "Removed: ".length() - 1;
			String stockName = updateData.substring(updateDataFlagEndIndex+1, endLineIndex);
			this.soldOutStockNames.add(stockName);
		}
		else if (updateData.startsWith("Added")){
			int updateDataFlagEndIndex = updateData.indexOf("Added: ") + "Added: ".length() - 1;
			String stockName = updateData.substring(updateDataFlagEndIndex+1, endLineIndex);
			if (this.soldOutStockNames.contains(stockName)){
				this.soldOutStockNames.remove(stockName);
			}
		}
		
		String availableStockQuantities = updateData.substring( endLineIndex + System.getProperty("line.separator").length() );
		dataForObservers.append(
			"- Available stocks (name = quantity): " + availableStockQuantities 
			+ System.getProperty("line.separator") +
			"- Soldout stock names: " + soldOutStockNames 
		);
		
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