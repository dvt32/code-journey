// http://codingbat.com/prob/p127384

public int sum13(int[] nums) {
  if (nums.length == 0) {
    return 0;
  }
  else {
    int sum = 0;
    for (int i = 0; i < nums.length;) {
      if (nums[i] == 13) {
        i += 2;
      }
      else {
        sum += nums[i];
        ++i;
      }
    }
    return sum;
  }
}
