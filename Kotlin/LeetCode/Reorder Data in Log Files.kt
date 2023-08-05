// https://leetcode.com/problems/reorder-data-in-log-files

class Solution {

    fun reorderLogFiles(logs: Array<String>): Array<String> {
        var letterLogs = mutableListOf<String>();
        var digitLogs = mutableListOf<String>();

        for (log in logs) {
            val split = log.split(" ");
            if (Character.isDigit(split[1][0])) {
                digitLogs.add(log);
            } 
            else {
                letterLogs.add(log);
            }
        }

        letterLogs.sortWith(Comparator {
            letterLog1, letterLog2 ->
                val firstSpaceIndex1 = letterLog1.indexOf(" ");
                val firstSpaceIndex2 = letterLog2.indexOf(" ");
                val words1 = letterLog1.substring(firstSpaceIndex1+1);
                val words2 = letterLog2.substring(firstSpaceIndex2+1);

                if (!words1.equals(words2)) {
                    words1.compareTo(words2);
                } else {
                    val identifier1 = letterLog1.substring(0, firstSpaceIndex1);
                    val identifier2 = letterLog2.substring(0, firstSpaceIndex2);
                    identifier1.compareTo(identifier2);
                }
        })

        letterLogs.addAll(digitLogs);
        
        return letterLogs.toTypedArray();
    }

}
