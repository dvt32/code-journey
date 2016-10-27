// http://codingbat.com/prob/p163932

public int sumDigits(int n) {
  if (n == 0) {
    return 0;
  }
  else {
    return sumDigits(n / 10) + (n % 10);
  }
}
