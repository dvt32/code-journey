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

// Recursive solution (for fun)

/*
public int[] seriesUp(int n) {
  int[] arr = new int[n*(n+1)/2];
  return seriesUp(arr, 1, 0);
}

public int[] seriesUp(int[] arr, int numberOfValuesToInsert, int i) {
  if (i == arr.length) {
    return arr;
  }
  
  int valueToInsert = 1;
  int numberOfInsertedValues = 0;
  int j = i;
  
  modifyArr(arr, valueToInsert, numberOfInsertedValues, numberOfValuesToInsert, j);
  
  numberOfValuesToInsert++;
  i += numberOfValuesToInsert-1;
  
  return seriesUp(arr, numberOfValuesToInsert, i);
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
    ++j;
    modifyArr(arr, valueToInsert, numberOfInsertedValues, numberOfValuesToInsert, j);
  }
}
*/

// Alternative recursive solution

/*
public int[] seriesUp(int n) {
  int[] arr = new int[n*(n+1)/2];
  return seriesUp(arr, 1, 0);
}

public int[] seriesUp(int[] arr, int numberOfValuesToInsert, int i) {
  if (i == arr.length) {
    return arr;
  }
  
  int valueToInsert = 1;
  int numberOfInsertedValues = 0;

  for (int j = i; numberOfInsertedValues != numberOfValuesToInsert; ++j) {
    arr[j] = valueToInsert;
    valueToInsert++;
    numberOfInsertedValues++;
  }
  
  numberOfValuesToInsert++;
  i += numberOfValuesToInsert-1;
  
  return seriesUp(arr, numberOfValuesToInsert, i);
}
*/
