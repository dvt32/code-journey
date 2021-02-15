// http://codingbat.com/prob/p136648

public boolean no14(int[] nums) {
  boolean no4 = true;
  boolean no1 = true;
  
  for (int num : nums) {
    if (num == 1) {
      no1 = false;
    }
    else if (num == 4) {
      no4 = false;
    }
  }
  
  return (no1 || no4);
}

// Recursive solution (for fun)

/*
public boolean no14(int[] nums) {
  if (nums.length == 0) {
    return true;
  }
  
  return noNum(nums, 0, 1) || noNum(nums, 0, 4);
}

public boolean noNum(int[] nums, int i, int num) {
  if (i == nums.length) {
    return true;
  }
  
  if (nums[i] == num) {
    return false;
  }
  
  return noNum(nums, i+1, num);
}
*/
