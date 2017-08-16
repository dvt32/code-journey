package net.dvt32.composition.weapons;

import java.util.concurrent.ThreadLocalRandom;

/**
 * This class represents a type of Weapon - a Dagger.
 * A dagger has one attribute – damage. Each time the dagger is used, an 11-sided dice is thrown.  
 * - If the dice is greater than 6, it deals double damage. 
 * - If it is less than 6, it just deals full damage.
 * The Dagger is intended to be used by a Hero.
 * 
 * @author Dimitar Trifonov (dvt32)
 */
public class Dagger
	extends Weapon
{
	/**
	 * Constructor for a Dagger object
	 * 
	 * Because every Weapon has a damage attribute, 
	 * the superclass' constructor is used 
	 * when initializing a Dagger.
	 * 
	 * @param damage The Dagger's damage attribute value
	 */
	public Dagger(int damage) {
		super(damage);
	}
	
	/**
	 * This method calculates the amount of damage dealt by the weapon.
	 * 
	 * Each time the dagger is used, an 11-sided dice is thrown.  
	 * -> If the dice is greater than 6, the dagger deals double damage. 
	 * -> If it is less than 6, it just deals full damage.  
	 * 
	 * The weapon cannot deal negative damage (if that's the case, the returned value is 0).
	 * 
	 * @return The amount of damage dealt by the Dagger
	 */
	@Override
	public int getDamageDealtByWeapon() {
		int randomDiceNumber = ThreadLocalRandom.current().nextInt(1, 12);
		int damageDealtByWeapon = 0;
		
		if (randomDiceNumber > 6) {
			damageDealtByWeapon = this.getDamage() * 2;
		}
		else {
			damageDealtByWeapon = this.getDamage();
		}
		
		if (damageDealtByWeapon < 0) {
			return 0;
		}
		else {
			return damageDealtByWeapon;
		}
	}
}