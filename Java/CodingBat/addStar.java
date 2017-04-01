// http://codingbat.com/prob/p170181

public List<String> addStar(List<String> strings) {
  strings.replaceAll(n -> n + "*");
  
  return strings;
}
