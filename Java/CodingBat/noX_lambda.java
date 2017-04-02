// http://codingbat.com/prob/p105967

public List<String> noX(List<String> strings) {
  strings.replaceAll(
    string -> string.replaceAll("x", "")
  );
  
  return strings;
}
