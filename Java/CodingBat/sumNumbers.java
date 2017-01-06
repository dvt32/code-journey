// http://codingbat.com/prob/p121193

public int sumNumbers(String str) {
  int sum = 0;
  
  StringBuilder currentNumber = new StringBuilder();
  for (int i = 0; i < str.length(); ++i) {
    if (Character.isDigit(str.charAt(i))) {
      currentNumber.append(str.charAt(i));
    }
    else if (currentNumber.length() > 0) {
      sum += Integer.parseInt(currentNumber.toString());
      currentNumber.setLength(0);
    }
  }
  
  if (currentNumber.length() > 0) {
      sum += Integer.parseInt(currentNumber.toString());
  }
  
  return sum;
}
