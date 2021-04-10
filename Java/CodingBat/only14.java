// http://codingbat.com/prob/p186672

public boolean only14(int[] nums) {
  for (int num : nums) {
    if (num != 1 && num != 4) {
      return false;
    }
  }
  
  return true;
}

// Recursive solution (for fun)

/*
public boolean only14(int[] nums) {
  return only14(nums, 0);
}

public boolean only14(int[] nums, int i) {
  if (i == nums.length) {
    return true;
  }
  
  if (nums[i] != 1 && nums[i] != 4) {
    return false;
  }
  
  return only14(nums, i+1);
}
*/
