// http://codeforces.com/problemset/problem/490/A

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
	
	static class Child {
		private int index;
		private int skillNumber;
		
		public Child(int index, int skillNumber) {
			this.index = index;
			this.skillNumber = skillNumber;
		}

		public int getIndex() {
			return index;
		}

		public void setIndex(int index) {
			this.index = index;
		}

		public int getSkillNumber() {
			return skillNumber;
		}

		public void setSkillNumber(int skillNumber) {
			this.skillNumber = skillNumber;
		}
	}
	
	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		int n = read.nextInt();
		
		List<Child> programmers = new ArrayList<Child>();
		List<Child> mathematicians = new ArrayList<Child>();
		List<Child> sportsmen = new ArrayList<Child>();
		
		for (int i = 0; i < n; ++i) {
			int index = i+1;
			int skillNumber = read.nextInt();
			
			switch (skillNumber) {
			case 1:
				programmers.add( new Child(index, skillNumber) );
				break;
			case 2:
				mathematicians.add( new Child(index, skillNumber) );
				break;
			case 3:
				sportsmen.add( new Child(index, skillNumber) );
				break;
			default: break;
			}
		}
		
		int teamCount = 0;
		List<String> teamIndices = new ArrayList<String>();
		while ( !programmers.isEmpty() && !mathematicians.isEmpty() && !sportsmen.isEmpty() ) {
			teamCount++;
			Child programmer = programmers.remove( programmers.size() - 1 );
			Child mathematician = mathematicians.remove( mathematicians.size() - 1 );
			Child sportsman = sportsmen.remove( sportsmen.size() - 1 );
			teamIndices.add( 
				programmer.getIndex() + " " + 
				mathematician.getIndex() + " " + 
				sportsman.getIndex() 
			);
		}
		
		System.out.println(teamCount);
		for (String teamIndex : teamIndices) {
			System.out.println(teamIndex);
		}
		
		// Close scanner
		read.close();
	}
	
}
