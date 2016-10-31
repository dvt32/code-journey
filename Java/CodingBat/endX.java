// http://codingbat.com/prob/p105722

public String endX(String str) {
  if (str.length() <= 1) {
    return str;
  }
  
  if (str.charAt(0) == 'x') {
    return endX(str.substring(1)) + str.charAt(0);
  }
  else {
    return str.charAt(0) + endX(str.substring(1));
  }
}
