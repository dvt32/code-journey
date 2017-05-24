# http://codingbat.com/prob/p126968

def centered_average(nums):
  max_ignored = False
  min_ignored = False
  
  max_num = max(nums)
  min_num = min(nums)
  
  sum = 0
  count = 0
  
  for num in nums:
    if num == max_num and max_ignored == False:
      max_ignored = True
    elif num == min_num and min_ignored == False:
      min_ignored = True
    else:
      sum += num
      count += 1
      
  return (sum / count)
