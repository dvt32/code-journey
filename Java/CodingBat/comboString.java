// http://codingbat.com/prob/p168564

public String comboString(String a, String b) {
  if (a.length() < b.length()) {
    return a + b + a;
  }
  else if (b.length() < a.length()) {
    return b + a + b;
  }
  else return "";
}
