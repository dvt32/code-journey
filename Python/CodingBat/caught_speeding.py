# http://codingbat.com/prob/p137202

def caught_speeding(speed, is_birthday):
  BIRTHDAY_BONUS = 5
  
  if is_birthday:
    if speed <= (60 + BIRTHDAY_BONUS):
      return 0
    elif speed >= (61 + BIRTHDAY_BONUS) and speed <= (80 + BIRTHDAY_BONUS):
      return 1
    else:
      return 2
  else:
    if speed <= 60:
      return 0
    elif speed >= 61 and speed <= 80:
      return 1
    else:
      return 2
