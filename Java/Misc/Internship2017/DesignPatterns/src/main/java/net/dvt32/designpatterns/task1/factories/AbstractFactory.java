package net.dvt32.designpatterns.task1.factories;

import net.dvt32.designpatterns.task1.animals.Animal;
import net.dvt32.designpatterns.task1.humans.Human;

/**
 * This interface describes what a factory can do.
 * It can produce animals or humans (or maybe even both).
 * 
 * There is still an implementation in every factory class for BOTH methods, 
 * which allows a concrete factory to produce objects in different ways.
 * 
 * For example, an AnimalFactory could 
 * potentially produce Human objects too, 
 * but not exactly how a HumanFactory would produce them.
 * 
 * Likewise, a HumanFactory could potentially 
 * produce Animal objects too, but in its own way.
 * 
 * @author Dimitar Trifonov (dvt32)
 */
public interface AbstractFactory {
	public Animal getAnimal(String animalType);
	public Human getHuman(String humanType);
}