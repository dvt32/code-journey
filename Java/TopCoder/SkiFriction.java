// https://community.topcoder.com/stat?c=problem_statement&pm=10294

public class SkiFriction {
	public static int bestPosition(String skiFriction, String pathFriction) {
		int timeRequired = 0;
	
		for (int i = 0; i < pathFriction.length() - skiFriction.length(); ++i) {
			int maxTotalFriction = 0;
			
			for (int j = 0; j < skiFriction.length(); ++j) {
				int skiSegmentFriction = Character.getNumericValue( skiFriction.charAt(j) );
				int pathSegmentFriction = Character.getNumericValue ( pathFriction.charAt(i+j) );
				
				int totalFriction = skiSegmentFriction + pathSegmentFriction;
				if (totalFriction > maxTotalFriction) {
					maxTotalFriction = totalFriction;
				}
			}
			
			timeRequired += maxTotalFriction;
		}
		
		return timeRequired;
	}
}
