// http://codingbat.com/prob/p132118

public String conCat(String a, String b) {
  if (a.length() == 0) {
    return b;
  }
  else if (b.length() == 0) {
    return a;
  }
  else {
    return (a.charAt(a.length()-1) == b.charAt(0)) ? a.substring(0, a.length()-1) + b : a + b;
  }
}
