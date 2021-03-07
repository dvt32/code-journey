// http://codingbat.com/prob/p100369

public int commonTwo(String[] a, String[] b) {
  int stringCount = 0;
  
  String lastChecked = null;
  
  for (int i = 0; i < a.length; ++i) {
    if (!a[i].equals(lastChecked)) {
      for (int j = 0; j < b.length; ++j) {
        if (a[i].equals(b[j])) {
          stringCount++;
          lastChecked = a[i];
          break;
        }
      }
    }
  }
  
  return stringCount;
}

// Recursive solution (for fun)

/*
public int commonTwo(String[] a, String[] b) {
  return commonTwo(a, b, null, 0, 0);
}

public int commonTwo(String[] a, String[] b, String lastChecked, int i, int j) {
  if (i == a.length) {
    return 0;
  }

  if (!a[i].equals(lastChecked) && j < b.length) {
    if (a[i].equals(b[j])) {
      lastChecked = a[i];
      return 1 + commonTwo(a, b, lastChecked, i+1, 0);
    }
    else {
      return commonTwo(a, b, lastChecked, i, j+1);
    }
  }
  
  return commonTwo(a, b, lastChecked, i+1, 0);
}
*/
