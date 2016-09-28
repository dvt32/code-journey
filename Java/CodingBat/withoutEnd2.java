// http://codingbat.com/prob/p174254

public String withouEnd2(String str) {
  if (str.length() <= 2) {
    return "";
  }
  else {
    return str.substring(1, str.length()-1);
  }
}
