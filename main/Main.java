package main;

public class Main {
	// Settings
	public static final int iterations = 10000;
	public static final int numOfChildren = 100;
	public static final int maxPoints = 200;
	public static final Creature faceOfCreature = new Creature(40, 5, 70, 70, 5, 5, 5);

	// Variables
	public static Creature[] children = new Creature[numOfChildren];

	public static void main(String[] args) {
		// Starts of with an alpha Creature with evenly distribute stats points.
		Creature alpha = new Creature();

		System.out.println("Starting Simulation at " + Util.getCurrentTime() + ".");
		
		for (int iteration = 0; iteration < iterations; iteration++) {
			double[] results = new double[children.length];

			for (int i = 0; i < children.length; i++) {
				// create a mutated version of the current alpha
				children[i] = new Creature(alpha);

				// Run the problem and get a score
				results[i] = hunt(children[i]);
			}
			
			//print out the progress every 100 iterations
			if (iteration % 100 == 0 && iteration != 0 && iteration != iterations)
				System.out.println((iteration / 1000f) + "k done out of " + (iterations / 1000) + "k (" + (100 * iteration / (float) (iterations)) + "%) at "
						+ Util.getCurrentTime() + ".");
			
			// The new alpha is the one with the best score
			alpha = children[Util.getMaximi(results)];
		}

		System.out.println("Simulation is finish at " + Util.getCurrentTime() + ".\n\nAlpha:");
		alpha.printStats();
		
		System.out.println("\nFace of creature:");
		faceOfCreature.printStats();
	}

	private static double hunt(Creature c) {
		double points = 0;
		
		//Repeat 100 or until the creature is dead (hp == 0) 
		for (int i = 0; i < 100 && c.getHp() > 0; i++) {
			if (Math.random() > 0.5) {
				if (c.getPerception() - faceOfCreature.getCamouflage() + c.getSpeed() * c.getStamina() <= faceOfCreature.getPerception()
						+ faceOfCreature.getSpeed() * faceOfCreature.getStamina()) {
					points += (c.getStrength() + c.getEndurance()) / (float) (faceOfCreature.getStrength() + faceOfCreature.getEndurance());
					c.decreaseHp(faceOfCreature.getStrength() - c.getEndurance());
				} else {
					points += (c.getPerception() - faceOfCreature.getCamouflage() + c.getSpeed() * c.getStamina())
							/ (float) (faceOfCreature.getPerception() + faceOfCreature.getSpeed() * faceOfCreature.getStamina());
				}
			} else {
				if (c.getPerception() - faceOfCreature.getCamouflage() + c.getSpeed() * c.getStamina() >= faceOfCreature.getPerception()
						+ faceOfCreature.getSpeed() * faceOfCreature.getStamina()) {
					points += (c.getPerception() + c.getCamouflage() + c.getSpeed() * c.getStamina())
							/ (float) (faceOfCreature.getPerception() + faceOfCreature.getCamouflage() + faceOfCreature.getSpeed()
									* faceOfCreature.getStamina());
				} else {
					points += (c.getStrength() + c.getEndurance()) / (float) (faceOfCreature.getStrength() + faceOfCreature.getEndurance());
					c.decreaseHp(faceOfCreature.getStrength() - c.getEndurance());
				}
			}
		}

		return points;
	}
}
