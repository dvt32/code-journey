// http://codingbat.com/prob/p143900

public int countHi2(String str) {
  if (str.length() < 2) {
    return 0;
  }
  
  if (str.substring(0, 2).equals("xh")) {
    return countHi2(str.substring(2));
  }
  else if (str.substring(0, 2).equals("hi")) {
    return countHi2(str.substring(2)) + 1;
  }
  else {
    return countHi2(str.substring(1));
  }
}
