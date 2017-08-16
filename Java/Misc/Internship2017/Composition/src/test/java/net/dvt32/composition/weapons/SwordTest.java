package net.dvt32.composition.weapons;

import static org.junit.Assert.*;
import net.dvt32.composition.heroes.Warrior;

import org.junit.Test;

public class SwordTest {

	/*
	 * Constructor tests
	 */
	@Test
	public void shouldCreateSwordWithDamageValue10() {
		Weapon sword = new Sword(10);
		int swordDamage = sword.getDamage();
		assertEquals(swordDamage, 10);
	}

	@Test
	public void shouldCreateSwordWithoutReferencingAbstractClass() {
		Sword sword = new Sword(10);
		assertTrue( sword instanceof Sword );
	}
	
	/*
	 * Getter/setter tests
	 */
	@Test
	public void shouldGetWeaponDamageValueAndChangeItTo1337() {
		Sword sword = new Sword(10);
		assertEquals( sword.getDamage(), 10 );
		sword.setDamage(1337);
		assertEquals( sword.getDamage(), 1337 );
	}
	
	@Test(expected = NumberFormatException.class)
	public void getterShouldThrowNumberFormatException() {
		Sword sword = new Sword(new Integer(null));
		int swordDamage = sword.getDamage();
	}
	
	/*
	 * getDamageDealtByWeapon() tests
	 */
	@Test
	public void shouldReturnZero() {
		Sword sword = new Sword(-10);
		int damageDealtBySword = sword.getDamageDealtByWeapon();
		assertEquals(damageDealtBySword, 0);
	}
	
	@Test
	public void shouldReturn1337() {
		Sword sword = new Sword(1337);
		int damageDealtBySword = sword.getDamageDealtByWeapon();
		assertEquals(damageDealtBySword, 1337);
	}
}