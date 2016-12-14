// https://community.topcoder.com/stat?c=problem_statement&pm=13521

public class NamingConvention {
	public static String toCamelCase(String variableName) {
		String[] wordsInVariableName = variableName.split("_");
		if (wordsInVariableName.length <= 1) {
			return variableName;
		}
		
		StringBuilder newVariableName = new StringBuilder();
		
		newVariableName.append(wordsInVariableName[0]);
		for (int i = 1; i < wordsInVariableName.length; ++i) {
			newVariableName.append(wordsInVariableName[i].substring(0, 1).toUpperCase() + wordsInVariableName[i].substring(1));
		}
		
		return newVariableName.toString();
	}
}
