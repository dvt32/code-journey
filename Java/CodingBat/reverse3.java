// http://codingbat.com/prob/p112409

public int[] reverse3(int[] nums) {
  for (int i = 0, j = nums.length-1; i < nums.length / 2; ++i) {
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
  }
  return nums;
}
