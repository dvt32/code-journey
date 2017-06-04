# http://codingbat.com/prob/p179960

def round_sum(a, b, c):
  sum = round10(a) + round10(b) + round10(c)
  
  return sum
  
def round10(num):
  last_digit = num % 10
  
  if last_digit >= 5:
    return num + (10 - last_digit)
  else:
    return num - last_digit
