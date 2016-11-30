// http://codingbat.com/prob/p178353

public String[] fizzArray2(int n) {
  String[] arr = new String[n];
  
  for (int i = 0; i < arr.length; ++i) {
    arr[i] = String.valueOf(i);
  }
  
  return arr;
}
