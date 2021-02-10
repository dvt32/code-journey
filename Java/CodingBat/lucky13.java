// http://codingbat.com/prob/p194525

public boolean lucky13(int[] nums) {
  for (int num : nums) {
    if (num == 1 || num == 3) {
      return false;
    }
  }
  
  return true;
}

// Recursive solution (for fun)

/*
public boolean lucky13(int[] nums) {
  if (nums.length == 0) {
    return true;
  }
  
  return lucky13(nums, 0);
}

public boolean lucky13(int[] nums, int i) {
  if (i == nums.length-1) {
    return (nums[i] != 1 && nums[i] != 3);
  }
  if (nums[i] == 1 || nums[i] == 3) {
    return false;
  }
  
  return lucky13(nums, i+1);
}
*/
