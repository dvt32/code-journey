// http://codingbat.com/prob/p115967

public List<String> noYY(List<String> strings) {
  strings = strings.stream()
    .map(string -> string + "y")
    .filter(string -> !string.contains("yy"))
    .collect(Collectors.toList());
    
  return strings;
}
