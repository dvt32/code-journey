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

// Recursive solution (for fun)

/*
public boolean dividesSelf(int n) {
  if (n == 0) {
    return true;
  }
  
  return dividesSelf(n, n); 
}

public boolean dividesSelf(int n, int n_copy) {
  if (n_copy == 0) {
    return true;
  }
  
  int digit = n_copy % 10;
  if ((digit == 0) || (n % digit != 0)) {
    return false;
  }
  
  return dividesSelf(n, n_copy / 10);
}
*/
