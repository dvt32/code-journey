// https://leetcode.com/problems/maximum-split-of-positive-even-integers

class Solution {

    public List<Long> maximumEvenSplit(long finalSum) {
        List<Long> split = new ArrayList<>();

        if (finalSum % 2 == 0) {
            long i = 2;
            long sum = 0;

            while ((sum+i) <= finalSum) {
                split.add(i);
                sum += i;
                i += 2;
            }

            long difference = finalSum - sum;
            int lastElementIndex = split.size()-1;
            split.set(
                split.size()-1,
                split.get(split.size()-1) + difference
            );
        }

        return split;
    }

}
