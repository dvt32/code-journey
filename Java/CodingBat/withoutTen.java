// http://codingbat.com/prob/p196976

public int[] withoutTen(int[] nums) {
  for (int i = 0; i < nums.length; ++i) {
    if (nums[i] == 10) {
      nums[i] = 0;
      for (int j = nums.length-1; j > i; --j) {
        if (nums[j] != 10) {
          int temp = nums[i];
          nums[i] = nums[j];
          nums[j] = temp;
        }
      }
    }
  }
  
  /* 
    Alternatively, create a copy array with 'nums.length' length 
    and fill it with all the non-10 elements
    The rest of the values will be set to 0 by default 
  */
  
  return nums;
}
