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

// Recursive solution (for fun)

/*
public int maxSpan(int[] nums) {
  int maxSpan = 0;
  return maxSpan(nums, 0, 0, nums.length-1);
}

public int maxSpan(int[] nums, int maxSpan, int i, int j) {
  if (i == nums.length) {
    return maxSpan;
  }
  
  if (nums[i] != nums[j]) {
    return maxSpan(nums, maxSpan, i, j-1);
  }
  
  int span = calcSpanLength(i, j);
  if (span > maxSpan) {
    maxSpan = span;
  }
  
  return maxSpan(nums, maxSpan, i+1, nums.length-1);
}

public int calcSpanLength(int spanStartIndex, int j) {
  if (spanStartIndex > j) {
    return 0;
  }
  
  return 1 + calcSpanLength(spanStartIndex+1, j);
}
*/
