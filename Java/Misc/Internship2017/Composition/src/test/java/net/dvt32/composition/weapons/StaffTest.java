package net.dvt32.composition.weapons;

import static org.junit.Assert.*;

import org.junit.Test;

public class StaffTest {
	/*
	 * Constructor tests
	 */
	@Test
	public void shouldCreateStaffWithTenDamageAndTenSpellpower() {
		Weapon staff = new Staff(10, 10);
		int staffDamage = staff.getDamage();
		int staffSpellpower = ((Staff) staff).getSpellpower();
		assertEquals(staffDamage, 10);
		assertEquals(staffSpellpower, 10);
	}

	@Test
	public void shouldCreateStaffWithoutReferencingAbstractClass() {
		Staff staff = new Staff(10, 10);
		assertTrue( staff instanceof Staff );
	}
	
	/*
	 * Getter/setter tests
	 */
	@Test
	public void shouldGetStaffDamageAndSpellpowerValuesAndChangeThem() {
		Staff staff = new Staff(10, 10);
		assertEquals( staff.getDamage(), 10 );
		assertEquals( staff.getSpellpower(), 10 );
		
		staff.setDamage(1337);
		staff.setSpellpower(1337);
		assertEquals( staff.getDamage(), 1337 );
		assertEquals( staff.getSpellpower(), 1337 );
	}
	
	@Test(expected = NumberFormatException.class)
	public void getterShouldThrowNumberFormatException() {
		Staff staff = new Staff(new Integer(null), 45);
		int staffDamage = staff.getDamage();
	}
	
	/*
	 * getDamageDealtByWeapon() tests
	 */
	@Test
	public void shouldReturnZero() {
		Staff staff = new Staff(-10, -20);
		int damageDealtByStaff = staff.getDamageDealtByWeapon();
		assertEquals(damageDealtByStaff, 0);
	}
	
	@Test
	public void shouldReturn1337() {
		Staff staff = new Staff(1335, 2);
		int damageDealtByStaff = staff.getDamageDealtByWeapon();
		assertEquals(damageDealtByStaff, 1337);
	}
}