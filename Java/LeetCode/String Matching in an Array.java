// https://leetcode.com/problems/string-matching-in-an-array/

class Solution {

    public List<String> stringMatching(String[] words) {
        List<String> output = new ArrayList<>();
        
        for (String word : words) {
            for (int i = 0; i < words.length; ++i) {
                if (!words[i].equals(word) && words[i].contains(word)) {
                    output.add(word);
                    break;
                }
            }
        }
        
        return output;
    }
    
}
