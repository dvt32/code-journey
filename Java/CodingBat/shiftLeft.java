// http://codingbat.com/prob/p105031

public int[] shiftLeft(int[] nums) {
  for (int i = 0; i < nums.length-1; ++i) {
    int temp = nums[i];
    nums[i] = nums[i+1];
    nums[i+1] = temp;
  }
  
  return nums;
}

// Recursive solution (for fun)

/*
public int[] shiftLeft(int[] nums) {
  return shiftLeft(nums, 0);
}

public int[] shiftLeft(int[] nums, int i) {
  if (i >= nums.length-1) {
    return nums;
  }
  
  int temp = nums[i];
  nums[i] = nums[i+1];
  nums[i+1] = temp;
  
  return shiftLeft(nums, i+1);
}
*/
