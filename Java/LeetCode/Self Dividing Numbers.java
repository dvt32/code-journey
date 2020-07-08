// https://leetcode.com/problems/self-dividing-numbers/

class Solution {
    
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> selfDividingNumbers = new ArrayList<>();
        
        while (left <= right) {
            int number = left;
            char[] numberDigits = String.valueOf(number).toCharArray();
            
            boolean isSelfDividingNumber = true;
            for (char digitAsChar : numberDigits) {
                int digit = Character.getNumericValue(digitAsChar);
                if (digit == 0 || number % digit != 0) {
                    isSelfDividingNumber = false;
                    break;
                }
            }
            
            if (isSelfDividingNumber) {
                selfDividingNumbers.add(number);
            }
            
            left++;
        }
        
        return selfDividingNumbers;
    }
    
}
