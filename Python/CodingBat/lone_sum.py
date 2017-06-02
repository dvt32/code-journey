# http://codingbat.com/prob/p143951

def lone_sum(a, b, c):
  sum = 0
  
  if a != b and a != c:
    sum += a
  
  if b != a and b != c:
    sum += b
    
  if c != a and c != b:
    sum += c
    
  return sum
