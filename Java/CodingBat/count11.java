// http://codingbat.com/prob/p167015

public int count11(String str) {
  if (str.length() <= 1) {
    return 0;
  }
  
  if (str.substring(0,2).equals("11")) {
    return count11(str.substring(2)) + 1;
  }
  else {
    return count11(str.substring(1));
  }
}
