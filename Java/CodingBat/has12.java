// http://codingbat.com/prob/p169260

public boolean has12(int[] nums) {
  boolean has1 = false;
  
  for (int i = 0; i < nums.length; ++i) {
    if (nums[i] == 1) {
      has1 = true;
    }
    else if (nums[i] == 2 && has1) {
      return true;
    }
  }
  
  return false;
}

// Recursive solution (for fun)

/*
public boolean has12(int[] nums) {
  if (nums.length < 2) {
    return false;
  }
  
  return has12(nums, false, 0);
}

public boolean has12(int[] nums, boolean has1, int i) {
  if (i == nums.length) {
    return false;
  }
  
  if (nums[i] == 1) {
    has1 = true;
  }
  else if (nums[i] == 2 && has1) {
    return true;
  }
  
  return has12(nums, has1, i+1);
}
*/
