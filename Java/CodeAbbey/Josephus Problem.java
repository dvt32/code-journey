// http://www.codeabbey.com/index/task_view/josephus-problem
 
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
 
class Solution
{
	
    public static void main(String[] args)
    {
    	Scanner read = new Scanner(System.in);
        
    	int N = read.nextInt();
    	int K = read.nextInt();
  
    	// Add N people to the circle
    	List<Integer> people = new ArrayList<Integer>();
    	for (int i = 1; i <= N; ++i) {
    		people.add(i);
    	}
    	
    	// Eliminate every K-th person
     	int numberOfPeopleLeft = N;
     	int personToBeKilled = K-1; // position of that person in 'people'
    	while (!(people.isEmpty())) {
    		int lastManStanding = people.remove(personToBeKilled);
    		numberOfPeopleLeft--;
    		if (numberOfPeopleLeft > 0) {
    			personToBeKilled = (personToBeKilled + K-1) % numberOfPeopleLeft;
    		}
    		else {
    			System.out.print(lastManStanding + " ");
    		}
    	}
        
        // Close scanner
        read.close();
    }
}
