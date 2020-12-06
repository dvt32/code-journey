// https://leetcode.com/problems/goal-parser-interpretation/

class Solution {
    
    public String interpret(String command) {
        StringBuilder interpretation = new StringBuilder();
        
        for (int i = 0; i < command.length(); ++i) {
            char c = command.charAt(i);
            if (c == 'G') {
                interpretation.append('G');
            }
            else if (c == '(') {
                if (command.charAt(i+1) == ')') {
                    interpretation.append('o');
                }
                else {
                    interpretation.append("al");
                }
            }
        }
        
        return interpretation.toString();
    }
    
}
