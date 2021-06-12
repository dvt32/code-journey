// https://leetcode.com/problems/evaluate-the-bracket-pairs-of-a-string/

class Solution {
    
    public String evaluate(String s, List<List<String>> knowledge) {
        Map<String, String> keyValues = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        
        knowledge.forEach(pair -> keyValues.put(pair.get(0), pair.get(1)));

        int i = 0;
        while (i < s.length()) {
            char c = s.charAt(i);
            if (c == '(') {
                String key = s.substring(i+1, s.indexOf(')', i+1));
                sb.append( keyValues.getOrDefault(key, "?") );
                i += key.length()+2;
            }
            else {
                sb.append(c);
                i++;
            }
        }
    
        return sb.toString();
    }
    
}
