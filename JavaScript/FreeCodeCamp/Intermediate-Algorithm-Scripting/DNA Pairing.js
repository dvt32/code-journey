// https://www.freecodecamp.com/challenges/dna-pairing

function pairElement(str) {
  var paired = [];
  
  var find = function(char) {
    switch(char) {
      case "A":
        paired.push(["A", "T"]);
        break;
      case "T":
        paired.push(["T", "A"]);
        break;
      case "C":
        paired.push(["C", "G"]);
        break;
      case "G":
        paired.push(["G", "C"]);
        break;
      default: break;   
    }
  };
  
  for (var i = 0; i < str.length; ++i) {
       find(str.charAt(i));
  }
  
  return paired;
}
