// http://codingbat.com/prob/p128796

public String repeatFront(String str, int n) {
  StringBuilder output = new StringBuilder();
  while (n >= 0) {
    output.append(str.substring(0, n));
    n--;
  }
  return output.toString();
}
