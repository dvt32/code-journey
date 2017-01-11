// http://codingbat.com/prob/p165941

public boolean dividesSelf(int n) {
  int n_copy = n;
  while (n_copy != 0) {
    int digit = n_copy % 10;
    if ((digit == 0) || (n % digit != 0)) {
      return false;
    }
    n_copy /= 10;
  }
  
  return true;
}
