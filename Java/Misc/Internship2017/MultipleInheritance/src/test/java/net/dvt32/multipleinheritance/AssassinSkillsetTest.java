package net.dvt32.multipleinheritance;

import static org.junit.Assert.*;

import org.junit.Test;

public class AssassinSkillsetTest {

	@Test
	public void warriorShouldCommitSuicideWithAssassinationAttempts() {
		Warrior warrior = new Warrior(100, 5, 5);	
		while ( !warrior.isDead() ) {
			warrior.tryToAssassinate(warrior);
		}
		assertTrue( warrior.isDead() );
	}
	
	@Test
	public void assassinationAttemptsOfRogueWithNoDamageShouldStillKillTarget() {
		Rogue rogue = new Rogue(100, -1, -1);
		Mage mage = new Mage(100, 20, 20);
		while ( !mage.isDead() ) {
			rogue.tryToAssassinate(mage);
		}
		assertTrue( mage.isDead() );
	}
	
	@Test
	public void onlyWarriorOrOnlyRogueShouldBeAliveAfterAssassinationAttempts() {
		Warrior warrior = new Warrior(100, 5, 5);
		Rogue rogue = new Rogue(100, 5, 5);
		
		while ( !warrior.isDead() && !rogue.isDead() ) {
			warrior.tryToAssassinate(rogue);
			rogue.tryToAssassinate(warrior);
		}
		
		assertTrue( warrior.isDead() ^ rogue.isDead() );
	}

}