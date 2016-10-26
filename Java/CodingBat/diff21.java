// http://codingbat.com/prob/p116624

public int diff21(int n) {
  int difference = n - 21;
  if (n <= 21) {
    return (difference > 0) ? difference : -difference;
  }
  else {
    return (difference > 0) ? 2 * difference : 2  * (-difference);
  }
}
