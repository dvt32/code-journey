// http://codingbat.com/prob/p162010

public int countEvens(int[] nums) {
  int evenNumbersCount = 0;
  for (int number : nums) {
    if (number % 2 == 0) {
      evenNumbersCount++;
    }
  }
  return evenNumbersCount;
}

// Recursive solution (for fun)

/*
public int countEvens(int[] nums) {
  if (nums.length == 0) {
      return 0;
  }

  return countEvens(nums, 0);
}

public int countEvens(int[] nums, int i) {
  if (i == nums.length-1) {
    return (nums[i] % 2 == 0) ? 1 : 0;
  }
  
  return ((nums[i] % 2 == 0) ? 1 : 0) + countEvens(nums, i+1);
}
*/
