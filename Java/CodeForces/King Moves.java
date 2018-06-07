// http://codeforces.com/problemset/problem/710/A

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		String position = read.nextLine();
		
		Map<Character, Integer> columnNumbers = new HashMap<Character, Integer>();
		int columnNumber = 1;
		for (char c = 'a'; c <= 'h'; ++c) {
			columnNumbers.put(c, columnNumber);
			columnNumber++;
		}
		
		int kingRowNumber = Math.abs(9 - Character.getNumericValue(position.charAt(1)) );
		int kingColumnNumber = columnNumbers.get(position.charAt(0));
		int numberOfValidMoves = 0;
		
		boolean canMoveUp = kingRowNumber-1 >= 1;
		boolean canMoveDown = kingRowNumber+1 <= 8;
		boolean canMoveLeft = kingColumnNumber-1 >= 1;
		boolean canMoveRight = kingColumnNumber+1 <= 8;
		boolean canMoveUpLeftDiagonally = canMoveUp && canMoveLeft;
		boolean canMoveUpRightDiagonally = canMoveUp && canMoveRight;
		boolean canMoveDownLeftDiagonally = canMoveDown && canMoveLeft;
		boolean canMoveDownRightDiagonally = canMoveDown && canMoveRight;
		
		if (canMoveUp) { numberOfValidMoves++; }
		if (canMoveDown) { numberOfValidMoves++; }
		if (canMoveLeft) { numberOfValidMoves++; }
		if (canMoveRight) { numberOfValidMoves++; }
		if (canMoveUpLeftDiagonally) { numberOfValidMoves++; }
		if (canMoveUpRightDiagonally) { numberOfValidMoves++; }
		if (canMoveDownLeftDiagonally) { numberOfValidMoves++; }
		if (canMoveDownRightDiagonally) { numberOfValidMoves++; }
		
		System.out.println(numberOfValidMoves);
		
		// Close scanner
		read.close();
	}
}
