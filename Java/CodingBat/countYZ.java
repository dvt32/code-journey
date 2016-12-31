// http://codingbat.com/prob/p199171

public int countYZ(String str) {
  int count = 0;
  
  str = str.toLowerCase();
  int yIndex = str.indexOf('y');
  int zIndex = str.indexOf('z');
  
  while (yIndex >= 0) {
    if (yIndex+1 == str.length() || 
        ( yIndex+1 < str.length() && !Character.isLetter(str.charAt(yIndex+1))) ) 
    {
      count++;
    }
    yIndex = str.indexOf('y', yIndex + 1);
  }
  
  while (zIndex >= 0) {
    if (zIndex+1 == str.length() || 
        ( zIndex+1 < str.length() && !Character.isLetter(str.charAt(zIndex+1))) ) 
    {
      count++;
    }
    zIndex = str.indexOf('z', zIndex + 1);
  }
  
  return count;
}
