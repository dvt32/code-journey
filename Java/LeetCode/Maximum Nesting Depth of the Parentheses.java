// https://leetcode.com/problems/maximum-nesting-depth-of-the-parentheses/

class Solution {
    /* Example breakdown */

    /*
    "() ( () () )"

    '('
    currentNestingLevel = 1;
    maxNestingLevel = 1;

    ')'
    currentNestingLevel = 0;
    maxNestingLevel = 1;

    '('
    currentNestingLevel = 1;
    maxNestingLevel = 1;

    '('
    currentNestingLevel = 2;
    maxNestingLevel = 2;

    ')'
    currentNestingLevel = 1;
    maxNestingLevel = 2;

    '('
    currentNestingLevel = 2;
    maxNestingLevel = 2;

    ')'
    currentNestingLevel = 1;
    maxNestingLevel = 2;

    ')'
    currentNestingLevel = 0;
    maxNestingLevel = 2;
    */
    
    public int maxDepth(String s) {
        int maxNestingLevel = 0;
        int currentNestingLevel = 0;
        
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            
            if (c == '(') {
                currentNestingLevel++;
            }
            else if (c == ')') {
                currentNestingLevel--;
            }
            
            maxNestingLevel = Math.max(currentNestingLevel, maxNestingLevel);
        }
        
        return maxNestingLevel;
    }
    
}
