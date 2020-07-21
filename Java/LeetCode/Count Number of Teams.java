// https://leetcode.com/problems/count-number-of-teams/

class Solution {

    public int numTeams(int[] rating) {
        int numberOfTeams = 0;
        
        for (int i = 0; i < rating.length; ++i) {
            for (int j = 0; j < rating.length; ++j) {
                for (int k = 0; k < rating.length; ++k) {
                    if (i < j & j < k) {
                        if (rating[i] < rating[j] && rating[j] < rating[k]) {
                            numberOfTeams++;
                        }
                        else if (rating[i] > rating[j] && rating[j] > rating[k]) {
                            numberOfTeams++;
                        }
                    }
                }
            }
        }
        
        return numberOfTeams;
    }
    
}
