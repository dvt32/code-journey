package net.dvt32.designpatterns.task1.humans;

/**
 * This interface describes what a human can do.
 * 
 * For simplicity's sake, a concrete human can only say his/her own name,
 * but each human does so differently (men say "I'm a man" and women say "I'm a woman" at the end)
 * 
 * @author Dimitar Trifonov (dvt32)
 */
public interface Human {
	public void sayOwnName();
}