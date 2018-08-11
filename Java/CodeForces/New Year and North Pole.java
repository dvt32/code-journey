// http://codeforces.com/problemset/problem/750/B

import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);

		int n = read.nextInt();
		
		read.nextLine();
		
		boolean isValid = true;
		
		int position = 0;
		for (int i = 0; i < n; ++i) {
			String[] line = read.nextLine().split(" ");
			int t = Integer.parseInt(line[0]);
			String dir = line[1];
			
			if (
					( position == 0 && !dir.equals("South") ) ||
					( position == 20000 && !dir.equals("North") ) ||
					( position < 0 || position > 20000 )
			   ) 
			{
				isValid = false;
				break;
			}

			if (dir.equals("South")) {
				position += t;
			}
			else if (dir.equals("North")) {
				position -= t;
			}	
		}
		
		if (position != 0) {
			isValid = false;
		}
		
		if (isValid) {
			System.out.println("YES");
		}
		else {
			System.out.println("NO");
		}
		
		// Close scanner
		read.close();
	}
}
