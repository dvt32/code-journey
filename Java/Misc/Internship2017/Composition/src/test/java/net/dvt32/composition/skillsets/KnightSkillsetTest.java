package net.dvt32.composition.skillsets;

import static org.junit.Assert.*;
import net.dvt32.composition.heroes.Mage;
import net.dvt32.composition.heroes.Rogue;
import net.dvt32.composition.heroes.Warrior;

import org.junit.Test;

public class KnightSkillsetTest {

	@Test
	public void warriorShouldCommitSuicideWithCharging() {
		Warrior warrior = new Warrior(100, 5, 5);	
		while ( !warrior.isDead() ) {
			warrior.charge(warrior);
		}
		assertTrue( warrior.isDead() );
	}
	
	@Test(timeout=2000)
	public void warriorShouldKillMageWithCharging() {
		Warrior warrior = new Warrior(100, 5, 5);
		Mage mage = new Mage(100, 5, 5);
		while ( !mage.isDead() ) {
			warrior.charge(mage);
		}
		assertTrue( mage.isDead() );
	}
	
	@Test
	public void mageShouldNotDealAnyDamageWithCharging() {
		Mage mage = new Mage(200, -1, -5);
		Rogue rogue = new Rogue(100, 2, 5);
		
		for (int i = 0; i < 10000; ++i) {
			mage.charge(rogue);
		}
		
		assertTrue( rogue.getHealth() == 100 );
	}

}
