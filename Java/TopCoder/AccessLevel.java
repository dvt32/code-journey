// https://community.topcoder.com/stat?c=problem_statement&pm=3100

public class AccessLevel {
	public static String canAccess(int[] rights, int minPermission) {
		StringBuilder userPermissions = new StringBuilder();
		
		for (int privilegeLevel : rights) {
			if (privilegeLevel >= minPermission) {
				userPermissions.append('A');
			}
			else {
				userPermissions.append('D');
			}
		}
		
		return userPermissions.toString();
	}
}
