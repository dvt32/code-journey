package net.dvt32.inheritanceandabstraction;

/**
 * This class is an abstract representation of a hero in a videogame.
 * 
 * Each hero has:
 * - a 'health' attribute
 * - a 'damage' attribute
 * - a special power attribute (strength, intelligence, agility etc)
 * - a method, which checks if the hero is dead
 * - a method, which deals damage to another hero
 * 
 * @author Dimitar Trifonov (dvt32)
 */
public abstract class Hero {
	private int health;
	private int damage;
	private int specialPower;
	
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
	 * If the attacker (or the victim) is dead, the attack is disregarded.
	 * 
	 * @param victim The hero that we're attacking
	 */
	public void dealDamage(Hero victim) {
		String attackerClassName = this.getClass().getSimpleName();
		String victimClassName = victim.getClass().getSimpleName();
		boolean bothHeroesAlive = ( !this.isDead() && !victim.isDead() );
		
		if (bothHeroesAlive) {
			int victimHealthBeforeAttack = victim.getHealth();
			int damageDealtByAttacker = this.getDamageDealtByAttacker();
			victim.setHealth(victimHealthBeforeAttack - damageDealtByAttacker);
			System.out.println( 
				attackerClassName 
				+ " dealt " + damageDealtByAttacker + " damage to " 
				+ victimClassName
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
}