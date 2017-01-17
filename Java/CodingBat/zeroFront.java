// http://codingbat.com/prob/p193753

public int[] zeroFront(int[] nums) {
  for (int i = 0; i < nums.length; ++i) {
    if (nums[i] == 0) {
      int zeroIndex = i;
      while (zeroIndex > 0 && nums[zeroIndex-1] != 0) {
        int temp = nums[zeroIndex-1];
        nums[zeroIndex-1] = 0;
        nums[zeroIndex] = temp;
        zeroIndex--;
      }
    }
  }
  
  return nums;
}
