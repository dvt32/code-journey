# http://codingbat.com/prob/p174314

def end_other(a, b):
  a = a.lower()
  b = b.lower()
  
  return ( a.endswith(b) or b.endswith(a) )
