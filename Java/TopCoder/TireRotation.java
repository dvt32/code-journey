// https://community.topcoder.com/stat?c=problem_statement&pm=1791

public class TireRotation {
	public static int getCycle(String initial, String current) {
		if (initial.equals(current)) {
			return 1;
		}
		
		int phase = 1;
		
		while (!(initial.equals(current)) && phase <= 4) {
			initial = String.valueOf(new char[] {
				initial.charAt(3),
				initial.charAt(2),
				initial.charAt(0),
				initial.charAt(1),
			});
			phase++;
		}
		
		return (phase <= 4) ? phase : -1;
	}
}
