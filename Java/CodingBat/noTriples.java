// http://codingbat.com/prob/p170221

public boolean noTriples(int[] nums) {
  for (int i = 0; i < (nums.length-2); ++i) {
    if (nums[i] == nums[i+1] &&
        nums[i] == nums[i+2] &&
        nums[i+1] == nums[i+2])
    {
      return false;
    }
  }
  return true;
}

// Recursive solution (for fun)

/*
public boolean noTriples(int[] nums) {
  if (nums.length < 3) {
    return true;
  }
  
  return noTriples(nums, 0);
}

public boolean noTriples(int[] nums, int i) {
  if (i == nums.length-2) {
    return true;
  }
  
  if (nums[i] == nums[i+1] &&
      nums[i] == nums[i+2] &&
      nums[i+1] == nums[i+2])
  {
    return false;
  }
  
  return noTriples(nums, i+1);
}
*/
