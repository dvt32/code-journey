// http://codeforces.com/problemset/problem/1017/A

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Solution {
	
	static class Student {
		private int id;
		private int sum;
		
		public Student(int id, int sum) {
			this.id = id;
			this.sum = sum;
		}

		public int getId() {
			return id;
		}
		
		public int getSum() {
			return sum;
		}

		@Override
		public String toString() {
			return "Student [id=" + id + ", sum=" + sum + "]";
		}
	}
	
	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);

		int n = read.nextInt();
		
		List<Student> students = new ArrayList<Student>();
		for (int i = 1; i <= n; ++i) {
			int a = read.nextInt();
			int b = read.nextInt();
			int c = read.nextInt();
			int d = read.nextInt();
			
			int id = i;
			int sum = (a+b+c+d);
			Student student = new Student(id, sum);
			
			students.add(student);
		}
		
		Collections.sort(students, new Comparator<Student>() {
			@Override
			public int compare(Student a, Student b) {
				int aSum = a.getSum();
				int bSum = b.getSum();
				
				if (aSum < bSum) {
					return 1;
				}
				else if (aSum > bSum) {
					return -1;
				}
				else {
					int aId = a.getId();
					int bId = b.getId();
					
					if (aId > bId) {
						return 1;
					}
					else if (aId < bId) {
						return -1;
					}
					else {
						return 0;
					}
				}
			}
		});
		
		
		for (int i = 0; i < n; ++i) {
			int studentId = students.get(i).getId();
			if (studentId == 1) {
				int thomasRank = i+1;
				System.out.println(thomasRank);
				break;
			}
		}
		
		// Close scanner
		read.close();
	}
}
