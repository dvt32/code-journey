// http://www.codeabbey.com/index/task_view/triangle-area

/*

Problem Author's Note:

There exists a formula for direct calculation by coordinates - the absolute value of the vector product divided by two:

P = x1 * (y2 - y3)
  + x2 * (y3 - y1)
  + x3 * (y1 - y2)

area = abs(P) / 2
The vector product of any two sides is numerically equal to the area of the parallelogram built upon them and the triangle is just the half of this shape.
 
*/
 
import java.util.Scanner;
 
class Solution
{
	
    public static void main(String[] args)
    {
    	Scanner read = new Scanner(System.in);
        
    	int numberOfTriangles = read.nextInt();
    	
    	for (int i = 0; i < numberOfTriangles; ++i) {
    		int x1 = read.nextInt();
    		int y1 = read.nextInt();
    		int x2 = read.nextInt();
    		int y2 = read.nextInt();
    		int x3 = read.nextInt();
    		int y3 = read.nextInt();
    		
    		/*
    		 * Get distance between 2 points:
    		 * - (x1,y1) and (x2,y2) => length of A
    		 * - (x1,y1) and (x3,y3) => length of B
    		 * - (x2,y2) and (x3,y3) => length of C
    		 * 
    		 * It doesn't matter what order the points are in, because squaring removes any negatives
    		 * 
    		 * More info here: https://www.mathsisfun.com/algebra/distance-2-points.html
    		 *
    		 */
    		double lengthOfA = Math.sqrt((x1-x2)*(x1-x2) + (y1-y2)*(y1-y2));
    		double lengthOfB = Math.sqrt((x1-x3)*(x1-x3) + (y1-y3)*(y1-y3));
    		double lengthOfC = Math.sqrt((x2-x3)*(x2-x3) + (y2-y3)*(y2-y3));
    		
    		// Get area of triangle using Heron's formula
    		double semiPerimeter = 0.5 * (lengthOfA + lengthOfB + lengthOfC);
    		double areaOfTriangle = Math.sqrt(semiPerimeter * (semiPerimeter - lengthOfA) * (semiPerimeter - lengthOfB) * (semiPerimeter - lengthOfC));
    		
    		System.out.print(areaOfTriangle + " ");
    	}
    	
        // Close scanner
        read.close();
    }
}
