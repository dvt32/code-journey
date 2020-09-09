// https://leetcode.com/problems/occurrences-after-bigram/

class Solution {

    public String[] findOcurrences(String text, String first, String second) {
        String[] words = text.split(" ");
        
        List<String> answer = new ArrayList<>();
        for (int i = 0; i < words.length-2; ++i) {
            if (words[i].equals(first) && words[i+1].equals(second)) {
                answer.add(words[i+2]);
            }
        }
        
        return answer.stream().toArray(String[]::new);
    }
    
}
