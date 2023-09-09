class Solution {
    
    public String decodeMessage(String key, String message) {
        StringBuilder decodedMessage = new StringBuilder();

        Map<Character, Character> keyMappings = new HashMap<>();
        char alphabetLetter = 'a';
        for (int i = 0; i < key.length(); ++i) {
            char c = key.charAt(i);
            if (!keyMappings.containsKey(c) && c != ' ') {
                keyMappings.put(c, alphabetLetter++);
            }
        }

        for (int i = 0; i < message.length(); ++i) {
            char c = message.charAt(i);
            decodedMessage.append( (c == ' ') ? c : keyMappings.get(c) );
        }

        return decodedMessage.toString();
    }
    
}
