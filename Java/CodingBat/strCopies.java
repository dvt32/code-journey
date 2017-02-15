// http://codingbat.com/prob/p118182

public boolean strCopies(String str, String sub, int n) {
  if (n == 0) {
    return true;
  }
  
  if (str.indexOf(sub) != -1) {
    return strCopies(str.substring(str.indexOf(sub) + 1), sub, n-1);
  }
  else {
    return false;
  }
}
