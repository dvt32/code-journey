// http://codeforces.com/problemset/problem/230/A

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Solution {
	
	static class Dragon implements Comparable<Dragon> {
		private int strength;
		private int defeatBonus;
		
		public Dragon(int strength, int defeatBonus) {
			this.strength = strength;
			this.defeatBonus = defeatBonus;
		}

		public int getStrength() {
			return strength;
		}
		public int getDefeatBonus() {
			return defeatBonus;
		}

		@Override
		public int compareTo(Dragon otherDragon) {
			int thisDragonStrength = this.getStrength();
			int otherDragonStrength = otherDragon.getStrength();
			
			if (thisDragonStrength > otherDragonStrength) {
				return 1; // thisDragon is greater
			}
			else if (thisDragonStrength < otherDragonStrength) {
				return -1; // otherDragon is greater
			}
			else {
				int thisDragonDefeatBonus = this.getDefeatBonus();
				int otherDragonDefeatBonus = otherDragon.getDefeatBonus();
				if (thisDragonDefeatBonus > otherDragonDefeatBonus) {
					return 1;
				}
				else {
					return -1;
				}
			}
		}	
	}
	
	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		
		int s = read.nextInt();
		int n = read.nextInt();
		
		Set<Dragon> dragons = new TreeSet<Dragon>();
		
		for (int i = 0; i < n; ++i) {
			int x = read.nextInt(); // dragon's strength
			int y = read.nextInt(); // bonus for defeating dragon
			dragons.add(new Dragon(x, y));
		}
		
		boolean canMoveToNextLevel = true;
		for (Dragon dragon : dragons) {
			if (s > dragon.getStrength()) {
				s += dragon.getDefeatBonus();
			}
			else {
				canMoveToNextLevel = false;
				break;
			}
		}
		
		if (canMoveToNextLevel) {
			System.out.println("YES");
		}
		else {
			System.out.println("NO");
		}
		
		// Close scanner
		read.close();
	}
	
}
