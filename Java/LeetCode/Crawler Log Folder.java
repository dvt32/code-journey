// https://leetcode.com/problems/crawler-log-folder/

class Solution {
    
    public int minOperations(String[] logs) {
        LinkedList<String> pathAfterOperations = new LinkedList<String>();
        
        for (String operation : logs) {
            switch (operation) {
                case "../":
                    if (pathAfterOperations.size() != 0) {
                        pathAfterOperations.removeLast();
                    }
                    break;
                case "./": 
                    break;
                default:
                    pathAfterOperations.add(operation);
                    break;
            }
        }
        
        /*
            Empty list means we are in the main folder.
            
            Therefore the number of elements we need to remove to empty the list 
            is equal to the minimum number of operations we need to perform 
            to go back to the main folder.
        */
        int minOperationsCount = pathAfterOperations.size();
        
        return minOperationsCount; 
    }
    
}
