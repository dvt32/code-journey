// http://codingbat.com/prob/p196441

public String everyNth(String str, int n) {
  StringBuilder output = new StringBuilder();
  for (int i = 0; i < str.length(); i += n) {
    output.append(str.charAt(i));
  }
  return output.toString();
}
