# http://codingbat.com/prob/p166170

def array_count9(nums):
  count = 0
  
  for num in nums:
    if num == 9:
      count += 1
      
  return count
