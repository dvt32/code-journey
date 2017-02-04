// http://codingbat.com/prob/p134022

public boolean linearIn(int[] outer, int[] inner) {
  if (inner.length == 0) {
    return true;
  }
  
  int foundElementsCount = 0;
  int j = 0;
  
  for (int i = 0; i < outer.length; ++i) {
    if (outer[i] == inner[j]) {
      foundElementsCount++;
      j++;
    }
    else if (outer[i] > inner[j]) {
      return false;
    }
    
    if (foundElementsCount == inner.length) {
      return true;
    }
  }
  
  return false;
}
