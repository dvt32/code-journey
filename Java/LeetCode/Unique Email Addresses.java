// https://leetcode.com/problems/unique-email-addresses/

class Solution {
    
    public int numUniqueEmails(String[] emails) {
        Set<String> uniqueEmails = new HashSet<>();
        
        for (String email : emails) {
            int atSignIndex = email.indexOf("@");
            
            String localName = email.substring(0, atSignIndex);
            int plusSignIndex = localName.indexOf("+");
            if (plusSignIndex != -1) {
                localName = localName.substring(0, plusSignIndex);
            }
            localName = localName.replace(".", "");
            
            String domainName = email.substring(atSignIndex+1);
            email = localName + "@" + domainName;
            
            uniqueEmails.add(email);
        }
        
        return uniqueEmails.size();
    }
    
}
