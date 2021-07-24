// https://leetcode.com/problems/determine-color-of-a-chessboard-square/

// Way more efficient solutions available, but this gets the job done too.

class Solution {
    
    public boolean squareIsWhite(String coordinates) {
        Map<String, Boolean> isWhiteMap = new HashMap<>();
        
        boolean isWhite = false;
        for (char c = 'a'; c <= 'h'; ++c) {
            for (int i = 1; i <= 8; ++i) {
                isWhiteMap.put("" + c + i, isWhite);
                isWhite = !isWhite;
            }
            isWhite = !isWhite;
        }
        
        return isWhiteMap.get(coordinates);
    }
    
}
