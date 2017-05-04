# http://codingbat.com/prob/p110166

def array_front9(nums):
  if len(nums) >= 4:
    for i in range(4):
      if nums[i] == 9:
        return True
  else:
    for num in nums:
      if num == 9:
        return True
        
  return False
