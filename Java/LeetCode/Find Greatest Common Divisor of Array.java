class Solution {

    static int getGreatestCommonDivisor(int u, int v) {
        if (u == 0) { 
          return v; 
        }
        else if (v == 0) {
          return u;
        }
        else if (u == 0 && v == 0) {
          return -1;
        }
        else if (u % 2 == 0 && v % 2 == 0) {
          return 2 * getGreatestCommonDivisor(u / 2, v / 2);
        }
        else if (u % 2 == 0 && v % 2 != 0) {
          return getGreatestCommonDivisor(u / 2, v);
        }
        else if (u % 2 != 0 && v % 2 == 0) {
          return getGreatestCommonDivisor(u, v / 2);
        }
        else if (u % 2 != 0 && v % 2 != 0 && u >= v) {
          return getGreatestCommonDivisor((u-v)/2, v);
        }
        else if (u % 2 != 0 && v % 2 != 0 && u < v) {
          return getGreatestCommonDivisor((v-u)/2, u);
        }

        return -1;
    }

    public int findGCD(int[] nums) {
        Arrays.sort(nums);

        return getGreatestCommonDivisor(nums[0], nums[nums.length-1]);
    }
}
