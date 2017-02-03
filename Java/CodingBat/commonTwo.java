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
