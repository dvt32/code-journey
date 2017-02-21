// http://codingbat.com/prob/p125819

public int[] fix45(int[] nums) {
  for (int i = 0; i < nums.length; ++i) {
    for (int j = 0; j < nums.length; ++j) {
      if (nums[i] == 5 && nums[j] == 4) {
        int temp = nums[j+1];
        nums[j+1] = nums[i];
        nums[i] = temp;
      }
    }
  }
  
  return nums;
}
