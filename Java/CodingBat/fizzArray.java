// http://codingbat.com/prob/p180920

public int[] fizzArray(int n) {
  int[] arr = new int[n];
  
  for (int i = 0; i < arr.length; ++i) {
    arr[i] = i;
  }
  
  return arr;
}

// Recursive solution (for fun)

/*
public int[] fizzArray(int n) {
  if (n == 0) {
    return new int[0];
  }
  
  int[] arr = new int[n];
  
  return fizzArray(arr, n, 0);
}

public int[] fizzArray(int[] arr, int n, int i) {
  arr[i] = i;
  
  if (i == n-1) {
    return arr;
  }
  
  return fizzArray(arr, n, i+1);
}
*/

// Alternative recursive solution

/*
public int[] fizzArray(int n) {
  if (n == 0) {
    return new int[0];
  }
  
  int[] arr = new int[n];
  
  return fizzArray(arr, n);
}

public int[] fizzArray(int[] arr, int n) {
  if (n == 0) {
    return arr;
  }
  
  arr[n-1] = n-1;
  
  return fizzArray(arr, n-1);
}
*/
