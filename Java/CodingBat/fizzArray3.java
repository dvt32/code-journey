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
