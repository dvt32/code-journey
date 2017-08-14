package net.dvt32.multipleinheritance;

import static org.junit.Assert.*;

import org.junit.Test;

public class WarriorTest {

	/*
	 * Constructor tests
	 */
	@Test
	public void shouldCreateDeadWarrior() {
		Hero warrior = new Warrior(0, 0, 0);
		assertTrue( warrior.isDead() );
	}
	
	@Test
	public void shouldCreateWarriorWithoutReferencingAbstractClass() {
		Warrior warrior = new Warrior(100, 10, 5);
		int warriorHealth = warrior.getHealth();
		int warriorDamage = warrior.getDamage();
		int warriorStrength = warrior.getSpecialPower();
		
		assertTrue(
			warriorHealth == 100 &&
			warriorDamage == 10 &&
			warriorStrength == 5
		);
	}
	
	/*
	 * Getter/setter tests
	 */
	@Test
	public void healthGetterMethodShouldReturn15() {
		Hero warrior = new Warrior(100, 10, 5);
		warrior.setHealth(15);
		assertTrue( warrior.getHealth() == 15 );
	}
	
	@Test
	public void healthSetterMethodShouldDoubleCurrentHealth() {
		Hero warrior = new Warrior(100, 1, 2);
		warrior.setHealth( warrior.getHealth() * 2 );
		assertTrue( warrior.getHealth() == 200 );
	}
	
	@Test
	public void shouldSetWarriorStrengthTo100() {
		Hero warrior = new Warrior(100, 1, 2);
		warrior.setSpecialPower(100);
		assertTrue( warrior.getSpecialPower() == 100 );
	}
	
	/*
	 * dealDamage() tests
	 */
	@Test
	public void warriorShouldCommitSuicide() {
		Hero warrior = new Warrior(100, 10, 5);
		while ( !warrior.isDead() ) {
			warrior.dealDamage(warrior);
		}
		assertTrue( warrior.isDead() );
	}
	
	@Test
	public void warriorShouldKillMageOrRogue() {
		Hero warrior = new Warrior(100, 10, 5);
		Hero mage = new Mage(100, 5, 4);
		Hero rogue = new Rogue(500, 20, 3);
		
		while ( !mage.isDead() || !rogue.isDead() ) {
			warrior.dealDamage(mage);
			warrior.dealDamage(rogue);
		}
		
		assertTrue( mage.isDead() || rogue.isDead() );
	}
	
	@Test
	public void warriorShouldNotInflictAnyDamage() {
		Hero warrior = new Warrior(-1, 10000, 100);
		Hero mage = new Mage(100, 0, 0);
		
		for (int i = 0; i < 100; ++i) {
			warrior.dealDamage(mage);
		}
		
		assertTrue( mage.getHealth() == 100 );
	}
	
	/*
	 * getDamageDealtByAttacker() tests
	 */
	@Test
	public void shouldReturnSevenOrZero() {
		Hero warrior = new Warrior(100, 10, 5);
		int result = warrior.getDamageDealtByAttacker();
		assertTrue( result == 7 || result == 0 );
	}
	
	@Test
	public void shouldAlwaysReturnZero() {
		Hero warrior = new Warrior(100, 0, 0);
		for (int i = 0; i < 1000; ++i) {
			int result = warrior.getDamageDealtByAttacker();
			assertTrue( result == 0 );
		}
	}
	
	/*
	 * charge() tests
	 */
	@Test
	public void warriorShouldKillItselfWithCharge() {
		Warrior warrior = new Warrior(100, 1, 1);
		while ( !warrior.isDead() ) {
			warrior.charge(warrior);
		}
		assertTrue( warrior.isDead() );
	}
	
	@Test
	public void chargeShouldNotDoAnyDamage() {
		Warrior warrior = new Warrior(100, 0, 0);
		Mage mage = new Mage(100, 1, 1);
		
		for (int i = 0; i < 10000; ++i) {
			warrior.charge(mage);
		}
		
		assertTrue( mage.getHealth() == 100 );
	}
	
	@Test(timeout=3000)
	public void chargeShouldKillOtherHeroes() {
		Warrior warrior = new Warrior(100, 100, 100);
		Mage mage = new Mage(100, 0, 0);
		Rogue rogue = new Rogue(100, 0, 0);
		
		while ( !mage.isDead() || !rogue.isDead() ) {
			warrior.charge(mage);
			warrior.charge(rogue);
		}
		
		assertTrue( mage.isDead() && rogue.isDead() );
	}
}