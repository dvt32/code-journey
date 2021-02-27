// http://codingbat.com/prob/p178353

public String[] fizzArray2(int n) {
  String[] arr = new String[n];
  
  for (int i = 0; i < arr.length; ++i) {
    arr[i] = String.valueOf(i);
  }
  
  return arr;
}

// Recursive solution (for fun)

/*
public String[] fizzArray2(int n) {
  String[] arr = new String[n];
  return fizzArray2(arr, n);
}

public String[] fizzArray2(String[] arr, int n) {
  if (n == 0) {
    return arr;
  }
  
  arr[n-1] = String.valueOf(n-1);
  
  return fizzArray2(arr, n-1);
}
*/
