// http://codingbat.com/prob/p165666

public String stringBits(String str) {
  StringBuilder output = new StringBuilder();
  for (int i = 0; i < str.length(); ++i) {
    if (i % 2 == 0) {
      output.append(str.charAt(i));
    }
  }
  return output.toString();
}
