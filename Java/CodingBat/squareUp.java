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

// Recursive solution (for fun)

/*
public int[] squareUp(int n) {
  int[] arr = new int[n*n];
  int numberOfValuesToInsert = 1;
  return squareUp(arr, n, numberOfValuesToInsert, 0);
}

public int[] squareUp(int[] arr, int n, int numberOfValuesToInsert, int i) {
  if (i == arr.length) {
    return arr;
  }
  
  int valueToInsert = 1;
  int numberOfInsertedValues = 0;
  int j = (i+n)-1;
  
  modifyArr(arr, valueToInsert, numberOfInsertedValues, numberOfValuesToInsert, j);
  
  numberOfValuesToInsert++;
  
  return squareUp(arr, n, numberOfValuesToInsert, i + n);
}

public void modifyArr(
  int[] arr, 
  int valueToInsert, 
  int numberOfInsertedValues, 
  int numberOfValuesToInsert, 
  int j) 
{
  if (numberOfInsertedValues != numberOfValuesToInsert) {
    arr[j] = valueToInsert;
    valueToInsert++;
    numberOfInsertedValues++;
    --j;
    modifyArr(arr, valueToInsert, numberOfInsertedValues, numberOfValuesToInsert, j);
  }
}
*/

// Alternative recursive solution

/*
public int[] squareUp(int n) {
  int[] arr = new int[n*n];
  int numberOfValuesToInsert = 1;
  return squareUp(arr, n, numberOfValuesToInsert, 0);
}

public int[] squareUp(int[] arr, int n, int numberOfValuesToInsert, int i) {
  if (i == arr.length) {
    return arr;
  }
  
  int valueToInsert = 1;
  int numberOfInsertedValues = 0;
  
  for (int j = (i+n)-1; numberOfInsertedValues != numberOfValuesToInsert; --j) {
    arr[j] = valueToInsert;
    valueToInsert++;
    numberOfInsertedValues++;
  }
  
  numberOfValuesToInsert++;
  
  return squareUp(arr, n, numberOfValuesToInsert, i + n);
}
*/
