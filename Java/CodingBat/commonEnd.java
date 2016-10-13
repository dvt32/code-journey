// http://codingbat.com/prob/p191991

public boolean commonEnd(int[] a, int[] b) {
  if (a.length == 1 || b.length == 1) {
    return (a[0] == b[0]);
  }
  else if (a.length > 1 || b.length > 1) {
    return (a[0] == b[0] || a[a.length-1] == b[b.length-1]);
  }
  else {
    return false;
  }
}
