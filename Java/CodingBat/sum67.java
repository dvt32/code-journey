// http://codingbat.com/prob/p111327

public int sum67(int[] nums) {
  int sum = 0;
  
  for (int i = 0; i < nums.length; ++i) {
    if (nums[i] == 6) {
      while (nums[i] != 7) {
        i++;
      }
      continue;
    }
    sum += nums[i];
  }
  
  return sum;
}

// Recursive solution (for fun)

/*
public int sum67(int[] nums) {
  if (nums.length == 0) {
    return 0;
  }
  
  return sum67(nums, 0);
}

public int sum67(int[] nums, int i) {
  if (i == nums.length) {
    return 0;
  }
  
  if (nums[i] == 6) {
    while (nums[i] != 7) {
      i++;
    }
    return sum67(nums, i+1);
  }
  
  return nums[i] + sum67(nums, i+1);
}
*/
