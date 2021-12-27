// https://leetcode.com/problems/evaluate-reverse-polish-notation/

class Solution {
    
    public int evalRPN(String[] tokens) {
        Stack<Integer> valueStack = new Stack<>();
        int operand1 = 0, operand2 = 0, temp = 0;
        
        for (String token : tokens) {
            if ( token.length() > 1 || Character.isDigit(token.charAt(0)) ) {
                valueStack.push( Integer.parseInt(token) );
            }
            else {
                operand1 = valueStack.pop();
                operand2 = valueStack.pop();
                
                switch ( token.charAt(0) ) {
                    case '+': temp = operand2 + operand1; break;
                    case '-': temp = operand2 - operand1; break;
                    case '*': temp = operand2 * operand1; break;
                    case '/': temp = operand2 / operand1; break;
                }
                
                valueStack.push(temp);
            }
        }
        
        return valueStack.peek();
    }
    
}
