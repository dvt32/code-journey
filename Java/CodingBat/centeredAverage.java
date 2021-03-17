// http://codingbat.com/prob/p136585

public int centeredAverage(int[] nums) {
  int min = nums[0];
  int max = nums[0];
  int minIndex = 0;
  int maxIndex = 0;
  int sum = 0;
  int numbersCount = 0;
  
  for (int i = 0; i < nums.length; ++i) {
    if (nums[i] > max) {
      max = nums[i];
      maxIndex = i;
    }
    else if (nums[i] < min) {
      min = nums[i];
      minIndex = i;
    }
  }
  
  for (int i = 0; i < nums.length; ++i) {
    if (i != maxIndex && i != minIndex) {
      sum += nums[i];
      numbersCount++;
    }
  } 
  
  int centeredAverage = sum / numbersCount;
  return centeredAverage;
}

// Recursive solution (for fun)
// TODO: Refactor recursive method to use less parameters

/*
public int centeredAverage(int[] nums) {
  int min = nums[0];
  int max = nums[0];
  int minIndex = 0;
  int maxIndex = 0;
  int sum = 0;
  int numbersCount = 0;
  return centeredAverage(nums, min, max, minIndex, maxIndex, sum, numbersCount, 0, 0);
}

public int centeredAverage(
  int[] nums,
  int min,
  int max,
  int minIndex,
  int maxIndex,
  int sum,
  int numbersCount,
  int i,
  int j)
{
  if (i < nums.length) {
    if (nums[i] > max) {
      max = nums[i];
      maxIndex = i;
    }
    else if (nums[i] < min) {
      min = nums[i];
      minIndex = i;
    }
    return centeredAverage(nums, min, max, minIndex, maxIndex, sum, numbersCount, i+1, j);
  }
  
  if (j < nums.length) {
    if (j != maxIndex && j != minIndex) {
      sum += nums[j];
      numbersCount++;
    }
    return centeredAverage(nums, min, max, minIndex, maxIndex, sum, numbersCount, i, j+1);
  }
  
  int centeredAverage = sum / numbersCount;
  return centeredAverage;
}
*/
