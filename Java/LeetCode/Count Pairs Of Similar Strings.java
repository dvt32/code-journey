// https://leetcode.com/problems/count-pairs-of-similar-strings

class Solution {

    public int similarPairs(String[] words) {
        int similarPairCount = 0;

        for (int i = 0; i < words.length; ++i) {
            for (int j = i+1; j < words.length; ++j) {
                Set<Character> firstWordChars = new HashSet<>();
                Set<Character> secondWordChars = new HashSet<>();
                for (int k = 0; k < words[i].length(); ++k) {
                    firstWordChars.add( words[i].charAt(k) );
                }
                for (int m = 0; m < words[j].length(); ++m) {
                    secondWordChars.add( words[j].charAt(m) );
                }
                if (firstWordChars.equals(secondWordChars)) {
                    similarPairCount++;
                }
            }
        }

        return similarPairCount;
    }

}

// Alternative solution
/*
class Solution {

    public int similarPairs(String[] words) {
        int similarPairCount = 0;

        for (int i = 0; i < words.length; ++i) {
            for (int j = i+1; j < words.length; ++j) {
                Set<Character> s1 = new HashSet<Character>(
                    Arrays.asList(words[i].chars().mapToObj(c -> (char)c).toArray(Character[]::new))
                );
                Set<Character> s2 = new HashSet<>(
                    Arrays.asList(words[j].chars().mapToObj(c -> (char)c).toArray(Character[]::new))
                );
                if (s1.equals(s2)) {
                    similarPairCount++;
                }
            }
        }

        return similarPairCount;
    }
}
*/
