// http://codingbat.com/prob/p123614

public int countCode(String str) {
  int numberOfValidCodeInstances = 0;
  for (int i = 0; i < str.length()-3; ++i) {
    if (str.substring(i, i+2).equals("co") && str.charAt(i+3) == 'e') {
      numberOfValidCodeInstances++;
    }
  }
  return numberOfValidCodeInstances;
}
