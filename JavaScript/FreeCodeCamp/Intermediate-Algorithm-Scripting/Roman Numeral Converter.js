// https://www.freecodecamp.com/challenges/roman-numeral-converter

function convertToRoman(num) {
   var numString = num.toString();
   var numDigits = numString.split("");
   var outputString = "";
  
  var romanTable = {
    0: "",
    1: "I",
    2: "II",
    3: "III",
    4: "IV",
    5: "V",
    6: "VI",
    7: "VII",
    8: "VIII",
    9: "IX",
    10: "X",
    20: "XX",
    30: "XXX",
    40: "XL",
    50: "L",
    60: "LX",
    70: "LXX",
    80: "LXXX",
    90: "XC",
    100: "C",
    200: "CC",
    300: "CCC",
    400: "CD",
    500: "D",
    600: "DC",
    700: "DCC",
    800: "DCCC",
    900: "CM",
    1000: "M",
    2000: "MM",
    3000: "MMM"
  };

   switch (numString.length) {
     case 1:
       outputString += romanTable[num];
       break;
     case 2:
       outputString += romanTable[numDigits[0]*10];
       outputString += romanTable[numDigits[1]];
       break;
     case 3:
       outputString += romanTable[numDigits[0]*100];
       outputString += romanTable[numDigits[1]*10];
       outputString += romanTable[numDigits[2]];
       break;
     case 4: 
       outputString += romanTable[numDigits[0]*1000];
       outputString += romanTable[numDigits[1]*100];
       outputString += romanTable[numDigits[2]*10];
       outputString += romanTable[numDigits[3]];
       break;
     default: break;
   }

   return outputString;
}
