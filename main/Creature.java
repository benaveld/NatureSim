package main;

public class Creature {
	private int strength, mass, speed, stamina, endurance, perception, camouflage;
	private int hp;
	private float intake;

	public Creature(Creature parent) {
		int points = 1;

		while (points != 0 || mass < 1) {
			points = Main.maxPoints;

			strength = getPointsIntoStat(parent.getStrength(), points);
			points -= strength;

			mass = getPointsIntoStat(parent.getMass(), points);
			points -= mass;

			speed = getPointsIntoStat(parent.getSpeed(), points);
			points -= speed;

			stamina = getPointsIntoStat(parent.getStamina(), points);
			points -= stamina;

			endurance = getPointsIntoStat(parent.getEndurance(), points);
			points -= endurance;

			perception = getPointsIntoStat(parent.getPerception(), points);
			points -= perception;

			camouflage = getPointsIntoStat(parent.getCamouflage(), points);
			points -= camouflage;
		}

		updateGeneratedStats();
	}

	private int getPointsIntoStat(int defStat, int totalPoints) {
		int point = defStat + (int) Math.round(Math.random() * 2 - 1);

		if (point <= totalPoints && point >= 0) {
			return point;
		} else {
			return 0;
		}
	}

	public Creature(int strength, int mass, int speed, int stamina, int endurance, int perception, int camouflage) {
		this.strength = strength;
		this.mass = mass;
		this.speed = speed;
		this.stamina = stamina;
		this.endurance = endurance;
		this.perception = perception;
		this.camouflage = camouflage;

		updateGeneratedStats();
	}

	public Creature() {
		this(t(), t(), t(), t(), t(), t(), t());
	}

	private static int t() {
		return (int) Math.round(Main.maxPoints / 7);
	}

	private void updateGeneratedStats() {
		hp = endurance * 10;
		intake = mass * 0.1f;
	}
	
	public void printStats(){
		System.out.println("Strength: " + this.strength);
		System.out.println("Mass: " + this.mass + "kg");
		System.out.println("Intake: " + this.intake);
		System.out.println("Speed: " + this.speed);
		System.out.println("Stamina: " + this.stamina);
		System.out.println("Endurance: " + this.endurance);
		System.out.println("Perception: " + this.perception);
		System.out.println("Camouflage: " + this.camouflage);
	}

	public int getStrength() {
		return strength;
	}

	public void setStrength(int strength) {
		this.strength = strength;
	}

	public int getMass() {
		return mass;
	}

	public void setMass(int mass) {
		this.mass = mass;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public int getStamina() {
		return stamina;
	}

	public void setStamina(int stamina) {
		this.stamina = stamina;
	}

	public int getEndurance() {
		return endurance;
	}

	public void setEndurance(int endurance) {
		this.endurance = endurance;
	}

	public int getPerception() {
		return perception;
	}

	public void setPerception(int perception) {
		this.perception = perception;
	}

	public int getCamouflage() {
		return camouflage;
	}

	public void setCamouflage(int camouflage) {
		this.camouflage = camouflage;
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public void decreaseHp(int delta) {
		if (delta < 0)
			return;

		this.hp -= delta;

		if (hp < 0)
			hp = 0;
	}

	public float getIntake() {
		return intake;
	}

	public void setIntake(float intake) {
		this.intake = intake;
	}
}
