// http://codingbat.com/prob/p148198

public List<Integer> two2(List<Integer> nums) {
  nums.replaceAll(num -> num * 2);
  nums.removeIf(num -> num % 10 == 2);
  
  return nums;
}
