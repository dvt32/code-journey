# http://codingbat.com/prob/p170842

def double_char(str):
  new_str = ""
  
  for char in str:
    new_str += char + char
    
  return new_str
