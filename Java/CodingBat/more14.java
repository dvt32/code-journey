// http://codingbat.com/prob/p104627

public boolean more14(int[] nums) {
  int onesCount = 0;
  int foursCount = 0;
  
  for (int num : nums) {
    if (num == 1) {
      onesCount++;
    }
    else if (num == 4) {
      foursCount++;
    }
  }
  
  return (onesCount > foursCount);
}

// Recursive solution (for fun)

/*
public boolean more14(int[] nums) {
  return more14(nums, 0, 0, 0);
}

public boolean more14(int[] nums, int onesCount, int foursCount, int i) {
  if (i == nums.length) {
    return (onesCount > foursCount);
  }
  
  if (nums[i] == 1) {
    onesCount++;
  }
  else if (nums[i] == 4) {
    foursCount++;
  }
  
  return more14(nums, onesCount, foursCount, i+1);
}
*/
