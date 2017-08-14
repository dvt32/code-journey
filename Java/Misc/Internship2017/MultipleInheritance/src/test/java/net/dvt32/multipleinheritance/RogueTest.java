package net.dvt32.multipleinheritance;

import static org.junit.Assert.*;

import org.junit.Test;

public class RogueTest {

	/*
	 * Constructor tests
	 */
	@Test
	public void shouldCreateDeadRogue() {
		Hero rogue = new Rogue(0, 0, 0);
		assertTrue( rogue.isDead() );
	}
	
	@Test
	public void shouldCreateMageWithoutReferencingAbstractClass() {
		Rogue rogue = new Rogue(100, 5, 5);
		int rogueHealth = rogue.getHealth();
		int rogueDamage = rogue.getDamage();
		int rogueAgility = rogue.getSpecialPower();
		
		assertTrue(
			rogueHealth == 100 &&
			rogueDamage == 5 &&
			rogueAgility == 5
		);
	}
	
	/*
	 * Getter/setter tests
	 */
	@Test
	public void shouldGetNegativeDamageAndThenSetItToPositive() {
		Hero rogue = new Rogue(100, -5, -5);
		
		int rogueDamage = rogue.getDamage();
		assertTrue( rogueDamage < 0 );
		
		rogue.setDamage(5);
		rogueDamage = rogue.getDamage();
		assertTrue( rogueDamage > 0 );
	}
	
	@Test
	public void shouldKillRogueWithoutAnyAttacks() {
		Hero rogue = new Rogue(Integer.MAX_VALUE, 0, 0);
		assertFalse( rogue.isDead() );
		
		rogue.setHealth(Integer.MIN_VALUE);
		assertTrue( rogue.isDead() );
	}
	
	/*
	 * dealDamage() tests
	 */
	@Test
	public void rogueShouldCommitSuicide() {
		Hero rogue = new Rogue(100, 10, 5);
		while ( !rogue.isDead() ) {
			rogue.dealDamage(rogue);
		}
		assertTrue( rogue.isDead() );
	}
	
	@Test
	public void rogueShouldKillWarriorButNotMage() {
		Hero rogue = new Rogue(500, 20, 3);
		Hero mage = new Mage(Integer.MAX_VALUE, 10, 5);
		Hero warrior = new Warrior(100, 5, 4);

		while ( !warrior.isDead() ) {
			rogue.dealDamage(warrior);
		}
		
		rogue.dealDamage(mage);
		
		assertTrue( warrior.isDead() && !mage.isDead() );
	}
	
	@Test
	public void rogueShouldNotInflictAnyDamage() {
		Hero rogue = new Rogue(-1, 10000, 100);
		Hero warrior = new Warrior(100, 0, 0);
		
		for (int i = 0; i < 100; ++i) {
			rogue.dealDamage(warrior);
		}
		
		assertTrue( warrior.getHealth() == 100 );
	}
	
	/*
	 * getDamageDealtByAttacker() tests
	 */
	@Test
	public void shouldNeverDealAnyDamage() {
		Hero rogue = new Rogue(100, 0, 0);
		for (int i = 0; i < 1000; ++i) {
			int result = rogue.getDamageDealtByAttacker();
			assertTrue( result == 0 );
		}
		
		Hero anotherRogue = new Rogue(100, -10, -10);
		for (int i = 0; i < 1000; ++i) {
			int result = anotherRogue.getDamageDealtByAttacker();
			assertTrue( result == 0 );
		}
	} 
}
