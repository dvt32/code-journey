// https://leetcode.com/problems/implement-queue-using-stacks/

class MyQueue {
    
    LinkedList<Integer> stack;

    public MyQueue() {
        stack = new LinkedList<>();
    }
    
    public void push(int x) {
        stack.push(x);
    }
    
    public int pop() {
        return stack.removeLast();
    }
    
    public int peek() {
       return stack.getLast();
    }
    
    public boolean empty() {
        return stack.isEmpty();
    }
  
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
