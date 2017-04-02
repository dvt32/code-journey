// http://codingbat.com/prob/p103869

public List<Integer> math1(List<Integer> nums) {
  nums = nums.stream()
   .map(num -> 1+num)
   .map(num -> num*10)
   .collect(Collectors.toList());
   
  return nums;
}
