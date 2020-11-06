// https://leetcode.com/problems/destination-city/

class Solution {

    public String destCity(List<List<String>> paths) {
        Set<String> startCities = new HashSet<>();
        
        for (List<String> path : paths) {
            String startCity = path.get(0);
            startCities.add(startCity);
        }
        
        for (List<String> path : paths) {
            String endCity = path.get(1);
            if (!startCities.contains(endCity)) {
                return endCity;
            }
        }
        
        return null;
    }
}
