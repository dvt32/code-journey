// https://leetcode.com/problems/greatest-english-letter-in-upper-and-lower-case/

public String greatestLetter(String s) {
    Set<Character> uniqueChars = new HashSet<>();

    for (int i = 0; i < s.length(); ++i) {
        uniqueChars.add(s.charAt(i));
    }

    for (char c = 'Z'; c >= 'A'; --c) {
        if (uniqueChars.contains(c) && uniqueChars.contains(Character.toLowerCase(c))) {
            return "" + c;
        }
    }

    return "";
}
