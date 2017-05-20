# http://codingbat.com/prob/p135815

def squirrel_play(temp, is_summer):
  if is_summer:
    if temp >= 60 and temp <= 100:
      return True
  else:
    if temp >= 60 and temp <= 90:
      return True
      
  return False
