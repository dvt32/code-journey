// http://codingbat.com/prob/p131516

public String sameEnds(String string) {
  String result = "";
  
  for (int i = 0; i < (string.length() / 2) + 1; ++i) {
    if (string.substring(0, i).equals(string.substring(string.length()-i))) {
      result = string.substring(0, i);
    }
  }
  
  return result;
}
