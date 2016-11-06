// http://codingbat.com/prob/p142270

public String stringTimes(String str, int n) {
  StringBuilder output = new StringBuilder();
  for (int i = 0; i < n; ++i) {
    output.append(str);
  }
  return output.toString();
}
