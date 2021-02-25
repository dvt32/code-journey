// http://codingbat.com/prob/p191212

public boolean hasOne(int n) {
  while (n != 0) {
    int digit = n % 10;
    if (digit == 1) {
      return true;
    }
    n /= 10;
  }
  
  return false;
}

// Recursive solution (for fun)

/*
public boolean hasOne(int n) {
  if (n == 0) {
    return false;
  }
  
  int digit = n % 10;
  if (digit == 1) {
    return true;
  }
  
  return hasOne(n / 10);
}
*/
