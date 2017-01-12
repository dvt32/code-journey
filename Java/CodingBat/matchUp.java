// http://codingbat.com/prob/p139677

public int matchUp(String[] a, String[] b) {
  int validStringCount = 0;
  
  for (int i = 0; i < a.length; ++i) {
    if (!a[i].isEmpty() && !b[i].isEmpty() && a[i].charAt(0) == b[i].charAt(0)) {
      validStringCount++;
    }
  }
  
  return validStringCount;
}
