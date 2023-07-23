// https://leetcode.com/problems/sum-in-a-matrix

class Solution {

    public int matrixSum(int[][] nums) {
        boolean[][] removed = new boolean[nums.length][];
        for (int i = 0; i < nums.length; ++i) {
            removed[i] = new boolean[nums[i].length];
        }
        
        int score = 0;
        boolean stillRemoving = true;

        while (stillRemoving) {
            SortedSet<Integer> removedNums = new TreeSet<>();
            stillRemoving = false;

            for (int i = 0; i < nums.length; ++i) {
                int max = -1;
                int maxIndex = -1;

                for (int j = 0; j < nums[i].length; ++j) {
                    if (nums[i][j] > max && !removed[i][j]) {
                        max = nums[i][j];
                        maxIndex = j;
                        stillRemoving = true;
                    }
                }

                if (stillRemoving) {
                    removed[i][maxIndex] = true;
                    removedNums.add(nums[i][maxIndex]);
                }  
            }

            if (stillRemoving) {
                score += removedNums.last();
            }
        }

        return score;
    }

}
