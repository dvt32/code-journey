// https://leetcode.com/problems/subdomain-visit-count/submissions/

class Solution {

    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> subdomainVisitCounts = new HashMap<>();
        
        for (String cpdomain : cpdomains) {
            Integer spaceIndex = cpdomain.indexOf(" ");
            Integer visitCount = Integer.valueOf( cpdomain.substring(0, spaceIndex) );
            String domain = cpdomain.substring(spaceIndex+1);
            
            subdomainVisitCounts.put(domain, subdomainVisitCounts.getOrDefault(domain, 0) + visitCount);
            
            Integer firstDotIndex = domain.indexOf(".");
            Integer lastDotIndex = domain.lastIndexOf(".");
            boolean twoDots = (firstDotIndex != lastDotIndex); 
            
            if (twoDots) {
                String firstParentDomain = domain.substring(firstDotIndex+1);
                String secondParentDomain = domain.substring(lastDotIndex+1);
                subdomainVisitCounts.put(
                    firstParentDomain, 
                    subdomainVisitCounts.getOrDefault(firstParentDomain, 0) + visitCount
                );
                subdomainVisitCounts.put(
                    secondParentDomain, 
                    subdomainVisitCounts.getOrDefault(secondParentDomain, 0) + visitCount
                );
            }
            else {
                String parentDomain = domain.substring(lastDotIndex+1);
                subdomainVisitCounts.put(
                    parentDomain, 
                    subdomainVisitCounts.getOrDefault(parentDomain, 0) + visitCount
                );
            }
        }
        
        List<String> subdomainVisits = new ArrayList<>();
        for (String cpdomain : subdomainVisitCounts.keySet()) {
            subdomainVisits.add( subdomainVisitCounts.get(cpdomain) + " " + cpdomain );
        }
        
        return subdomainVisits;
    }
    
}
