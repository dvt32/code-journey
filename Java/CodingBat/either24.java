// http://codingbat.com/prob/p191878

public boolean either24(int[] nums) {
  boolean has_2_next_to_2 = false;
  boolean has_4_next_to_4 = false;
  
  for (int i = 0; i < nums.length - 1; ++i) {
    if (nums[i] == nums[i+1] && nums[i] == 2) {
      has_2_next_to_2 = true;
    }
    else if (nums[i] == nums[i+1] && nums[i] == 4) {
      has_4_next_to_4 = true;
    }
  }
  
  return (has_2_next_to_2 ^ has_4_next_to_4); // ^ is XOR - only one of the two must be true, in order for the return value to also be true
}

// Recursive solution (for fun)

/*
public boolean either24(int[] nums) {
  if (nums.length < 2) {
    return false;
  }
  
  return either24(nums, false, false, 0);
}

public boolean either24(int[] nums, boolean has_2_next_to_2, boolean has_4_next_to_4, int i) {
  if (i == nums.length-1) {
    return (has_2_next_to_2 ^ has_4_next_to_4);
  }
  
  if (nums[i] == nums[i+1] && nums[i] == 2) {
    has_2_next_to_2 = true;
  }
  else if (nums[i] == nums[i+1] && nums[i] == 4) {
    has_4_next_to_4 = true;
  }
  
  return either24(nums, has_2_next_to_2, has_4_next_to_4, i+1);
}
*/
