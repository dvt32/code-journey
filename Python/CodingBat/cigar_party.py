# http://codingbat.com/prob/p195669

def cigar_party(cigars, is_weekend):
  if is_weekend and cigars >= 40:
    return True
  elif not is_weekend and (cigars >= 40 and cigars <= 60):
    return True
  else:
    return False
