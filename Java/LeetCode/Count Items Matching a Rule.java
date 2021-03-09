// https://leetcode.com/problems/count-items-matching-a-rule/

class Solution {
    
    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int matchCount = 0;
        
        int ruleKeyIndex = 0;
        if (ruleKey.equals("color")) {
            ruleKeyIndex = 1;
        }
        else if (ruleKey.equals("name")) {
            ruleKeyIndex = 2;
        }
        
        for (List<String> item : items) {
            if (item.get(ruleKeyIndex).equals(ruleValue)) {
                matchCount++;
            }
        }
        
        return matchCount;
    }
    
}
