// http://codingbat.com/prob/p196640

public int bigDiff(int[] nums) {
  int max = nums[0];
  int min = nums[0];
  for (int num : nums) {
    if (num > max) {
      max = num;
    }
    else if (num < min) {
      min = num;
    }
  }
  return Math.abs(max-min);
}

// Recursive solution (for fun)

/*
public int bigDiff(int[] nums) {
  int min = nums[0];
  int max = nums[0];
  return bigDiff(nums, min, max, 0);
}

public int bigDiff(int[] nums, int min, int max, int i) {
  if (i == nums.length) {
    return Math.abs(max-min);
  }
  
  if (nums[i] > max) {
    max = nums[i];
  }
  else if (nums[i] < min) {
    min = nums[i];
  }
  
  return bigDiff(nums, min, max, i+1);
}
*/
