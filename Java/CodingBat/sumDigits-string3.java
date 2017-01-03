// http://codingbat.com/prob/p197890

public int sumDigits(String str) {
  int digitSum = 0;

  for (int i = 0; i < str.length(); ++i) {
    if (Character.isDigit(str.charAt(i))) {
      digitSum += Character.getNumericValue(str.charAt(i));
    }
  }
  
  return digitSum;
}
