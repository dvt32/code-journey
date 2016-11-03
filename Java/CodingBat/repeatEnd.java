// http://codingbat.com/prob/p152339

public String repeatEnd(String str, int n) {
  StringBuilder output = new StringBuilder();
  for (int i = 0; i < n; ++i) {
    output.append(str.substring(str.length()-n));
  }
  return output.toString();
}
