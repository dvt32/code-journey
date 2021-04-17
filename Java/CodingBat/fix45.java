// http://codingbat.com/prob/p125819

public int[] fix45(int[] nums) {
  for (int i = 0; i < nums.length; ++i) {
    for (int j = 0; j < nums.length; ++j) {
      if (nums[i] == 5 && nums[j] == 4) {
        int temp = nums[j+1];
        nums[j+1] = nums[i];
        nums[i] = temp;
      }
    }
  }
  
  return nums;
}

// Recursive solution (for fun)

/*
public int[] fix45(int[] nums) {
  return fix45(nums, 0, 0);
}

public int[] fix45(int[] nums, int i, int j) {
  if (i == nums.length) {
    return nums;
  }
  
  if (j == nums.length) {
    return fix45(nums, i+1, 0);
  }
  
  if (nums[i] == 5 && nums[j] == 4) {
    int temp = nums[j+1];
    nums[j+1] = nums[i];
    nums[i] = temp;
  }
  
  return fix45(nums, i, j+1);
}
*/
