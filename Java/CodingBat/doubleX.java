// http://codingbat.com/prob/p186759

boolean doubleX(String str) {
  return (str.indexOf('x') != -1 &&
          str.indexOf('x') <  str.length()-1 &&
          str.charAt(str.indexOf('x')+1) == 'x');
}
