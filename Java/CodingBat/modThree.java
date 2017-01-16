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
