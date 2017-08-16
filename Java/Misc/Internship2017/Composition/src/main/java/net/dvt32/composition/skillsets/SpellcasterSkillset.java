package net.dvt32.composition.skillsets;

import java.util.concurrent.ThreadLocalRandom;

import net.dvt32.composition.heroes.Hero;

/**
 * This interface provides certain heroes the skillset to 
 * "cast a fireball" on another hero (to deal a special amount of damage to that hero).
 * 
 * @author Dimitar Trifonov (dvt32)
 */
public interface SpellcasterSkillset {
	/**
	 * This method allows a hero to try and cast a fireball on another hero
	 * 
	 * If the hero that cast the fireball is a Mage,
	 * fireballs deal damage equal to the Mage's damage value + his intelligence value.
	 * 
	 * If the hero is NOT a Mage, then 
	 * they deal damage equal to the Hero's damage value + his special power value, 
	 * all multiplied by a number between 0 and 1.  
	 * 
	 * Because only a Mage casts a fireball differently,
	 * this default implementation is used for every other object type that has this skillset.
	 * 
	 * @param target The hero being attacked
	 */
	default void tryToCastFireballOn(Hero target) {
		Hero attacker = (Hero) this;
		boolean bothHeroesAlive = ( !attacker.isDead() && !target.isDead() );
		if (bothHeroesAlive) {
			String attackerClassName = attacker.getClass().getSimpleName();
			String targetClassName = target.getClass().getSimpleName();
			int targetHealthBeforeAttack = target.getHealth();
			int randomNumber = ThreadLocalRandom.current().nextInt(0, 2);
			int damageDealtToTarget = (attacker.getDamage() + attacker.getSpecialPower()) * randomNumber;
			if (damageDealtToTarget < 0) {
				damageDealtToTarget = 0;
			}
			target.setHealth(targetHealthBeforeAttack - damageDealtToTarget);
			System.out.println(
				attackerClassName
				+ " cast a fireball (" 
				+ damageDealtToTarget + " dmg) on " 
				+ targetClassName 
			);
		}
	}
}