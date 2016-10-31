// http://codingbat.com/prob/p183394

public String allStar(String str) {
  if (str.length() == 0) {
    return "";
  }
  
  if (str.length() == 1) {
    return str;
  }
  else {
    return str.substring(0, 1) + "*" + allStar(str.substring(1));
  }
}
