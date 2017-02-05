// http://codingbat.com/prob/p155405

public int[] squareUp(int n) {
  int[] arr = new int[n*n];
  
  int numberOfValuesToInsert = 1;
  
  for (int i = 0; i < arr.length; i += n) {
    int valueToInsert = 1;
    int numberOfInsertedValues = 0;
    int j = (i + n) - 1; 
    
    while (numberOfInsertedValues != numberOfValuesToInsert) {
      arr[j] = valueToInsert;
      valueToInsert++;
      numberOfInsertedValues++;
      j--;
    }
    numberOfValuesToInsert++;
  }
  
  return arr;
}
