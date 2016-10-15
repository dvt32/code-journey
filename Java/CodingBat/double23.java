// http://codingbat.com/prob/p145365

public boolean double23(int[] nums) {
  int numberOfTwos = 0;
  int numberOfThrees = 0;
  for (int i = 0; i < nums.length; ++i) {
    if (nums[i] == 2) {
      numberOfTwos++;
    }
    else if (nums[i] == 3) {
      numberOfThrees++;
    }
  }
  return (numberOfTwos == 2 || numberOfThrees == 2);
}
