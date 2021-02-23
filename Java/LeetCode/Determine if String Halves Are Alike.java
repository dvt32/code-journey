// https://leetcode.com/problems/determine-if-string-halves-are-alike/

class Solution {
    
    public boolean halvesAreAlike(String s) {
        String a = s.substring(0, s.length()/2);
        String b = s.substring(s.length()/2);
    
        Set<Character> vowels = new HashSet<>( Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U') );
        int aVowelCount = 0;
        int bVowelCount = 0;
        for (int i = 0; i < a.length(); ++i) {
            if (vowels.contains(a.charAt(i))) {
                aVowelCount++;
            }
            if (vowels.contains(b.charAt(i))) {
                bVowelCount++;
            }
        }

        return aVowelCount == bVowelCount;
    }
    
}
