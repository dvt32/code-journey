// http://codingbat.com/prob/p153748

public boolean shareDigit(int a, int b) {
  int aLeftDigit = a / 10;
  int aRightDigit = a % 10;
  int bLeftDigit = b / 10;
  int bRightDigit = b % 10;
  
  return (aLeftDigit == bLeftDigit || aLeftDigit == bRightDigit || aRightDigit == bLeftDigit || aRightDigit == bRightDigit);
}
