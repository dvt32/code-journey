// http://codingbat.com/prob/p105771

public int[] evenOdd(int[] nums) {
  for (int i = 0; i < nums.length; ++i) {
    if (nums[i] % 2 == 0) {
      for (int j = i; j > 0; --j) {
        int temp = nums[j];
        nums[j] = nums[j-1];
        nums[j-1] = temp;
      }
    }
  }
  
  return nums;
}
