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
	
	@Test
	public void shouldCreateRogueWithSword() {
		Rogue rogue = new Rogue(100, 5, 10, new Sword(10));
		assertTrue( rogue.getWeapon() instanceof Sword );
	}
	
	@Test
	public void shouldCreateRogueWithNoWeapon() {
		Rogue rogue = new Rogue(100, 5, 10);
		assertTrue( rogue.getWeapon() == null );
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
	
	@Test
	public void shouldChangeRogueWeaponToAnotherOne() {
		Rogue rogue = new Rogue(100, 2, 3, new Staff(100, 10));
		assertTrue( rogue.getWeapon() instanceof Staff );
		
		Weapon newWeapon = new Dagger(200);
		rogue.setWeapon(newWeapon);	
		assertTrue( rogue.getWeapon() instanceof Dagger );
	}
	
	/*
	 * dealDamageTo() tests
	 */
	@Test
	public void rogueShouldCommitSuicide() {
		Hero rogue = new Rogue(100, 10, 5);
		while ( !rogue.isDead() ) {
			rogue.dealDamageTo(rogue);
		}
		assertTrue( rogue.isDead() );
	}
	
	@Test
	public void rogueShouldKillWarriorButNotMage() {
		Hero rogue = new Rogue(500, 20, 3);
		Hero mage = new Mage(Integer.MAX_VALUE, 10, 5);
		Hero warrior = new Warrior(100, 5, 4);

		while ( !warrior.isDead() ) {
			rogue.dealDamageTo(warrior);
		}
		
		rogue.dealDamageTo(mage);
		
		assertTrue( warrior.isDead() && !mage.isDead() );
	}
	
	@Test
	public void rogueShouldNotInflictAnyDamage() {
		Hero rogue = new Rogue(-1, 10000, 100);
		Hero warrior = new Warrior(100, 0, 0);
		
		for (int i = 0; i < 100; ++i) {
			rogue.dealDamageTo(warrior);
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
	
	/*
	 * dealDamageWithWeaponTo() tests
	 */
	@Test
	public void shouldCommitSuicideWithWeapon() {
		Rogue rogue = new Rogue(100, 100, 5, new Staff(100, 20));
		while ( !rogue.isDead() ) {
			rogue.dealDamageWithWeaponTo(rogue);
		}
		assertTrue( rogue.isDead() );
	}
	
	@Test
	public void shouldKillOtherHeroesWithWeapon() {
		Rogue rogue = new Rogue(100, 2, 5, new Dagger(100));
		Mage mage = new Mage(200, 3, 4);
		Warrior warrior = new Warrior(100, 100, 5);
		
		while ( !mage.isDead() || !warrior.isDead() ) {
			rogue.dealDamageWithWeaponTo(mage);
			rogue.dealDamageWithWeaponTo(warrior);
		}
		
		assertTrue( mage.isDead() && warrior.isDead() );
	}
	
	@Test
	public void shouldNotDealAnyDamageWithWeaponAttackMethod() {
		Rogue rogue = new Rogue(100, 2, 5);
		Mage mage = new Mage(200, 3, 4);
		Warrior warrior = new Warrior(100, 100, 5);
		
		for (int i = 0; i < 10000; ++i) {
			rogue.dealDamageWithWeaponTo(mage);
			rogue.dealDamageWithWeaponTo(warrior);
		}
	
		assertTrue( mage.getHealth() == 200 && warrior.getHealth() == 100 );
	}
	
	@Test
	public void shouldKillOtherHeroesWithWeaponAttackMethodRegardlessOfNegativeWeaponDamageValue() {
		Rogue rogue = new Rogue(100, 2, 5, new Sword(-100));
		Mage mage = new Mage(200, 3, 4);
		Warrior warrior = new Warrior(100, 100, 5);
		
		while ( !mage.isDead() || !warrior.isDead() ) {
			rogue.dealDamageWithWeaponTo(mage);
			rogue.dealDamageWithWeaponTo(warrior);
		}
		
		// Note: The weapon itself doesn't do any damage, so this is like a regular attack.
	
		assertTrue( mage.isDead() && warrior.isDead() );
	}
}