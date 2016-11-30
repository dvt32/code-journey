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
