package net.dvt32.composition.weapons;

import static org.junit.Assert.*;

import org.junit.Test;

public class DaggerTest {
	/*
	 * Constructor tests
	 */
	@Test
	public void shouldCreateDaggerWithTenDamage() {
		Weapon dagger = new Dagger(10);
		int daggerDamage = dagger.getDamage();
		assertEquals(daggerDamage, 10);
	}

	@Test
	public void shouldCreateDaggerWithoutReferencingAbstractClass() {
		Dagger dagger = new Dagger(10);
		assertTrue( dagger.getDamage() == 10 );
		assertTrue( dagger instanceof Dagger );
	}
	
	/*
	 * Getter/setter tests
	 */
	@Test
	public void shouldGetDaggerDamageValueAndChangeItTo1337() {
		Dagger dagger = new Dagger(10);
		assertEquals( dagger.getDamage(), 10 );
		dagger.setDamage(1337);
		assertEquals( dagger.getDamage(), 1337 );
	}
	
	@Test(expected = NumberFormatException.class)
	public void getterShouldThrowNumberFormatException() {
		Dagger dagger = new Dagger(new Integer(null));
		int daggerDamage = dagger.getDamage();
	}

	/*
	 * getDamageDealtByWeapon() tests
	 */
	@Test
	public void shouldReturnZero() {
		Dagger dagger = new Dagger(-10);
		int damageDealtByDagger = dagger.getDamageDealtByWeapon();
		assertEquals(damageDealtByDagger, 0);
	}
	
	@Test
	public void shouldReturnDaggerDamageOrDoubleItsValue() {
		Dagger dagger = new Dagger(1337);
		int damageDealtByDagger = dagger.getDamageDealtByWeapon();
		assertTrue(
			damageDealtByDagger == 1337 ||
			damageDealtByDagger == (1337 * 2)
		);
	}
}