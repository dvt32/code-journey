// https://leetcode.com/problems/remove-duplicates-from-sorted-array

class Solution {

    public int removeDuplicates(int[] nums) {
        SortedSet<Integer> uniqueElements = new TreeSet<Integer>();
        for (int num : nums) {
            uniqueElements.add(num);
        }
        
        Iterator<Integer> uniqueElementsIterator = uniqueElements.iterator();
        int numberOfUniqueElements = uniqueElements.size();
        int i = 0;
        while (i < uniqueElements.size()) {
            nums[i] = uniqueElementsIterator.next();
            i++;
        }
        
        return numberOfUniqueElements;
    }
    
}
