// http://codingbat.com/prob/p137365

public boolean in1To10(int n, boolean outsideMode) {
  if (outsideMode) {
    return (n <= 1 || n >= 10);
  }
  else {
    return (n >= 1 && n <= 10);
  }
}
