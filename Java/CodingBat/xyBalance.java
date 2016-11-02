// http://codingbat.com/prob/p134250

public boolean xyBalance(String str) {
  int xLastOccurrenceIndex = str.lastIndexOf('x');
  
  if (xLastOccurrenceIndex == -1) {
    return true;
  }
  
  for (int i = xLastOccurrenceIndex+1; i < str.length(); ++i) {
    if (str.charAt(i) == 'y') {
      return true;
    }
  }
  
  return false;
}
