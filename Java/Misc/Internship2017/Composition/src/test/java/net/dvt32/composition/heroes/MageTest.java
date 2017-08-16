package net.dvt32.composition.heroes;

import static org.junit.Assert.*;
import net.dvt32.composition.heroes.Hero;
import net.dvt32.composition.heroes.Mage;
import net.dvt32.composition.heroes.Rogue;
import net.dvt32.composition.heroes.Warrior;
import net.dvt32.composition.weapons.Dagger;
import net.dvt32.composition.weapons.Staff;
import net.dvt32.composition.weapons.Sword;
import net.dvt32.composition.weapons.Weapon;

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
	
	@Test
	public void shouldCreateMageWithDagger() {
		Mage mage = new Mage(100, 5, 10, new Dagger(10));
		assertTrue( mage.getWeapon() instanceof Dagger );
	}
	
	@Test
	public void shouldCreateMageWithNoWeapon() {
		Mage mage = new Mage(100, 5, 10);
		assertTrue( mage.getWeapon() == null );
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
	
	@Test
	public void shouldChangeMageWeaponToAnotherOne() {
		Mage mage = new Mage(100, 2, 3, new Staff(100, 10));
		assertTrue( mage.getWeapon() instanceof Staff );
		
		Weapon newWeapon = new Dagger(200);
		mage.setWeapon(newWeapon);	
		assertTrue( mage.getWeapon() instanceof Dagger );
	}
	
	/*
	 * dealDamageTo() tests
	 */
	@Test
	public void mageShouldCommitSuicide() {
		Hero mage = new Mage(100, 10, 5);
		while ( !mage.isDead() ) {
			mage.dealDamageTo(mage);
		}
		assertTrue( mage.isDead() );
	}
	
	@Test
	public void mageShouldKillWarriorAndRogue() {
		Hero mage = new Mage(100, 10, 5);
		Hero warrior = new Warrior(100, 5, 4);
		Hero rogue = new Rogue(500, 20, 3);
		
		while ( !warrior.isDead() || !rogue.isDead() ) {
			mage.dealDamageTo(warrior);
			mage.dealDamageTo(rogue);
		}
		
		assertTrue( warrior.isDead() && rogue.isDead() );
	}
	
	@Test
	public void mageShouldNotInflictAnyDamage() {
		Hero mage = new Mage(-1, 10000, 100);
		Hero warrior = new Warrior(100, 0, 0);
		
		for (int i = 0; i < 100; ++i) {
			mage.dealDamageTo(warrior);
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
	
	/*
	 * dealDamageWithWeaponTo() tests
	 */
	@Test
	public void shouldCommitSuicideWithWeapon() {
		Mage mage = new Mage(100, 100, 5, new Staff(100, 20));
		while ( !mage.isDead() ) {
			mage.dealDamageWithWeaponTo(mage);
		}
		assertTrue( mage.isDead() );
	}
	
	@Test
	public void shouldKillOtherHeroesWithWeapon() {
		Mage mage = new Mage(200, 3, 4, new Dagger(100));
		Warrior warrior = new Warrior(100, 100, 5);
		Rogue rogue = new Rogue(100, 2, 5);
		
		while ( !warrior.isDead() || !rogue.isDead() ) {
			mage.dealDamageWithWeaponTo(warrior);
			mage.dealDamageWithWeaponTo(rogue);
		}
		
		assertTrue( warrior.isDead() && rogue.isDead() );
	}
	
	@Test
	public void shouldNotDealAnyDamageWithWeaponAttackMethod() {
		Mage mage = new Mage(200, 3, 4);
		Warrior warrior = new Warrior(100, 100, 5);
		Rogue rogue = new Rogue(100, 2, 5);
		
		for (int i = 0; i < 10000; ++i) {
			mage.dealDamageWithWeaponTo(warrior);
			mage.dealDamageWithWeaponTo(rogue);
		}
	
		assertTrue( warrior.getHealth() == 100 && rogue.getHealth() == 100 );
	}
	
	@Test
	public void shouldKillOtherHeroesWithWeaponAttackMethodRegardlessOfNegativeWeaponDamageValue() {
		Mage mage = new Mage(200, 3, 4, new Sword(-100));
		Warrior warrior = new Warrior(100, 100, 5);
		Rogue rogue = new Rogue(100, 2, 5);
		
		while ( !warrior.isDead() || !rogue.isDead() ) {
			mage.dealDamageWithWeaponTo(warrior);
			mage.dealDamageWithWeaponTo(rogue);
		}
		
		// Note: The weapon itself doesn't do any damage, so this is like a regular attack.
	
		assertTrue( warrior.isDead() && rogue.isDead() );
	}
}