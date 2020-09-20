// https://leetcode.com/problems/number-of-lines-to-write-string/

class Solution {
    
    public int[] numberOfLines(int[] widths, String S) {
        int currentLineLength = 0;
        int numberOfUsedLines = 1;
        
        for (int i = 0; i < S.length(); ++i) {
            char letter = S.charAt(i);
            int width = widths[letter - 'a'];
            
            currentLineLength += width;
            
            if (currentLineLength > 100) {
                currentLineLength = width;
                numberOfUsedLines++;
            }
        }
        
        return new int[] { numberOfUsedLines, currentLineLength };
    }
    
}
