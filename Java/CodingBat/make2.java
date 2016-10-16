// http://codingbat.com/prob/p143461

public int[] make2(int[] a, int[] b) {
  if (a.length == 0) { return new int[] { b[0], b[1] }; }
  if (a.length == 1) { return new int[] { a[0], b[0] }; }
  return new int[] { a[0], a[1] };
}
