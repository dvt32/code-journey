# http://codingbat.com/prob/p197466

def diff21(n):
  if n > 21:
    return 2 * abs(n-21)
  else:
    return abs(n-21)
