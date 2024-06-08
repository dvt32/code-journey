// https://leetcode.com/problems/largest-number-after-digit-swaps-by-parity/

class Solution {

    public int largestInteger(int num) {
        String numChars = String.valueOf(num);
        boolean[] isEvenDigit = new boolean[numChars.length()];
        List<Integer> evenDigits = new ArrayList<>();
        List<Integer> oddDigits = new ArrayList<>();

        for (int i = 0; i < numChars.length(); ++i) {
            int digit = Character.getNumericValue( numChars.charAt(i) );
            if (digit % 2 == 0) {
                evenDigits.add(digit);
                isEvenDigit[i] = true;
            } else {
                oddDigits.add(digit);
                isEvenDigit[i] = false;
            }
        }

        Collections.sort(evenDigits, Collections.reverseOrder());
        Collections.sort(oddDigits, Collections.reverseOrder());

        StringBuilder sb = new StringBuilder();
        for (int i = 0, j = 0, k = 0; i < numChars.length(); ++i) {
            if (isEvenDigit[i]) {
                sb.append(evenDigits.get(j++));
            } else {
                sb.append(oddDigits.get(k++));
            }
        }

        return Integer.parseInt(sb.toString());
    }

}
