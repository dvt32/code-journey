// http://codingbat.com/prob/p187050

public int[] zeroMax(int[] nums) {
  for (int i = 0; i < nums.length; ++i) {
    if (nums[i] == 0) {
      int maxOddValue = 0;
      for (int j = i+1; j < nums.length; ++j) {
        if (nums[j] % 2 == 1 && nums[j] > maxOddValue) {
          maxOddValue = nums[j];
        }
      }
      nums[i] = maxOddValue;
    }
  }
  
  return nums;
}
