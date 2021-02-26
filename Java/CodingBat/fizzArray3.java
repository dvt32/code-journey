// http://codingbat.com/prob/p142539

public int[] fizzArray3(int start, int end) {
  int newArrLength = end - start;
  int[] newArr = new int[newArrLength];
  
  int numberToAdd = start;
  for (int i = 0; i < newArrLength; ++i) {
    newArr[i] = numberToAdd;
    numberToAdd++;
  }
  
  return newArr;
}

// Recursive solution (for fun)

/*
public int[] fizzArray3(int start, int end) {
  int[] newArr = new int[end - start];
  int numberToAdd = start;
  return fizzArray3(newArr, numberToAdd, 0);
}

public int[] fizzArray3(int[] newArr, int numberToAdd, int i) {
  if (i == newArr.length) {
    return newArr;
  }
  
  newArr[i] = numberToAdd;
  numberToAdd++;
  
  return fizzArray3(newArr, numberToAdd, i+1);
}
*/
