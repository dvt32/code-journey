// http://codingbat.com/prob/p110019

public int array667(int[] nums) {
  int numberCount = 0;
  for (int i = 0; i < nums.length-1; ++i) {
    if (nums[i] == 6 && nums[i+1] == 6) {
      numberCount++;
    }
    else if (nums[i] == 6 && nums[i+1] == 7) {
      numberCount++;
    }
  }
  return numberCount;
}
