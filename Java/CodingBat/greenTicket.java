// http://codingbat.com/prob/p120633

public int greenTicket(int a, int b, int c) {
  if (a != b && b != c && a != c) {
    return 0;
  }
  else if (a == b && b == c && a == c) {
    return 20;
  }
  else if (a == b || b == c || a == c)  {
    return 10;
  }
  
  return -1;
}
