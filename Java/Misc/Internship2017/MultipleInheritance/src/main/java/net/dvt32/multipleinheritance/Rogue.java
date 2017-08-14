package net.dvt32.multipleinheritance;

import java.util.concurrent.ThreadLocalRandom;

/**
 * This class is a child class of Hero. It inherits all of Hero's methods and properties.
 * 
 * The Rogue class distinguishes itself with an 'agility' attribute,
 * which is used to determine how powerful each Rogue's attack will be.
 * 
 * The class uses the default method implementations provided in the used interfaces.
 * 
 * @author Dimitar Trifonov (dvt32)
 */
public class Rogue 
	extends Hero 
	implements AssassinSkillset, SpellcasterSkillset
{
	/**
	 * Constructor for every Rogue object. 
	 * 
	 * It calls the inherited Hero constructor to 
	 * set the values of the Rogue's 'health' and 'damage' attributes.
	 * 
	 * Its third parameter sets the value of the Rogue's unique property 'agility'.
	 * 
	 * @param health The Rogue's health points
	 * @param damage The Rogue's damage points
	 * @param agility The Rogue's agility points (special power)
	 */
	public Rogue(int health, int damage, int agility) {
		super(health, damage, agility);
	}

	/**
	 * This method overrides the Hero 
	 * getDamageDealtByAttacker() method 
	 * with a concrete implementation.
	 * 
	 * The damage a Rogue deals is equal to:
	 * -> his damage attribute + his strength attribute divided by 4;
	 * -> all of this is multiplied by a random number between 0 and 2
	 * 
	 * In case the Rogue's attributes have a negative value, the attack will not deal any damage.
	 * 
	 * @return The number of damage points a Rogue will deal to another hero
	 */
	@Override
	public int getDamageDealtByAttacker() {
		int randomNumber = ThreadLocalRandom.current().nextInt(0, 3);
		int attackerDamage = this.getDamage();
		int attackerAgility = this.getSpecialPower();	
		int damageDealtByAttacker = ((attackerDamage + attackerAgility) / 4)  * randomNumber;

		if (damageDealtByAttacker < 0) {
			return 0;
		}
		else {
			return damageDealtByAttacker;
		}
	}
}