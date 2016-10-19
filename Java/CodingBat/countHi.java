// http://codingbat.com/prob/p147448

public int countHi(String str) {
  int numberOfHellos = 0;
  for (int i = 0; i < str.length()-1; ++i) {
    if (str.substring(i, i+2).equals("hi")) {
      numberOfHellos++;
    }
  }
  return numberOfHellos;
}
