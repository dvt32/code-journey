// http://codingbat.com/prob/p110019

public int array667(int[] nums) {
  int numberCount = 0;
  for (int i = 0; i < nums.length-1; ++i) {
    if (nums[i] == 6 && nums[i+1] == 6) {
      numberCount++;
    }
    else if (nums[i] == 6 && nums[i+1] == 7) {
      numberCount++;
    }
  }
  return numberCount;
}

// Recursive solution (for fun)

/*
public int array667(int[] nums) {
  if (nums.length <= 1) {
    return 0;
  }
  
  return array667(nums, 0);
}

public int array667(int[] nums, int i) {
  if (i == nums.length-1) {
    return 0;
  }
  
  if (nums[i] == 6 && (nums[i+1] == 6 || nums[i+1] == 7)) {
    return 1 + array667(nums, i+1);
  }
  
  return array667(nums, i+1);
}
*/
