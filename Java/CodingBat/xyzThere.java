// http://codingbat.com/prob/p136594

public boolean xyzThere(String str) {
  int xyzIndex = str.indexOf("xyz");
  
  while (xyzIndex != -1) {
    if (xyzIndex == 0) {
      return true;
    }
    else if (str.charAt(xyzIndex-1) != '.') {
      return true;
    }
    xyzIndex = str.indexOf("xyz", xyzIndex+2);
  }
  
  return false;
}
