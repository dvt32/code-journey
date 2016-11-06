// http://codingbat.com/prob/p101475

public String frontTimes(String str, int n) {
  String front = (str.length() < 3) ? str : str.substring(0, 3);
  StringBuilder output = new StringBuilder();
  for (int i = 0; i < n; ++i) {
    output.append(front);
  }
  return output.toString();
}
