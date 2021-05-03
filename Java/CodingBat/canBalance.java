// http://codingbat.com/prob/p158767

public boolean canBalance(int[] nums) {
  int sumSideA = 0;
  
  for (int i = 0; i < nums.length; ++i) {
    sumSideA += nums[i];
    
    int sumSideB = 0;
    for (int j = i+1; j < nums.length; ++j) {
      sumSideB += nums[j];
    }
    
    if (sumSideA == sumSideB) {
      return true;
    }
  }
  
  return false;
}

// Recursive solution (for fun)

/*
public boolean canBalance(int[] nums) {
  return canBalance(nums, 0, 0);
}

public boolean canBalance(int[] nums, int sumSideA, int i) {
  if (i == nums.length) {
    return false;
  }
  
  sumSideA += nums[i];
  int sumSideB = getSumSideB(nums, i+1);
  
  if (sumSideA == sumSideB) {
    return true;
  }
  
  return canBalance(nums, sumSideA, i+1);
}

public int getSumSideB(int[] nums, int j) {
  if (j == nums.length) {
    return 0;
  }
  
  return nums[j] + getSumSideB(nums, j+1);
}
*/
