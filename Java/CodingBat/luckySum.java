// http://codingbat.com/prob/p130788

public int luckySum(int a, int b, int c) {
  int[] elements = new int[] { a, b, c };
  int sum = 0;
  
  for (int i = 0; i < elements.length; ++i) {
    if (elements[i] == 13) {
      return sum;
    }
    else {
      sum += elements[i];
    }
  }
  
  return sum;
}
