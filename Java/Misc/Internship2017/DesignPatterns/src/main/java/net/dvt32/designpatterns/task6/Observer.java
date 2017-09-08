package net.dvt32.designpatterns.task6;

/**
 * This interface represents what every observer object
 * must be able to do, in order to be considered an observer.
 * 
 * Basically it should be able to do only one thing:
 * - receive an update (in the form of a String) from the subject it observes.
 * 
 * @author Dimitar Trifonov (dvt32)
 */
public interface Observer {
	public void update(String updateData);
}