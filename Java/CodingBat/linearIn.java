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

// Recursive solution (for fun)

/*
public boolean linearIn(int[] outer, int[] inner) {
  if (inner.length == 0) {
    return true;
  }
  
  int foundElementsCount = 0;
  int i = 0;
  int j = 0;
  
  return linearIn(outer, inner, foundElementsCount, i, j);
}

public boolean linearIn(int[] outer, int[] inner, int foundElementsCount, int i, int j) {
  if (i == outer.length) {
    return false;
  }
  
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
  
  return linearIn(outer, inner, foundElementsCount, i+1, j);
}
*/

// Alternative shorter recursive solution

/*
public boolean linearIn(int[] outer, int[] inner) {
  if (inner.length == 0) {
    return true;
  }
  
  int foundElementsCount = 0;
  int i = 0;
  int j = 0;
  
  return linearIn(outer, inner, foundElementsCount, i, j);
}

public boolean linearIn(int[] outer, int[] inner, int foundElementsCount, int i, int j) {
  if (i == outer.length || outer[i] > inner[j]) {
    return false;
  }
  
  if (outer[i] == inner[j]) {
    foundElementsCount++;
    j++;
    if (foundElementsCount == inner.length) {
      return true;
    }
  }
  
  return linearIn(outer, inner, foundElementsCount, i+1, j);
}
*/
