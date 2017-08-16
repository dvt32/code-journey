package net.dvt32.composition.heroes;

import net.dvt32.composition.weapons.Weapon;

/**
 * This class is an abstract representation of a hero in a videogame.
 * 
 * Each hero has:
 * - a 'health' attribute
 * - a 'damage' attribute
 * - a special power attribute (strength, intelligence, agility etc)
 * - a method, which checks if the hero is dead
 * - a method, which deals damage to another hero
 * - a weapon (optional), which can be swapped for another one
 * 
 * @author Dimitar Trifonov (dvt32)
 */
public abstract class Hero {
	private int health;
	private int damage;
	private int specialPower;
	private Weapon weapon;
	
	/**
	 * Constructor for every Hero object. 
	 * This constructor is called within every derived class's own constructor
	 * 
	 * @param health The hero's health points
	 * @param damage The hero's damage points
	 * @param specialPower The hero's special power points
	 */
	public Hero(int health, int damage, int specialPower) {
		this.health = health;
		this.damage = damage;
		this.specialPower = specialPower;
	}
	
	/**
	 * Additional constructor, which allows the Hero to have a weapon.
	 * 
	 * @param health The hero's health points
	 * @param damage The hero's damage points
	 * @param specialPower The hero's special power points
	 * @param weapon The hero's weapon type
	 */
	public Hero(int health, int damage, int specialPower, Weapon weapon) {
		this.health = health;
		this.damage = damage;
		this.specialPower = specialPower;
		this.weapon = weapon;
	}

	/*
	 * Getter/setter methods
	 */
	public int getHealth() {
		return health;
	}
	
	public void setHealth(int health) {
		this.health = health;
	}
	
	public int getDamage() {
		return damage;
	}
	
	public void setDamage(int damage) {
		this.damage = damage;
	}
	
	public int getSpecialPower() {
		return specialPower;
	}
	
	public void setSpecialPower(int specialPower) {
		this.specialPower = specialPower;
	}
	
	public Weapon getWeapon() {
		return weapon;
	}
	
	public void setWeapon(Weapon weapon) {
		this.weapon = weapon;
	}
	
	/**
	 * This method checks if the hero is dead.
	 * He is considered dead when his health is at 0 or less.
	 * 
	 * @return True if the hero is dead, false otherwise
	 */
	public boolean isDead() {
		return (health <= 0);
	}
	
	/**
	 * This method allows a hero to deal damage to another hero.
	 * If the attacker (or the target) is dead, the attack is disregarded.
	 * 
	 * @param target The hero that we're attacking
	 */
	public void dealDamageTo(Hero target) {
		String attackerClassName = this.getClass().getSimpleName();
		String targetClassName = target.getClass().getSimpleName();
		boolean bothHeroesAlive = ( !this.isDead() && !target.isDead() );
		
		if (bothHeroesAlive) {
			int victimHealthBeforeAttack = target.getHealth();
			int damageDealtByAttacker = this.getDamageDealtByAttacker();
			target.setHealth(victimHealthBeforeAttack - damageDealtByAttacker);
			System.out.println( 
				attackerClassName 
				+ " dealt " + damageDealtByAttacker + " damage to " 
				+ targetClassName
			);
		}
	}
	
	/**
	 * This method calculates how much damage a hero's attack will inflict.
	 * The method is abstract, because every hero's "damage per attack" is calculated differently.
	 * 
	 * @return The number of damage points a hero will deal to another hero
	 */
	public abstract int getDamageDealtByAttacker();
	
	/**
	 * This method allows a hero to deal damage to another hero, by using the weapon he has.
	 * If the attacker does not have a weapon, the attack doesn't deal any damage.
	 * 
	 * @param target The hero being attacked
	 */
	public void dealDamageWithWeaponTo(Hero target) {
		String attackerClassName = this.getClass().getSimpleName();
		String targetClassName = target.getClass().getSimpleName();
		Weapon attackerWeapon = this.getWeapon();
		boolean bothHeroesAlive = ( !this.isDead() && !target.isDead() );
		boolean attackerHasWeapon = ( attackerWeapon != null );
		
		if (bothHeroesAlive && attackerHasWeapon) {
			String attackerWeaponClassName = attackerWeapon.getClass().getSimpleName();
			int victimHealthBeforeAttack = target.getHealth();
			int damageDealtByAttacker = this.getDamageDealtByAttacker() + attackerWeapon.getDamageDealtByWeapon();
			target.setHealth(victimHealthBeforeAttack - damageDealtByAttacker);
			System.out.println( 
				attackerClassName 
				+ " dealt " + damageDealtByAttacker + " damage to " 
				+ targetClassName
				+ " with " + attackerWeaponClassName
			);
		}
	}
}