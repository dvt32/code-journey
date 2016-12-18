// https://community.topcoder.com/stat?c=problem_statement&pm=11553

import java.util.List;
import java.util.ArrayList;
import static java.util.Arrays.asList;

public class WhichDay {
	public static String getDay(String[] notOnThisDay) {
		List<String> weekDays = new ArrayList<String>(asList("Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"));
		
		for (String day : notOnThisDay) {
			weekDays.remove(day);
		}
		
		return weekDays.get(0);
	}
}


/* Alternative solution */

/*

// https://community.topcoder.com/stat?c=problem_statement&pm=11553

import java.util.Map;
import java.util.HashMap;

public class WhichDay {
	public static String getDay(String[] notOnThisDay) {
		String[] weekDays = new String[] { "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday" };
		Map<String, Integer> dayOccurrences = new HashMap<String, Integer>() {
			@Override
			public Integer get(Object key) {
				if (containsKey(key)) {
					return super.get(key);
				}
				else {
					return 0;
				}
			}
		};
		
		for (String day : notOnThisDay) {
			dayOccurrences.put(day, 1);
		}
		
		for (String day : weekDays) {
			if (dayOccurrences.get(day) == 0) {
				return day;
			}
		}
		
		return "";
	}
}

*/
