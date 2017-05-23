# http://codingbat.com/prob/p108886

def sum67(nums):
  sum = 0
  
  i = 0
  while i < len(nums):
    if nums[i] == 6:
      while nums[i] != 7:
        i += 1
    else:
      sum += nums[i]
    i += 1
  
  return sum
