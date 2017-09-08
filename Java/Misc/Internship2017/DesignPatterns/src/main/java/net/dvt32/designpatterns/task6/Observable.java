package net.dvt32.designpatterns.task6;

/**
 * This interface represents what every observable object (also known as "subject") 
 * must be able to do, in order to be considered observable.
 * 
 * Every subject can:
 * - add/register a new observer
 * - remove any observer
 * - notify its observers of any changes.
 * 
 * @author Dimitar Trifonov (dvt32)
 */
public interface Observable {
	public void registerObserver(Observer observer);
	public void removeObserver(Observer observer);
	public void notifyObservers();
}