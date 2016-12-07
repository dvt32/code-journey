// http://codingbat.com/prob/p186753

public int roundSum(int a, int b, int c) {
  return round10(a) + round10(b) + round10(c);
}

public int round10(int num) {
  int rightMostDigit = num % 10;
  return (rightMostDigit >= 5) ? (num + (10 - rightMostDigit)) : (num - rightMostDigit);
}
