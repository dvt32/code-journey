// http://codingbat.com/prob/p137729

public String middleTwo(String str) {
  if (str.length() <= 2) {
    return str;
  }
  else {
    return str.substring( (str.length() / 2) - 1, (str.length() / 2) + 1 );
  }
}
