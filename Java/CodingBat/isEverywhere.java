// http://codingbat.com/prob/p110222

public boolean isEverywhere(int[] nums, int val) {
  for (int i = 0; i < nums.length-1; ++i) {
    if (nums[i] != val && nums[i+1] != val) {
      return false;
    }
  }
  
  return true;
}

// Recursive solution (for fun)

/*
public boolean isEverywhere(int[] nums, int val) {
  if (nums.length <= 1) {
    return true;
  }
  
  return isEverywhere(nums, val, 0);
}

public boolean isEverywhere(int[] nums, int val, int i) {
  if (i == nums.length-2) {
    return (nums[i] == val || nums[i+1] == val);
  }
  if (nums[i] != val && nums[i+1] != val) {
    return false;
  }
  
  return isEverywhere(nums, val, i+1);
}
*/
