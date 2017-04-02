// http://codingbat.com/prob/p177528

public List<String> moreY(List<String> strings) {
  strings = strings.stream()
   .map(string -> "y" + string + "y")
   .collect(Collectors.toList());
   
  return strings;
}
