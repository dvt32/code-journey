// http://codingbat.com/prob/p192267

public int blueTicket(int a, int b, int c) {
  int ab = a + b;
  int bc = b + c;
  int ac = a + c;
  
  if (ab == 10 || bc == 10 || ac == 10) {
    return 10;
  }
  else if (Math.abs(ab-bc) >= 10 || Math.abs(ab-ac) >= 10) {
    return 5;
  }
  else {
    return 0;
  }
}
