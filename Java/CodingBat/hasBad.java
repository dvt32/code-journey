// http://codingbat.com/prob/p139075

public boolean hasBad(String str) {
  if (str.length() > 2 && str.substring(0, 3).equals("bad")) {
    return true;
  }
  else if (str.length() > 3 && str.substring(1, 4).equals("bad")) {
    return true;
  }
  else {
    return false;
  }
}
