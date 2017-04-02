// http://codingbat.com/prob/p186894

public List<String> lower(List<String> strings) {
  strings = strings.stream()
    .map(string -> string.toLowerCase())
    .collect(Collectors.toList());
    
  return strings;
}
