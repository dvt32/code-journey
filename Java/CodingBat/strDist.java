// http://codingbat.com/prob/p195413

public int strDist(String str, String sub) {
  if (str.length() == 0) {
    return 0;
  }
  
  if (str.startsWith(sub)) {
    return str.substring(
      str.indexOf(sub), 
      str.lastIndexOf(sub)+sub.length()
    ).length();
  }
  else {
    return strDist(str.substring(1), sub);
  }
}
