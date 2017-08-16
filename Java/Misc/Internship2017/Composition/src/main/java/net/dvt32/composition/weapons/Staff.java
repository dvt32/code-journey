package net.dvt32.composition.weapons;

/**
 * This class represents a type of Weapon - a Staff.
 * A staff has two attributes – damage and spellpower. It always deals the full damage + spellpower.
 * The Staff is intended to be used by a Hero.
 * 
 * @author Dimitar Trifonov (dvt32)
 */
public class Staff 
	extends Weapon 
{
	private int spellpower;
	
	/**
	 * Constructor for a Staff object
	 * 
	 * Because every Weapon has a damage attribute, 
	 * the superclass' constructor is used to initialize that attribute's value.
	 * 
	 * @param damage The Staff's damage attribute value
	 * @param spellpower The Staff's spellpower attribute value
	 */
	public Staff(int damage, int spellpower) {
		super(damage);
		this.spellpower = spellpower;
	}
	
	/*
	 * Getters/setters
	 */
	public int getSpellpower() {
		return spellpower;
	}
	
	public void setSpellpower(int spellpower) {
		this.spellpower = spellpower;
	}

	/**
	 * This method calculates the amount of damage dealt by the weapon.
	 * The damage a Staff deals is equal to
	 * -> its damage attribute's value + its spellpower attribute's value
	 * (unless the sum turns out to be a negative number, in which case the damage dealt is 0)
	 * 
	 * @return The amount of damage dealt by the Staff
	 */
	@Override
	public int getDamageDealtByWeapon() {
		int damageDealtByWeapon = this.getDamage() + this.getSpellpower();
		if (damageDealtByWeapon < 0) {
			return 0;
		}
		else {
			return damageDealtByWeapon;	
		}
	}
}