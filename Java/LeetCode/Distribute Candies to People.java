// https://leetcode.com/problems/distribute-candies-to-people/

class Solution {
    
    public int[] distributeCandies(int candies, int num_people) {
        int n = num_people;
        int[] ans = new int[n];
        
        int candiesToGive = 1;
        while (candies > 0) {
            for (int i = 0; i < n; ++i) {
                if (candies < candiesToGive) {
                    ans[i] += candies;
                    candies = 0;
                    break;
                }
                ans[i] += candiesToGive;
                candies -= candiesToGive;
                candiesToGive++;
            }
        }
        
        return ans;
    }
    
}
