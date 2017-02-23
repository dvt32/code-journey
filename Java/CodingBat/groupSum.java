// http://codingbat.com/prob/p145416

public boolean groupSum(int start, int[] nums, int target) {
  if (start >= nums.length) {
    if (target == 0) {
      return true;
    }
    else {
      return false;
    }
  }
  
  // Explanation here: http://stackoverflow.com/questions/18029242/understanding-how-recursion-works-with-multiple-returns
  if ( groupSum(start+1, nums, target-nums[start]) || groupSum(start+1, nums, target) ) {
    return true;
  }
  else {
    return false;
  }
}
