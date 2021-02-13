// http://codingbat.com/prob/p168357

public boolean has77(int[] nums) {
  for (int i = 0; i < nums.length - 1; ++i) {
    if ( nums[i] == nums[i+1] && nums[i] == 7 ) {
      return true;
    }
    else if ( i < nums.length-2 && nums[i] == nums[i+2] && nums[i] == 7 ) {
      return true;
    }
  }
  
  return false;
}

// Recursive solution (for fun)

/*
public boolean has77(int[] nums) {
  if (nums.length < 2) {
    return false;
  }
  
  return has77(nums, 0);
}

public boolean has77(int[] nums, int i) {
  if (i == nums.length-2) {
    return (nums[i] == 7 && nums[i] == nums[i+1]);
  }
  
  if (
    nums[i] == 7 && 
    (nums[i] == nums[i+1] || nums[i] == nums[i+2])
  ) {
    return true;
  }
  
  return has77(nums, i+1);
}
*/
