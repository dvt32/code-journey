package net.dvt32.designpatterns.task1.animals;

/**
 * This interface describes what an animal can do.
 * 
 * For simplicity's sake, a concrete animal can only speak,
 * but each animal does so differently (dogs go "woof", cats go "meow" etc).
 * 
 * @author Dimitar Trifonov (dvt32)
 */
public interface Animal {
	public void speak();
}