// http://codingbat.com/prob/p103456

public List<Integer> noNeg(List<Integer> nums) {
  nums.removeIf(n -> n < 0);
  
  return nums;
}
