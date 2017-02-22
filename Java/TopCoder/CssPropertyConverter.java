// https://community.topcoder.com/stat?c=problem_statement&pm=7503

public class CssPropertyConverter {
	public static String getCamelized(String cssPropertyName) {
		StringBuilder camelizedPropertyName = new StringBuilder();
		
		for (int i = 0; i < cssPropertyName.length(); ++i) {
			if (cssPropertyName.charAt(i) == '-') {
				camelizedPropertyName.append( Character.toUpperCase( cssPropertyName.charAt(i+1) ) );
				i++; // skip next character (which will be a letter), since we just appended it
			}
			else {
				camelizedPropertyName.append(cssPropertyName.charAt(i));
			}
		}
		
		return camelizedPropertyName.toString();
	}
}
