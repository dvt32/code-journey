// http://codingbat.com/prob/p184031

public int arrayCount9(int[] nums) {
  int numberOfNines = 0;
  for (int number : nums) {
    if (number == 9) {
      numberOfNines++;
    }
  }
  return numberOfNines;
}

// Recursive solution (for fun)

/*
public int arrayCount9(int[] nums) {
  if (nums.length == 0) {
    return 0;
  }
  
  return (nums[0] == 9 ? 1 : 0) 
    + arrayCount9( Arrays.copyOfRange(nums, 1, nums.length) );
}
*/
