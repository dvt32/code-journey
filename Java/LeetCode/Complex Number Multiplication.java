// https://www.mathsisfun.com/algebra/complex-number-multiply.html

class Solution {
    
    public String complexNumberMultiply(String num1, String num2) {
        String[] num1Parts = num1.split("\\+");
        String[] num2Parts = num2.split("\\+");
        
        Integer a = Integer.parseInt( num1Parts[0] );
        Integer b = Integer.parseInt( num1Parts[1].substring(0, num1Parts[1].length()-1) );
        Integer c = Integer.parseInt( num2Parts[0] );
        Integer d = Integer.parseInt( num2Parts[1].substring(0, num2Parts[1].length()-1) );

        String result = 
            "" + (a*c - b*d) 
            + "+"
            + (a*d + b*c) + "i";
        
        return result;
    }
    
}
