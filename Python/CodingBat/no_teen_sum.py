# http://codingbat.com/prob/p100347

def no_teen_sum(a, b, c):
  return fix_teen(a) + fix_teen(b) + fix_teen(c)

def fix_teen(n):
  if n in range(13, 20):
    if n == 15:
      return 15
    elif n == 16:
      return 16
    else:
      return 0
  else:
    return n
