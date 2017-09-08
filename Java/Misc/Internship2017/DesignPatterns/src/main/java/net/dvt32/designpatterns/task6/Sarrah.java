package net.dvt32.designpatterns.task6;

/**
 * This class represents a stock data OBSERVER.
 * 
 * This class is expected to observe a SoldOutStocks object,
 * which will send it information about available and soldout stocks.
 * 
 * @author Dimitar Trifonov (dvt32)
 */
public class Sarrah
	implements Observer
{
	Observable stockData;

	/**
	 * This constructor registers the object as an observer.
	 * 
	 * @param stockData The subject
	 */
	public Sarrah(Observable stockData) {
		this.stockData = stockData;
		stockData.registerObserver(this);
	}
	
	/**
	 * This method receives the information from the subject
	 * and prints it, along with a message that confirms 
	 * that the info was received by this observer.
	 * 
	 * @param updateData The information received from the subject
	 */
	@Override
	public void update(String updateData) {
		System.out.println(
			"Update received by Sarrah!" 
			+ System.getProperty("line.separator") +
			updateData 
			+ System.getProperty("line.separator")
		);
	}
}