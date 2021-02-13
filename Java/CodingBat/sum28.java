// http://codingbat.com/prob/p199612

public boolean sum28(int[] nums) {
  int sum = 0;
  for (int num : nums) {
    if (num == 2) {
      sum += 2;
    }
  }
  
  return (sum == 8);
}

// Recursive solution (for fun)

/*
public boolean sum28(int[] nums) {
  if (nums.length == 0) {
    return false;
  }
  return sum28(nums, 0, 0);
}

public boolean sum28(int[] nums, int i, int twoSum) {
  if (i == nums.length) {
    return (twoSum == 8);
  }
  
  if (nums[i] == 2) {
    twoSum += 2;
  }
  
  return sum28(nums, i+1, twoSum);
}
*/
