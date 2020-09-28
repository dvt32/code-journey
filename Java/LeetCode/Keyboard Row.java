// https://leetcode.com/problems/keyboard-row/

class Solution {

    public String[] findWords(String[] words) {
        String[] lettersOnRows = {
            "qwertyuiop",
            "asdfghjkl",
            "zxcvbnm"
        };
        
        List<String> output = new ArrayList<String>();
        
        for (String word : words) {
            char[] wordLetters = word.toLowerCase().toCharArray();
            
            for (String lettersOnRow : lettersOnRows) {
                boolean canBeTypedWithLettersOnRow = true;
                for (char letter : wordLetters) {
                    if ( !lettersOnRow.contains(String.valueOf(letter)) ) {
                        canBeTypedWithLettersOnRow = false;
                        break;
                    }
                }
                if (canBeTypedWithLettersOnRow) {
                    output.add(word);
                    break;
                }
            }
        }
                
        return output.toArray(new String[0]);
    }
    
}
