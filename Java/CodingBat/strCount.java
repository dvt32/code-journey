// http://codingbat.com/prob/p186177

public int strCount(String str, String sub) {
  if (str.indexOf(sub) != -1) {
    return 
      strCount(
        str.substring( str.indexOf(sub) + sub.length() ), sub 
      ) + 1;
  }
  else {
    return 0;
  }
}
