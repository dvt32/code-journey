# http://codingbat.com/prob/p167246

def count_hi(str):
  hi_count = 0
  
  for i in range(len(str)-1):
    if (str[i:i+2] == "hi"):
      hi_count += 1
  
  return hi_count
