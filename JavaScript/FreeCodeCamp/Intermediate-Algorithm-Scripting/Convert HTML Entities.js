// https://www.freecodecamp.com/challenges/convert-html-entities

function convertHTML(str) {
  // &colon;&rpar;
  
  for (var i = 0; i < str.length; ++i) {
    switch (str.charAt(i)) {
      case '&':
        str = str.replace(str.charAt(i), '&amp;');
        break;
      case '<':
        str = str.replace(str.charAt(i), '&lt;');
        break;
      case '>':
        str = str.replace(str.charAt(i), '&gt;');
        break;
      case '"':
        str = str.replace(str.charAt(i), '&quot;');
        break;
      case '\'':
        str = str.replace(str.charAt(i), '&apos;')
        break;
      default:
        break;
    }
  }

  return str;
}
