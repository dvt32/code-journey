// http://codingbat.com/prob/p104627

public boolean more14(int[] nums) {
  int onesCount = 0;
  int foursCount = 0;
  
  for (int num : nums) {
    if (num == 1) {
      onesCount++;
    }
    else if (num == 4) {
      foursCount++;
    }
  }
  
  return (onesCount > foursCount);
}
