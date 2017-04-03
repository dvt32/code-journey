// http://codingbat.com/prob/p105671

public List<String> noZ(List<String> strings) {
  strings.removeIf(string -> string.contains("z"));
  
  return strings;
}
