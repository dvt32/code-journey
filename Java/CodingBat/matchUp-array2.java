// http://codingbat.com/prob/p136254

public int matchUp(int[] nums1, int[] nums2) {
  int count = 0;
  
  for (int i = 0; i < nums1.length; ++i) {
    int difference = Math.abs(nums1[i] - nums2[i]);
    if (difference != 0 && difference <= 2) {
      count++;
    }
  }
  
  return count;
}

// Recursive solution (for fun)

/*
public int matchUp(int[] nums1, int[] nums2) {
  return matchUp(nums1, nums2, 0);
}

public int matchUp(int[] nums1, int[] nums2, int i) {
  if (i == nums1.length) {
    return 0;
  }
  
  int difference = Math.abs(nums1[i] - nums2[i]);
  if (difference != 0 && difference <= 2) {
    return 1 + matchUp(nums1, nums2, i+1);
  }
  
  return matchUp(nums1, nums2, i+1);
}
*/
