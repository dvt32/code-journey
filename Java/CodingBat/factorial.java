// http://codingbat.com/prob/p154669

public int factorial(int n) {
  if (n == 1) {
    return 1;
  }
  else {
    return factorial(n-1) * n;
  }
}
