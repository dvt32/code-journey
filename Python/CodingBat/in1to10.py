# http://codingbat.com/prob/p158497

def in1to10(n, outside_mode):
  if outside_mode:
    return (n <= 1 or n >= 10)
  else:
    return (n in range(1, 11))
