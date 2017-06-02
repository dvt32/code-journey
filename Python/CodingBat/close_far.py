# http://codingbat.com/prob/p160533

def close_far(a, b, c):
  ab_diff = abs(a-b)
  ac_diff = abs(a-c)
  bc_diff = abs(b-c)
  
  if ab_diff <= 1:
    if bc_diff >= 2 and ac_diff >= 2:
      return True
    
  if ac_diff <= 1:
    if bc_diff >= 2 and ab_diff >= 2:
      return True
  
  return False
