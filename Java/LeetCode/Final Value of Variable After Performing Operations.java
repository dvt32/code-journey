// https://leetcode.com/problems/final-value-of-variable-after-performing-operations/

class Solution {

    public int finalValueAfterOperations(String[] operations) {
        int x = 0;
        
        for (String operation : operations) {
            if (operation.contains("+")) {
                x++;
            } else {
                x--;
            }
        }
        
        return x;
    }
    
}
