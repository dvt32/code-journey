# http://codingbat.com/prob/p118366

def string_splosion(str):
  result = ""
  
  for i in range( len(str) ):
    result += str[:i+1]
    
  return result
