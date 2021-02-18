// http://codingbat.com/prob/p199484

public int[] tenRun(int[] nums) {
  int currentMultiple = -1;
  
  for (int i = 0; i < nums.length; ++i) {
    if ( nums[i] % 10 == 0 ) {
      currentMultiple = nums[i];
    }
    else if (currentMultiple != -1) {
      nums[i] = currentMultiple;
    }
  }
  
  return nums;
}

// Recursive solution (for fun)

/*
public int[] tenRun(int[] nums) {
  if (nums.length <= 1) {
    return nums;
  }
  
  return tenRun(nums, 0, -1);
}

public int[] tenRun(int[] nums, int i, int currentMultiple) {
  if (i == nums.length) {
    return nums;
  }
  
  if ( nums[i] % 10 == 0 ) {
    currentMultiple = nums[i];
  }
  else if (currentMultiple != -1) {
    nums[i] = currentMultiple;
  }
  
  return tenRun(nums, i+1, currentMultiple);
}
*/
