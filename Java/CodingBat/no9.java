// http://codingbat.com/prob/p124510

public List<Integer> no9(List<Integer> nums) {
  nums = nums.stream()
    .filter(n -> n % 10 != 9) // boolean logic of filter() is opposite of removeIf()'s
    .collect(Collectors.toList());
    
  return nums;
}
