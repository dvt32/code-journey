# http://codingbat.com/prob/p189441

def not_string(str):
  if str.startswith("not"):
    return str
  else:
    return "not " + str
