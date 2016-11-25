// http://codingbat.com/prob/p170833

public int redTicket(int a, int b, int c) {
  if (b != a && c != a) {
    return 1;
  }
  else if (a == 2 && b == 2 && c == 2) {
    return 10;
  }
  else if (a == b && b == c && a == c) {
    return 5;
  }
  else {
    return 0;
  }
}
