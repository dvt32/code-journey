// https://www.codeeval.com/open_challenges/23/

public class Main {
	public static void main(String[] args) {
		for (int i = 1; i <= 12; ++i) {
			StringBuilder currentLine = new StringBuilder();
	
			for (int j = 1; j <= 12; ++j) {
				int currentNumber = i * j;
				
				switch ( String.valueOf(currentNumber).length() ) {
				case 1:
					currentLine.append("   ");
					break;
				case 2:
					currentLine.append("  ");
					break;
				case 3: 
					currentLine.append(" ");
					break;
				default: 
					break;
				}
				
				currentLine.append(currentNumber);
			}
			
			System.out.println( currentLine.toString().trim() );
		}
    }
}
