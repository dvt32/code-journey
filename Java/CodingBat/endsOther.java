// http://codingbat.com/prob/p126880

public boolean endOther(String a, String b) {
  a = a.toLowerCase();
  b = b.toLowerCase();
  return (a.endsWith(b) || b.endsWith(a));
}
