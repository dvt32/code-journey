// https://www.hackerrank.com/challenges/java-stack

import java.util.Scanner;
import java.util.Stack;

public class Solution {

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		while (read.hasNext()) 
		{
			Stack<Character> paranthesesStack = new Stack<Character>();
			String input = read.next();
			for (int i = 0; i < input.length(); ++i) 
			{
				char currentCharacter = input.charAt(i);
				if (!paranthesesStack.isEmpty())
				{
					switch (currentCharacter) 
					{
						case ')': if (paranthesesStack.peek() == '(') { paranthesesStack.pop(); } break;
						case '}': if (paranthesesStack.peek() == '{') { paranthesesStack.pop(); } break;
						case ']': if (paranthesesStack.peek() == '[') { paranthesesStack.pop(); } break;
						default: paranthesesStack.push(currentCharacter); break;
					}
				}
				else 
				{
					paranthesesStack.push(currentCharacter);
				}
			}
			System.out.println(paranthesesStack.isEmpty());
		}
		
		// Close scanner
		read.close();
	}
}
