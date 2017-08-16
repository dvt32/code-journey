package net.dvt32.composition.weapons;

/**
 * This class is an abstract representation of a weapon.
 * 
 * Each weapon deals a certain amount of damage,
 * which is determined by its 'damage' attribute or/and by additional attributes in child classes.
 * 
 * The actual "damage dealing" is not done by the weapon itself, but by the Hero who uses the Weapon.
 * 
 * @author Dimitar Trifonov (dvt32)
 */
public abstract class Weapon {
	private int damage;
	
	public Weapon(int damage) {
		this.damage = damage;
	}
	
	/*
	 * Getters/setters
	 */
	public int getDamage() {
		return damage;
	}
	
	public void setDamage(int damage) {
		this.damage = damage;
	}
	
	/**
	 * This method calculates how much damage a certain weapon will deal.
	 * The method is abstract, because every weapon deals a different amount of damage.
	 * 
	 * @return The amount of damage the weapon will deal to the target when used
	 */
	public abstract int getDamageDealtByWeapon();
}