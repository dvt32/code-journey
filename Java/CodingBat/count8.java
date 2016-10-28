// http://codingbat.com/prob/p192383

public int count8(int n) {
  if (n == 0) {
    return 0;
  }
  
  if (n % 10 == 8 && (n / 10) % 10 == 8) {
    return count8(n / 10) + 2;
  }
  else if (n % 10 == 8) {
    return count8(n / 10) + 1;
  }
  else {
    return count8(n / 10);
  }
}
