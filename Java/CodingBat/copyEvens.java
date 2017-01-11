// http://codingbat.com/prob/p134174

public int[] copyEvens(int[] nums, int count) {
  int[] newArray = new int[count];
  
  for (int i = 0, j = 0; i < nums.length; ++i) {
    if (count == 0) {
      break;
    }
    else if (nums[i] % 2 == 0) {
      newArray[j] = nums[i];
      j++;
      count--;
    }
  }
  
  return newArray;
}
