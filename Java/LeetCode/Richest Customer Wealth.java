// https://leetcode.com/problems/richest-customer-wealth/

class Solution {
    
    public int maximumWealth(int[][] accounts) {
        int maxWealth = Integer.MIN_VALUE;
        
        for (int[] account : accounts) {
            int wealth = 0;
            for (int money : account) {
                wealth += money;
            }
            maxWealth = Math.max(wealth, maxWealth);
        }
        
        return maxWealth;
    }
    
    /*
    public int maximumWealth(int[][] accounts) {
        int maxWealth = Integer.MIN_VALUE;
        
        for (int[] account : accounts) {
            maxWealth = Math.max(maxWealth, IntStream.of(account).sum());
        }
        
        return maxWealth;
    }
    */
    
}
