// http://codingbat.com/prob/p136417

public boolean prefixAgain(String str, int n) {
  String prefix = str.substring(0, n);
  if (str.lastIndexOf(prefix) != -1 && str.lastIndexOf(prefix) != 0) {
    return true;
  }
  else {
    return false;
  }
}
