// http://codingbat.com/prob/p189576

public int maxSpan(int[] nums) {
  int maxSpan = 0;
  
  for (int i = 0; i < nums.length; ++i) {
    int span = 1;
    int j = nums.length - 1;
    
    while (nums[i] != nums[j]) {
      j--;
    }
    
    for (int spanStartIndex = i; spanStartIndex < j; ++spanStartIndex) {
      span++;
    }
    
    if (span > maxSpan) {
      maxSpan = span;
    }
  }
  
  return maxSpan;
}
