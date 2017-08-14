package net.dvt32.multipleinheritance;

import static org.junit.Assert.*;

import org.junit.Test;

public class SpellcasterSkillsetTest {

	@Test
	public void rogueShouldCommitSuicideWithFireballs() {
		Rogue rogue = new Rogue(100, 5, 5);
		while ( !rogue.isDead() ) {
			rogue.tryToCastFireballOn(rogue);
		}
		assertTrue( rogue.isDead() );
	}
	
	@Test
	public void rogueShouldKillTargetWithFireballs() {
		Rogue rogue = new Rogue(150, 4, 3);
		Warrior warrior = new Warrior(101, 3, 4);
		while ( !warrior.isDead() ) {
			rogue.tryToCastFireballOn(warrior);
		}
		assertTrue( warrior.isDead() );
	}
	
	@Test
	public void rogueFireballShouldCauseNoDamageToTarget() {
		Rogue rogue = new Rogue(0, 1000, 100);
		Warrior warrior = new Warrior(1, 2, 3);
		for (int i = 0; i < 10000; ++i) {
			rogue.tryToCastFireballOn(warrior);
		}
		assertTrue( warrior.getHealth() == 1 );
	}

}
