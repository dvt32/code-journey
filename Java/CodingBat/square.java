// http://codingbat.com/prob/p139586

public List<Integer> square(List<Integer> nums) {
  nums = nums.stream()
    .map(n -> n * n)
    .collect(Collectors.toList());
  
  return nums;
}
