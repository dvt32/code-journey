// http://codingbat.com/prob/p109637

public String repeatSeparator(String word, String sep, int count) {
  StringBuilder output = new StringBuilder();
  for (int i = 0, j = count; i < count; ++i, --j) {
    output.append(word);
    if (j - 1 > 0) {
      output.append(sep);
    }
  }
  return output.toString();
}
