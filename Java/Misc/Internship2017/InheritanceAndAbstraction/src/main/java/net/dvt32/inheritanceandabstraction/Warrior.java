package net.dvt32.inheritanceandabstraction;

import java.util.concurrent.ThreadLocalRandom;

/**
 * This class is a child class of Hero. It inherits all of Hero's methods and properties.
 * 
 * The Warrior class distinguishes itself with a 'strength' attribute,
 * which is used to determine how powerful each Warrior's attack will be.
 * 
 * @author Dimitar Trifonov (dvt32)
 */
public class Warrior
	extends Hero
{
	/**
	 * Constructor for every Warrior object. 
	 * 
	 * It calls the inherited Hero constructor to 
	 * set the values of the Warrior's 'health' and 'damage' attributes.
	 * 
	 * Its third parameter sets the value of the Warrior's unique property 'strength'.
	 * 
	 * @param health The Warrior's health points
	 * @param damage The Warrior's damage points
	 * @param strength The Warrior's strength points (special power)
	 */
	public Warrior(int health, int damage, int strength) {
		super(health, damage, strength);
	}

	/**
	 * This method overrides the Hero 
	 * getDamageDealtByAttacker() method 
	 * with a concrete implementation.
	 * 
	 * The damage a Warrior deals is equal to:
	 * -> his damage attribute + his strength attribute divided by 2;
	 * -> all of this is multiplied by a random number between 0 and 1
	 * 
	 * In case the Mage's attributes have a negative value, the attack will not deal any damage.
	 * 
	 * @return The number of damage points a Warrior will deal to another hero
	 */
	@Override
	public int getDamageDealtByAttacker() {
		int randomNumber = ThreadLocalRandom.current().nextInt(0, 2);
		int attackerDamage = this.getDamage();
		int attackerStrength = this.getSpecialPower();	
		int damageDealtByAttacker = ( (attackerDamage + attackerStrength) / 2  * randomNumber );

		if (damageDealtByAttacker < 0) {
			return 0;
		}
		else {
			return damageDealtByAttacker;
		}
	}
}