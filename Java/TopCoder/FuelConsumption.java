// https://community.topcoder.com/stat?c=problem_statement&pm=2980

public class FuelConsumption {
	public static double maximalDistance(int[] velocities, int[] consumptions, int fuel) {
		double maxDistanceTravelled = 0.0d;
		
		for (int i = 0; i < velocities.length; ++i) {
			int fuelLeft = fuel;
			double distanceTravelled = 0.0d;
			
			while (fuelLeft >= consumptions[i]) {
				distanceTravelled += velocities[i];
				fuelLeft -= consumptions[i];
			}	
			
			double time = ( (double) fuelLeft / consumptions[i] );
			double distanceTravelledFromFuelLeft = velocities[i] * time; // based on formula Distance = Speed * Time
			distanceTravelled += distanceTravelledFromFuelLeft;
			
			if (distanceTravelled > maxDistanceTravelled) {
				maxDistanceTravelled = distanceTravelled;
			}
		}
		
		return maxDistanceTravelled;
	}
}
