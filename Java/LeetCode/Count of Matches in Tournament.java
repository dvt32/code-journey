// https://leetcode.com/problems/count-of-matches-in-tournament/

class Solution {
    
    public int numberOfMatches(int n) {
        int numberOfMatchesPlayed = 0;
        
        while (n > 1) {
            if (n % 2 == 0) {
                numberOfMatchesPlayed += (n / 2);
                n = n / 2;
            }
            else {
                numberOfMatchesPlayed += ((n - 1) / 2);
                n = ((n - 1) / 2) + 1;
            }
        }
        
        return numberOfMatchesPlayed;
    }
    
}
