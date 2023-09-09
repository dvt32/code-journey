// https://leetcode.com/problems/decode-the-message

class Solution {

    fun decodeMessage(key: String, message: String): String {
        var decodedMessage: String = ""

        val keyMappings = mutableMapOf<Char, Char>()
        var alphabetLetter = 'a'
        for (i in 0 until key.length) {
            if (!keyMappings.containsKey(key[i]) && key[i] != ' ') {
                keyMappings.put(key[i], alphabetLetter++)
            }
        }

        for (i in 0 until message.length) {
            decodedMessage += if (message[i] == ' ') message[i] else keyMappings[message[i]]
        }

        return decodedMessage
    }

}
