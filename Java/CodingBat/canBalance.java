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
