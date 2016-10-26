// http://codingbat.com/prob/p191914

public String notString(String str) {
  if (str.length() >= 3 && str.substring(0, 3).equals("not")) {
    return str;
  }
  else {
    return "not " + str;
  }
}
