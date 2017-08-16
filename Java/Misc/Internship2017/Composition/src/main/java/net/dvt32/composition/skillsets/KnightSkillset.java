package net.dvt32.composition.skillsets;

import java.util.concurrent.ThreadLocalRandom;

import net.dvt32.composition.heroes.Hero;

/**
* This interface provides certain heroes the skillset to 
* "charge" another hero (to deal a special amount of damage to that hero).
* 
* @author Dimitar Trifonov (dvt32)
*/
public interface KnightSkillset {
	/**
	 * This method allows a hero to charge another hero.
	 * 
	 * If the hero is a Warrior, charging deals damage equal to twice the full hero damage + the hero’s strength,  
	 * If the hero is NOT a Warrior, then they deal twice the full hero damage, multiplied by a number between 0 and 1. 
	 * 
	 * Because only a Warrior requires a different implementation, 
	 * this default implementation is used for all other object types that can charge
	 * 
	 * @param target The hero being attacked
	 */
	default void charge(Hero target) {
		Hero attacker = (Hero) this;
		boolean bothHeroesAlive = ( !attacker.isDead() && !target.isDead() );
		
		if (bothHeroesAlive) {
			String attackerClassName = attacker.getClass().getSimpleName();
			String targetClassName = target.getClass().getSimpleName();
			int targetHealthBeforeAttack = target.getHealth();
			int randomNumber = ThreadLocalRandom.current().nextInt(0, 2);
			int damageDealtToTarget = (2 * attacker.getDamage()) * randomNumber;
			if (damageDealtToTarget < 0) { 
				damageDealtToTarget = 0; // in case the attacker had a negative damage value
			}
			
			target.setHealth(targetHealthBeforeAttack - damageDealtToTarget);
			
			System.out.println(
				attackerClassName
				+ " charged (" 
				+ damageDealtToTarget + " dmg) " 
				+ targetClassName 
			);
		}
	}
}