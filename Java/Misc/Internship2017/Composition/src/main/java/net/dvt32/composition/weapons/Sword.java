package net.dvt32.composition.weapons;

/**
 * This class represents a type of Weapon - a Sword.
 * A sword has one attribute – damage. It always deals full damage.
 * The Sword is intended to be used by a Hero.
 * 
 * @author Dimitar Trifonov (dvt32)
 */
public class Sword 
	extends Weapon
{
	/**
	 * Constructor for a Sword object
	 * 
	 * Because every Weapon has a damage attribute, 
	 * the superclass' constructor is used 
	 * when initializing a Sword.
	 * 
	 * @param damage The Sword's damage attribute value
	 */
	public Sword(int damage) {
		super(damage);
	}

	/**
	 * This method calculates the amount of damage dealt by the Sword.
	 * A Sword always deals damage equal to its damage attribute value
	 * (unless its value is negative - in that case, the damage dealt is 0)
	 * 
	 * @return The amount of damage dealt by the Weapon.
	 */
	@Override
	public int getDamageDealtByWeapon() {
		int weaponDamage = this.getDamage();
		if (weaponDamage < 0) {
			return 0;
		}
		else {
			return weaponDamage;
		}
	}
}