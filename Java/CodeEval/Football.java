// https://www.codeeval.com/open_challenges/230/

import java.io.*;
import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import java.util.StringJoiner;
import java.util.TreeMap;
import java.util.TreeSet;

public class Main {	
	public static void main(String[] args) 
		throws IOException 
	{
		File inputFile = new File( args[0] );
		BufferedReader bufferedReader = new BufferedReader( new FileReader(inputFile) );
		String lineInFile;

		while ( (lineInFile = bufferedReader.readLine()) != null ) {
			lineInFile = lineInFile.trim();
			
			if (lineInFile.isEmpty()) {
				lineInFile = bufferedReader.readLine(); // Escape Enter key press
			}
			
			String[] countries = lineInFile.split(" \\| ");
			Map<Integer, Set<Integer>> countriesThatLoveTeam = new TreeMap<Integer, Set<Integer>>();
			
			for (int i = 0; i < countries.length; ++i) {
				int countryNumber = (i+1);
				int[] teams = Arrays.stream(countries[i].split(" ")).mapToInt(Integer::parseInt).toArray();	
				for (int team : teams) {
					if (countriesThatLoveTeam.get(team) == null) {
						countriesThatLoveTeam.put(team, new TreeSet<Integer>());
					}
					countriesThatLoveTeam.get(team).add(countryNumber);
				}
			}
			
			// Handle output
			StringBuilder output = new StringBuilder();
			for (Integer team : countriesThatLoveTeam.keySet()) {
				output.append(team + ":");	
				StringJoiner countryNumbers = new StringJoiner(",");
				for (Integer countryNumber : countriesThatLoveTeam.get(team)) {
					countryNumbers.add(String.valueOf(countryNumber));
				}
				output.append(countryNumbers + "; ");
			}
			
			System.out.println( output.toString().trim() );
 		}

		bufferedReader.close();
	}
}
