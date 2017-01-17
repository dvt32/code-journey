// http://codingbat.com/prob/p105031

public int[] shiftLeft(int[] nums) {
  for (int i = 0; i < nums.length-1; ++i) {
    int temp = nums[i];
    nums[i] = nums[i+1];
    nums[i+1] = temp;
  }
  
  return nums;
}
