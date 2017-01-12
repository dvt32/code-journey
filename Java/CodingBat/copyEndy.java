// http://codingbat.com/prob/p130124

public int[] copyEndy(int[] nums, int count) {
  int[] endies = new int[count];
  
  for (int i = 0, j = 0; i < nums.length; ++i) {
    if (count == 0) {
      break;
    }
    else if (isEndy(nums[i]))
    {
      endies[j] = nums[i];
      j++;
      count--;
    }
  }
  
  return endies;
}

public boolean isEndy(int n) {
  return ((n >= 0 && n <= 10) || (n >= 90 && n <= 100));
}
