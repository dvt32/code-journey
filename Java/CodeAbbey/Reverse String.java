// http://www.codeabbey.com/index/task_view/reverse-string
 
import java.util.Scanner;
 
class Solution
{
   
    public static void main(String[] args)
    {
        Scanner read = new Scanner(System.in);
       
        char[] line = read.nextLine().toCharArray();
        
        for (int i = 0, j = line.length-1; i < line.length / 2; ++i, --j) {
        	char temp = line[i];
        	line[i] = line[j];
        	line[j] = temp;
        }
        
        System.out.println(line);
        		
        // Close scanner
        read.close();
    }
}
