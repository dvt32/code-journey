// http://codingbat.com/prob/p184496

public List<String> no34(List<String> strings) {
  strings = strings.stream()
    .filter(string -> string.length() != 3 && string.length() != 4)
    .collect(Collectors.toList());
    
  return strings;
}
