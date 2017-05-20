# http://codingbat.com/prob/p119867

def alarm_clock(day, vacation):
  is_weekday = ( day in range(1, 6) )
  
  if vacation:
    if is_weekday:
      return "10:00"
    else:
      return "off"
  else:
    if is_weekday:
      return "7:00"
    else:
      return "10:00"
