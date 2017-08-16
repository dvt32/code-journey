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
	
	@Test
	public void shouldCreateWarriorWithSword() {
		Warrior warrior = new Warrior(100, 5, 10, new Sword(10));
		assertTrue( warrior.getWeapon() instanceof Sword );
	}
	
	@Test
	public void shouldCreateWarriorWithNoWeapon() {
		Warrior warrior = new Warrior(100, 5, 10);
		assertTrue( warrior.getWeapon() == null );
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
	
	@Test
	public void shouldChangeWarriorWeaponToAnotherOne() {
		Warrior warrior = new Warrior(100, 2, 3, new Sword(100));
		assertTrue( warrior.getWeapon() instanceof Sword );
		
		Weapon newWarriorWeapon = new Dagger(200);
		warrior.setWeapon(newWarriorWeapon);	
		assertTrue( warrior.getWeapon() instanceof Dagger );
	}
	
	/*
	 * dealDamageTo() tests
	 */
	@Test
	public void warriorShouldCommitSuicide() {
		Hero warrior = new Warrior(100, 10, 5);
		while ( !warrior.isDead() ) {
			warrior.dealDamageTo(warrior);
		}
		assertTrue( warrior.isDead() );
	}
	
	@Test
	public void warriorShouldKillMageOrRogue() {
		Hero warrior = new Warrior(100, 10, 5);
		Hero mage = new Mage(100, 5, 4);
		Hero rogue = new Rogue(500, 20, 3);
		
		while ( !mage.isDead() || !rogue.isDead() ) {
			warrior.dealDamageTo(mage);
			warrior.dealDamageTo(rogue);
		}
		
		assertTrue( mage.isDead() || rogue.isDead() );
	}
	
	@Test
	public void warriorShouldNotInflictAnyDamage() {
		Hero warrior = new Warrior(-1, 10000, 100);
		Hero mage = new Mage(100, 0, 0);
		
		for (int i = 0; i < 100; ++i) {
			warrior.dealDamageTo(mage);
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
	
	/*
	 * dealDamageWithWeaponTo() tests
	 */
	@Test
	public void shouldCommitSuicideWithWeapon() {
		Warrior warrior = new Warrior(100, 100, 5, new Staff(100, 20));
		while ( !warrior.isDead() ) {
			warrior.dealDamageWithWeaponTo(warrior);
		}
		assertTrue( warrior.isDead() );
	}
	
	@Test
	public void shouldKillOtherHeroesWithWeapon() {
		Warrior warrior = new Warrior(100, 100, 5, new Dagger(100));
		Rogue rogue = new Rogue(100, 2, 5);
		Mage mage = new Mage(200, 3, 4);
		
		while ( !rogue.isDead() || !mage.isDead() ) {
			warrior.dealDamageWithWeaponTo(rogue);
			warrior.dealDamageWithWeaponTo(mage);
		}
		
		assertTrue( rogue.isDead() && mage.isDead() );
	}
	
	@Test
	public void shouldNotDealAnyDamageWithWeaponAttackMethod() {
		Warrior warrior = new Warrior(100, 100, 5);
		Rogue rogue = new Rogue(100, 2, 5);
		Mage mage = new Mage(200, 3, 4);
		
		for (int i = 0; i < 10000; ++i) {
			warrior.dealDamageWithWeaponTo(rogue);
			warrior.dealDamageWithWeaponTo(mage);
		}
	
		assertTrue( rogue.getHealth() == 100 && mage.getHealth() == 200 );
	}
	
	@Test
	public void shouldKillOtherHeroesWithWeaponAttackMethodRegardlessOfNegativeWeaponDamageValue() {
		Warrior warrior = new Warrior(100, 100, 5, new Sword(-100));
		Rogue rogue = new Rogue(100, 2, 5);
		Mage mage = new Mage(200, 3, 4);
		
		while ( !rogue.isDead() || !mage.isDead() ) {
			warrior.dealDamageWithWeaponTo(rogue);
			warrior.dealDamageWithWeaponTo(mage);
		}
		
		// Note: The weapon itself doesn't do any damage, so this is like a regular attack.
	
		assertTrue( rogue.isDead() && mage.isDead() );
	}
}