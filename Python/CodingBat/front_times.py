# http://codingbat.com/prob/p165097

def front_times(str, n):
  result = ""
  
  for i in range(n):
    if len(str) < 3:
      result += str
    else:
      result += str[0:3]
  
  return result
