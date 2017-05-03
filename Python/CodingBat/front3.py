# http://codingbat.com/prob/p147920

def front3(str):
  if len(str) < 3:
    front = str
  else:
    front = str[0:3]
    
  return front + front + front
