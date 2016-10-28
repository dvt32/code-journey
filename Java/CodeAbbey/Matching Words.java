// http://www.codeabbey.com/index/task_view/matching-words
 
import java.util.Scanner;
import java.util.Map;
import java.util.TreeMap;
 
class Solution
{
	
    public static void main(String[] args)
    {
    	Scanner read = new Scanner(System.in);
        
    	String lineOfWords = read.nextLine();
    	String[] words = lineOfWords.split(" ");
    	Map<String, Integer> numberOfWordInstances =  new TreeMap<String, Integer>();
    	
    	for (int i = 0; i < words.length; ++i) {
    		String currentWord = words[i];
    		int currentWordInstancesCount = 
    				numberOfWordInstances.containsKey(currentWord) 
    				? numberOfWordInstances.get(currentWord)
    				: 0;
    		numberOfWordInstances.put(currentWord, currentWordInstancesCount + 1);
    	}
    	
    	for (String word : numberOfWordInstances.keySet()) {
    		int wordInstancesCount = numberOfWordInstances.get(word);
    		if (wordInstancesCount > 1) {
    			System.out.print(word + " ");
    		}
    	}
    	
        // Close scanner
        read.close();
    }
}
