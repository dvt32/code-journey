// https://leetcode.com/problems/valid-parentheses

class Solution {
    
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            boolean isOpeningParanthesis = ( c == '(' || c == '{' || c == '[' );
    
            if (isOpeningParanthesis) {
                stack.add(c);
            }
            else {
                boolean isEmptyStack = stack.isEmpty();
                char charAtStackTop = (!isEmptyStack) ? stack.pop() : ' ';
                switch (c) {
                    case ')': 
                        if (charAtStackTop != '(') { return false; }
                        break;
                    case '}':
                        if (charAtStackTop != '{') { return false; }
                        break;
                    case ']':
                        if (charAtStackTop != '[') { return false; }
                        break;
                    default:
                        break;
                }
            }
        }
        
        return stack.isEmpty();
    }
    
}
