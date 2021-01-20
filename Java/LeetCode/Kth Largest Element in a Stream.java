// https://leetcode.com/problems/kth-largest-element-in-a-stream/

class KthLargest {
    
    // https://leetcode.com/problems/kth-largest-element-in-a-stream/discuss/544481/Java-With-Explanation
    
    private int k;
    private Queue<Integer> queue;
    
    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.queue = new PriorityQueue<>();
        
        for (int num : nums) {
            add(num);
        }
    }
    
    public int add(int val) {
        queue.add(val);
        
        if (queue.size() > this.k) {
            queue.poll();
        }
        
        int kthLargest = queue.peek();
        
        return kthLargest;
    }
    
    
    // Alternative accepted, but much slower solution
    /*
    private List<Integer> numbers;
    private int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.numbers = new ArrayList<>();
        for (int num : nums) {
            numbers.add(num);
        }
    }
    
    public int add(int val) {
        numbers.add(val);
        Collections.sort(numbers);
        int kthLargest = numbers.get( numbers.size()-k );  
        return kthLargest;
    }
    */
    
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */
