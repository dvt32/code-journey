// https://www.freecodecamp.com/challenges/search-and-replace

function myReplace(str, before, after) {
   var after_modified;
    
   if (before.charAt(0) == before.charAt(0).toUpperCase()) {
     after_modified = after.charAt(0).toUpperCase() + after.substring(1, after.length);
   }
   else {
     after_modified = after.charAt(0).toLowerCase() + after.substring(1, after.length);
   }
      
   var output = str.replace(before, after_modified);
  
   return output;
}
