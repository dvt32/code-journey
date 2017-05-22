# http://codingbat.com/prob/p184853

def big_diff(nums):
  max_num = nums[0]
  min_num = nums[0]
  
  for num in nums:
    max_num = max(num, max_num)
    min_num = min(num, min_num)
    
  return abs(max_num - min_num)
