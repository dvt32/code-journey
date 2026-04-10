// https://leetcode.com/problems/roman-to-integer

class Solution {
    public int romanToInt(String s) {
        int num = 0;
        for (int i = 0; i < s.length(); ++i) {
            int val = value(s.charAt(i));
            if (i+1 < s.length() && val < value(s.charAt(i+1))) {
                num -= val;
            } else {
                num += val;
            }
        }

        return num;
    }

    public int value(char c) {
        return switch (c) {
            case 'I' -> 1;
            case 'V' -> 5;
            case 'X' -> 10;
            case 'L' -> 50;
            case 'C' -> 100;
            case 'D'-> 500;
            case 'M' -> 1000;
            default -> 0;
        };
    }
}

// Alternative solution
/*
class Solution {
    public int romanToInt(String s) {
        Map<Character, Integer> map = Map.of(
            'I', 1,
            'V', 5,
            'X', 10,
            'L', 50,
            'C', 100,
            'D', 500,
            'M', 1000
        );

        int num = 0;
        for (int i = s.length()-1; i >= 0; --i) {
            int val = map.get(s.charAt(i));
            if (i-1 >= 0) {
                int val2 = map.get(s.charAt(i-1));
                if (val2 < val) {
                    val -= val2;
                    i--;
                }
            }
            num += val;
        }

        return num;
    }
}
*/
