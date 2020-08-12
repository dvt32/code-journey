// https://leetcode.com/problems/sort-integers-by-the-number-of-1-bits/

class Solution {

    public int[] sortByBits(int[] arr) {
        Integer[] numbers = Arrays.stream(arr).boxed().toArray( Integer[]::new );
        
        Arrays.sort(numbers, new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                String aToBinary = Integer.toBinaryString(a);
                String bToBinary = Integer.toBinaryString(b);
                
                int aOneCount = 0;
                int bOneCount = 0;
                
                for (int i = 0; i < aToBinary.length(); ++i) {
                    if (aToBinary.charAt(i) == '1') {
                        aOneCount++;
                    }
                }
                for (int i = 0; i < bToBinary.length(); ++i) {
                    if (bToBinary.charAt(i) == '1') {
                        bOneCount++;
                    }
                }
                
                if(aOneCount == bOneCount) {
                    return a.compareTo(b);
                }
                else if (aOneCount > bOneCount) {
                    return 1;
                }
                else {
                    return -1;
                }
            }
        });
        
        arr = Arrays.stream(numbers).mapToInt(Integer::intValue).toArray();
        
        return arr;
    }
    
}
