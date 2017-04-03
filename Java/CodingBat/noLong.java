// http://codingbat.com/prob/p194496

public List<String> noLong(List<String> strings) {
  strings = strings.stream()
    .filter(string -> string.length() < 4)
    .collect(Collectors.toList());
    
  return strings;
}
