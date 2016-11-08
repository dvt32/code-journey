// http://codingbat.com/prob/p198640

public int stringMatch(String a, String b) {
  int numberOfValidPositions = 0;
  for (int i = 0; i < a.length()-1 && i < b.length()-1; ++i) {
    if (a.substring(i, i+2).equals(b.substring(i, i+2))) {
      numberOfValidPositions++;
    }
  }
  return numberOfValidPositions;
}
