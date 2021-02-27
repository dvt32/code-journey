// http://codingbat.com/prob/p121853

public boolean has22(int[] nums) {
  for (int i = 0; i < nums.length-1; ++i) {
    if (nums[i] == 2 && nums[i+1] == 2) {
      return true;
    }
  }
  
  return false;
}

// Recursive solution (for fun)

/*
public boolean has22(int[] nums) {
  if (nums.length <= 1) {
    return false;
  }
  
  return has22(nums, 0);
}

public boolean has22(int[] nums, int i) {
  if (i == nums.length-1) {
    return false;
  }
  
  if (nums[i] == 2 && nums[i+1] == 2) {
    return true;
  }
  
  return has22(nums, i+1);
}
*/
