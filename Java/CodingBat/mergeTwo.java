// http://codingbat.com/prob/p139150

public String[] mergeTwo(String[] a, String[] b, int n) {
  String[] arr = new String[n];

  int aIndex = 0;
  int bIndex = 0;
  
  for (int i = 0; i < n; ++i) {
    int compareResult = a[aIndex].compareTo(b[bIndex]);
    if (compareResult <= 0) {
      arr[i] = a[aIndex];
      aIndex++;
      if (compareResult == 0) {
        bIndex++;
      }
    }
    else {
      arr[i] = b[bIndex];
      bIndex++;
    }
  }
  
  return arr;
}
