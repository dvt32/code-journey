package net.dvt32.multipleinheritance;

import static org.junit.Assert.*;

import org.junit.Test;

public class MageTest {

	/*
	 * Constructor tests
	 */
	@Test
	public void shouldCreateDeadMage() {
		Hero mage = new Mage(0, 0, 0);
		assertTrue( mage.isDead() );
	}
	
	@Test
	public void shouldCreateMageWithoutReferencingAbstractClass() {
		Mage mage = new Mage(100, 10, 5);
		int mageHealth = mage.getHealth();
		int mageDamage = mage.getDamage();
		int mageIntelligence = mage.getSpecialPower();
		
		assertTrue(
			mageHealth == 100 &&
			mageDamage == 10 &&
			mageIntelligence == 5
		);
	}
	
	/*
	 * Getter/setter tests
	 */
	@Test
	public void intelligenceGetterMethodShouldReturn1337() {
		Hero mage = new Mage(100, 10, 1337);
		mage.setSpecialPower( mage.getSpecialPower() + 1 - 1 );
		assertTrue( mage.getSpecialPower() == 1337 );
	}
	
	@Test
	public void damageSetterMethodShouldDoubleCurrentDamage() {
		Hero mage = new Mage(1, 100, 2);
		mage.setDamage( mage.getDamage() * 2 );
		assertTrue( mage.getDamage() == 200 );
	}
	
	/*
	 * dealDamage() tests
	 */
	@Test
	public void mageShouldCommitSuicide() {
		Hero mage = new Mage(100, 10, 5);
		while ( !mage.isDead() ) {
			mage.dealDamage(mage);
		}
		assertTrue( mage.isDead() );
	}
	
	@Test
	public void mageShouldKillWarriorAndRogue() {
		Hero mage = new Mage(100, 10, 5);
		Hero warrior = new Warrior(100, 5, 4);
		Hero rogue = new Rogue(500, 20, 3);
		
		while ( !warrior.isDead() || !rogue.isDead() ) {
			mage.dealDamage(warrior);
			mage.dealDamage(rogue);
		}
		
		assertTrue( warrior.isDead() && rogue.isDead() );
	}
	
	@Test
	public void mageShouldNotInflictAnyDamage() {
		Hero mage = new Mage(-1, 10000, 100);
		Hero warrior = new Warrior(100, 0, 0);
		
		for (int i = 0; i < 100; ++i) {
			mage.dealDamage(warrior);
		}
		
		assertTrue( warrior.getHealth() == 100 );
	}
	
	/*
	 * getDamageDealtByAttacker() tests
	 */
	@Test
	public void shouldNeverDealAnyDamage() {
		Hero mage = new Mage(100, 0, 0);
		for (int i = 0; i < 1000; ++i) {
			int result = mage.getDamageDealtByAttacker();
			assertTrue( result == 0 );
		}
		
		Hero anotherMage = new Mage(100, -10, -10);
		for (int i = 0; i < 1000; ++i) {
			int result = anotherMage.getDamageDealtByAttacker();
			assertTrue( result == 0 );
		}
	} 
	
	/*
	 * tryToCastFireballOn() tests
	 */
	@Test
	public void mageShouldKillItselfWithFireballs() {
		Mage mage = new Mage(100, 1, 1);
		while ( !mage.isDead() ) {
			mage.tryToCastFireballOn(mage);
		}
		assertTrue( mage.isDead() );
	}
	
	@Test
	public void fireballShouldNotDoAnyDamage() {
		Mage mage = new Mage(100, 0, 0);
		Warrior warrior = new Warrior(100, 10, 10);
		
		for (int i = 0; i < 10000; ++i) {
			mage.tryToCastFireballOn(warrior);
		}
		
		assertTrue( warrior.getHealth() == 100 );
	}
	
	@Test(timeout=3000)
	public void fireballShouldKillOtherHeroes() {
		Mage mage = new Mage(100, 5, 5);
		Warrior warrior = new Warrior(100, 10, 10);
		Rogue rogue = new Rogue(100, 10, 10);
		
		while ( !warrior.isDead() || !rogue.isDead() ) {
			mage.tryToCastFireballOn(warrior);
			mage.tryToCastFireballOn(rogue);
		}
		
		assertTrue( warrior.isDead() && rogue.isDead() );
	}
}