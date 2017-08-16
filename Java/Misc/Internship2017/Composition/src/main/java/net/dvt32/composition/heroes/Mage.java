package net.dvt32.composition.heroes;

import java.util.concurrent.ThreadLocalRandom;

import net.dvt32.composition.skillsets.KnightSkillset;
import net.dvt32.composition.skillsets.SpellcasterSkillset;
import net.dvt32.composition.weapons.Weapon;

/**
 * This class is a child class of Hero. It inherits all of Hero's methods and properties.
 * 
 * The Mage class distinguishes itself with an 'intelligence' attribute,
 * which is used to determine how powerful each Mage's attack will be.
 * 
 * The class uses the default implementation for the KnightSkillset interface.
 * 
 * @author Dimitar Trifonov (dvt32)
 */
public class Mage
	extends Hero
	implements SpellcasterSkillset, KnightSkillset
{
	/**
	 * Constructor for every Mage object. 
	 * 
	 * It calls the inherited Hero constructor to 
	 * set the values of the Mage's 'health' and 'damage' attributes.
	 * 
	 * Its third parameter sets the value of the Mage's unique property 'intelligence'.
	 * 
	 * @param health The Mage's health points
	 * @param damage The Mage's damage points
	 * @param intelligence The Mage's intelligence points (special power)
	 */
	public Mage(int health, int damage, int intelligence) {
		super(health, damage, intelligence);
	}
	
	/**
	 * Additional constructor, which allows the hero to have a weapon.
	 * 
	 * @param health The Mage's health points
	 * @param damage The Mage's damage points
	 * @param strength The Mage's intelligence points (special power)
	 * @param weapon The Mage's weapon type
	 */
	public Mage(int health, int damage, int intelligence, Weapon weapon) {
		super(health, damage, intelligence, weapon);
	}

	/**
	 * This method overrides the Hero 
	 * getDamageDealtByAttacker() method 
	 * with a concrete implementation.
	 * 
	 * The damage a Mage deals is equal to :
	 * -> his damage attribute + his intelligence attribute divided by 3;
	 * -> all of this is multiplied by a random number between 0 and 1.5
	 * 
	 * In case the Mage's attributes have a negative value, the attack will not deal any damage.
	 * 
	 * @return The number of damage points a Mage will deal to another hero.
	 */
	@Override
	public int getDamageDealtByAttacker() {
		double randomNumber = ThreadLocalRandom.current().nextDouble(0, 1.51);
		int attackerDamage = this.getDamage();
		int attackerIntelligence = this.getSpecialPower();
		int damageDealtByAttacker = (int) ( (attackerDamage + attackerIntelligence) / 3  * randomNumber );
		
		if (damageDealtByAttacker < 0) {
			return 0;
		}
		else {
			return damageDealtByAttacker;
		}
	}

	/**
	 * This method allows a Mage to deal a special amount of damage to another hero.
	 * 
	 * Fireballs deal damage equal to:
	 * -> the Mage's damage attribute value + his intelligence attribute value
	 * 
	 * This method overrides the default interface implementation, 
	 * because a Mage casts a fireball in a different way from other heroes.
	 * 
	 * @param target The hero being attacked
	 */
	@Override
	public void tryToCastFireballOn(Hero target) {
		boolean bothHeroesAlive = ( !this.isDead() && !target.isDead() );
		if (bothHeroesAlive) {
			String targetClassName = target.getClass().getSimpleName();
			int targetHealthBeforeAttack = target.getHealth();
			int damageDealtToTarget = this.getDamage() + this.getSpecialPower();
			target.setHealth(targetHealthBeforeAttack - damageDealtToTarget);
			System.out.println( "Mage cast a fireball (" + damageDealtToTarget + " dmg) on " + targetClassName );
		}
	}
}