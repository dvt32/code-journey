// https://leetcode.com/problems/best-time-to-buy-and-sell-stock

class Solution {
    
    public int maxProfit(int[] prices) {
        if (prices.length <= 1) {
            return 0;
        }
        
        int maxProfit = 0;
        for (int i = 0; i < prices.length; ++i) {
            for (int j = i+1; j < prices.length; ++j) {
                int difference = prices[j] - prices[i];
                if (difference > 0) {
                    int profit = difference;
                    maxProfit = (profit > maxProfit) ? profit : maxProfit;
                }
            }
        }
        
        return maxProfit;
    }
    
}
