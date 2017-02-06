// http://codingbat.com/prob/p104090

public int[] seriesUp(int n) {
  int[] arr = new int[n*(n+1)/2];

  int numberOfValuesToInsert = 1;
  
  for (int i = 0; i < arr.length; i += numberOfValuesToInsert-1) {
    int valueToInsert = 1;
    int numberOfInsertedValues = 0;
    int j = i;
    
    while (numberOfInsertedValues != numberOfValuesToInsert) {
      arr[j] = valueToInsert;
      valueToInsert++;
      numberOfInsertedValues++;
      j++;
    }
    
    numberOfValuesToInsert++;
  }
  
  return arr;
}
