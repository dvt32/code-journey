// https://leetcode.com/problems/lemonade-change/

class Solution {

    public boolean lemonadeChange(int[] bills) {
        int fiveCount = 0;
        int tenCount = 0;
        
        for (int bill : bills) {
            if (bill == 5) { 
                fiveCount++; 
            }
            else if (bill == 10) {
                tenCount++;
                fiveCount--;
            }
            else {
                if (tenCount > 0) {
                    tenCount--;
                    fiveCount--;
                }
                else {
                    fiveCount -= 3;
                }
            }
            
            if (fiveCount < 0) {
                return false;
            }
        }
        
        return true;
    }
    
}
