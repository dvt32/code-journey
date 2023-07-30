// https://leetcode.com/problems/reorder-data-in-log-files

class Solution {

    public String[] reorderLogFiles(String[] logs) {
        List<String> letterLogs = new ArrayList<>();
        List<String> digitLogs = new ArrayList<>();

        for (String log : logs) {
            String[] split = log.split(" ");
            if (Character.isDigit(split[1].charAt(0))) {
                digitLogs.add(log);
            } 
            else {
                letterLogs.add(log);
            }
        }

        Collections.sort(letterLogs, new Comparator<String>() {
            @Override
            public int compare(String letterLog1, String letterLog2) {
                int firstSpaceIndex1 = letterLog1.indexOf(" ");
                int firstSpaceIndex2 = letterLog2.indexOf(" ");
                String words1 = letterLog1.substring(firstSpaceIndex1+1);
                String words2 = letterLog2.substring(firstSpaceIndex2+1);

                if (!words1.equals(words2)) {
                    return words1.compareTo(words2);
                } else {
                    String identifier1 = letterLog1.substring(0, firstSpaceIndex1);
                    String identifier2 = letterLog2.substring(0, firstSpaceIndex2);
                    return identifier1.compareTo(identifier2);
                }
            }
        });

        letterLogs.addAll(digitLogs);
        
        return letterLogs.toArray(new String[0]);
    }

}
