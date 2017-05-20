# http://codingbat.com/prob/p116620

def sorta_sum(a, b):
  sum = a + b
  return sum if sum not in range(10, 20) else 20
