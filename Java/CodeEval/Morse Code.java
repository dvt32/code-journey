// https://www.codeeval.com/open_challenges/116/

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;

public class Main {	
	public static void main(String[] args) throws IOException {
		File inputFile = new File( args[0] );
		BufferedReader bufferedReader = new BufferedReader( new FileReader(inputFile) );
		String lineInFile;
		
		while ( (lineInFile = bufferedReader.readLine()) != null ) {
			lineInFile = lineInFile.trim();
			
			if (lineInFile.isEmpty()) {
				lineInFile = bufferedReader.readLine(); // Escape Enter key press
			}
			
			Map<String, Character> morseCodeTable = new HashMap<String, Character>();
			morseCodeTable.put(".-", 'A');
			morseCodeTable.put("-...", 'B');
			morseCodeTable.put("-.-.", 'C');
			morseCodeTable.put("-..", 'D');
			morseCodeTable.put(".", 'E');
			morseCodeTable.put("..-.", 'F');
			morseCodeTable.put("--.", 'G');
			morseCodeTable.put("....", 'H');
			morseCodeTable.put("..", 'I');
			morseCodeTable.put(".---", 'J');
			morseCodeTable.put("-.-", 'K');
			morseCodeTable.put(".-..", 'L');
			morseCodeTable.put("--", 'M');
			morseCodeTable.put("-.", 'N');
			morseCodeTable.put("---", 'O');
			morseCodeTable.put(".--.", 'P');
			morseCodeTable.put("--.-", 'Q');
			morseCodeTable.put(".-.", 'R');
			morseCodeTable.put("...", 'S');
			morseCodeTable.put("-", 'T');
			morseCodeTable.put("..-", 'U');
			morseCodeTable.put("...-", 'V');
			morseCodeTable.put(".--", 'W');
			morseCodeTable.put("-..-", 'X');
			morseCodeTable.put("-.--", 'Y');
			morseCodeTable.put("--..", 'Z');	
			morseCodeTable.put("-----", '0');
			morseCodeTable.put(".----", '1');
			morseCodeTable.put("..---", '2');
			morseCodeTable.put("...--", '3');
			morseCodeTable.put("....-", '4');
			morseCodeTable.put(".....", '5');
			morseCodeTable.put("-....", '6');
			morseCodeTable.put("--...", '7');
			morseCodeTable.put("---..", '8');
			morseCodeTable.put("----.", '9');
			
			String[] words = lineInFile.split("  ");
			StringJoiner decodedWords = new StringJoiner(" ");
			for (String word : words) {
				String[] morseCodeLetters = word.split(" ");
				
				StringBuilder decodedWord = new StringBuilder();
				for (int i = 0; i < morseCodeLetters.length; ++i) {
					String currentMorseCodeLetter = morseCodeLetters[i];
					decodedWord.append( morseCodeTable.get(currentMorseCodeLetter) );
				}
				
				decodedWords.add(decodedWord);
			}
			System.out.println( decodedWords );
		}
		
		bufferedReader.close();
	}
}
