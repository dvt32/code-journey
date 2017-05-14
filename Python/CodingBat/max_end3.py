# http://codingbat.com/prob/p135290

def max_end3(nums):
  max = nums[0] if (nums[0] > nums[-1]) else nums[-1] # or use max(arg1, arg2)
  for i in range(3):
    nums[i] = max
  return nums
