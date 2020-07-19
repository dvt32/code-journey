// https://leetcode.com/problems/group-the-people-given-the-group-size-they-belong-to/

class Solution {

    public List<List<Integer>> groupThePeople(int[] groupSizes) {     
        Map<Integer, List<Integer>> buckets = new HashMap<>();
        
        for (int i = 0; i < groupSizes.length; ++i) {
            List<Integer> people = buckets.get(groupSizes[i]);
            
            if (people == null) {
                people = new ArrayList<>();
            }
            
            people.add(i);
            buckets.put(groupSizes[i], people);
        }
        
        List< List<Integer> > solution = new ArrayList<>();
        for (Integer groupSize : buckets.keySet()) {
            List<Integer> people = buckets.get(groupSize);
            for (int i = 0; i < people.size(); i += groupSize) {
                List<Integer> group = people.subList(i, i+groupSize);
                solution.add(group);
            }
        }
        
        return solution;
    }
    
}
