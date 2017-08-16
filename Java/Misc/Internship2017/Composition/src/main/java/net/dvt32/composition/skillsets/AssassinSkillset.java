package net.dvt32.composition.skillsets;

import java.util.concurrent.ThreadLocalRandom;

import net.dvt32.composition.heroes.Hero;

/**
 * This interface provides certain heroes the skillset to 
 * "try to assassinate" another hero (to deal a special amount of damage to that hero).
 * 
 * @author Dimitar Trifonov (dvt32)
 */
public interface AssassinSkillset {
	/**
	 * This method allows a hero to try and assassinate another hero.
	 * 
	 * Each time an assassin tries to assassinate another hero,  
	 * an 11-sided dice is thrown. 
	 * -> If the dice is greater than 9, the target loses 90% of their health.  
	 * -> If the dice is 11, the target dies instantly.  
	 * 
	 * Because every hero with this skillset tries to assassinate in the same manner,
	 * this default implementation is used, instead of providing 
	 * an implementation in each separate class, which uses this interface.
	 * 
	 * @param target The hero being attacked
	 */
	default void tryToAssassinate(Hero target) {
		Hero attacker = (Hero) this;
		String attackerClassName = attacker.getClass().getSimpleName();
		String targetClassName = target.getClass().getSimpleName();
		int randomDiceNumber = ThreadLocalRandom.current().nextInt(1, 12);
		boolean bothHeroesAlive = ( !attacker.isDead() && !target.isDead() );
		
		if (bothHeroesAlive) {
			if (randomDiceNumber > 9) {
				int targetHealthBeforeAttack = target.getHealth();
				int damageDealtToTarget = (int) Math.round( 0.90 * targetHealthBeforeAttack );
				target.setHealth(targetHealthBeforeAttack - damageDealtToTarget);
				System.out.println(
					attackerClassName 
					+ " tried to assassinate (" 
					+ damageDealtToTarget + " dmg) "
					+ targetClassName
				);
			}
			else if (randomDiceNumber == 11) {
				target.setHealth(0);
				System.out.println( attackerClassName + " assassinated " + targetClassName );
			}
		}
	}
}