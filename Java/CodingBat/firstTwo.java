// http://codingbat.com/prob/p163411

public String firstTwo(String str) {
  if (str.length() < 2) {
    return str;
  }
  else {
    return str.substring(0, 2);
  }
}
