// http://codingbat.com/prob/p181634

public List<String> copies3(List<String> strings) {
  strings = strings.stream()
   .map(string -> string + string + string)
   .collect(Collectors.toList());
   
  return strings;
}
