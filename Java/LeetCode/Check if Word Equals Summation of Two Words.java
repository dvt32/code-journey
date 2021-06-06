// https://leetcode.com/problems/check-if-word-equals-summation-of-two-words/

class Solution {
  
    public boolean isSumEqual(String firstWord, String secondWord, String targetWord) {
        Map<Character, Character> letterValues = new HashMap<>();

        for (char letter = 'a', value = '0'; 
             letter <= 'j'; 
             ++letter, ++value) 
        {
            letterValues.put(letter, value);
        }
        
        StringBuilder firstWordConverted = new StringBuilder();
        firstWord.chars().forEach(c -> firstWordConverted.append(letterValues.get((char) c)));
        Integer firstWordValue = Integer.parseInt(firstWordConverted.toString());
        
        StringBuilder secondWordConverted = new StringBuilder();
        secondWord.chars().forEach(c -> secondWordConverted.append(letterValues.get((char) c)));
        Integer secondWordValue = Integer.parseInt(secondWordConverted.toString());
        
        StringBuilder targetWordConverted = new StringBuilder();
        targetWord.chars().forEach(c -> targetWordConverted.append(letterValues.get((char) c)));
        Integer targetWordValue = Integer.parseInt(targetWordConverted.toString());
    
        return (firstWordValue + secondWordValue) == targetWordValue;
    }
  
}
