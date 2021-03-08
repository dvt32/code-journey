// http://codingbat.com/prob/p159979

public boolean modThree(int[] nums) {
  int consecutiveEvenNumberCount = 0;
  int consecutiveOddNumberCount = 0;
  
  for (int i = 0; i < nums.length; ++i) {
    if (nums[i] % 2 == 0) {
      consecutiveOddNumberCount = 0;
      consecutiveEvenNumberCount++;
    }
    else {
      consecutiveEvenNumberCount = 0;
      consecutiveOddNumberCount++;
    }
    
    if (consecutiveEvenNumberCount == 3 || consecutiveOddNumberCount == 3) {
      return true;
    }
  }
  
  return false;
}

// Recursive solution (for fun)

/*
public boolean modThree(int[] nums) {
  return modThree(nums, 0, 0, 0);
}

public boolean modThree(
  int[] nums, 
  int consecutiveEvenNumberCount, 
  int consecutiveOddNumberCount, 
  int i) 
{
  if (i == nums.length) {
    return false;
  }
  
  if (nums[i] % 2 == 0) {
    consecutiveOddNumberCount = 0;
    consecutiveEvenNumberCount++;
  }
  else {
    consecutiveEvenNumberCount = 0;
    consecutiveOddNumberCount++;
  }
  
  if (consecutiveEvenNumberCount == 3 || consecutiveOddNumberCount == 3) {
    return true;
  }
  
  return modThree(nums, consecutiveEvenNumberCount, consecutiveOddNumberCount, i+1);
}
*/
