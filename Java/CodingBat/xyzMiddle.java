// http://codingbat.com/prob/p159772

public boolean xyzMiddle(String str) {
  if (!str.contains("xyz")) {
    return false;
  }

  for (int xyzIndex = str.indexOf("xyz"); 
       xyzIndex >= 0; 
       xyzIndex = str.indexOf("xyz", xyzIndex + 3)) 
  {
    int leftSubstringLength = str.substring(0, xyzIndex).length();
    int rightSubstringLength = str.substring(xyzIndex + 3).length();
    boolean isInMiddle = (Math.abs(leftSubstringLength - rightSubstringLength) <= 1);
    if (isInMiddle) {
      return true;
    }
  }
  
  return false;
}
