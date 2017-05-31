# http://codingbat.com/prob/p107863

def lucky_sum(a, b, c):
  numbers = [a, b, c]
  lucky_sum = 0
  
  for number in numbers:
    if number == 13:
      break
    else:
      lucky_sum += number
      
  return lucky_sum
