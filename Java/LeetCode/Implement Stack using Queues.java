// https://leetcode.com/problems/implement-stack-using-queues/

class MyStack {
    
    LinkedList<Integer> queue;

    public MyStack() {
        queue = new LinkedList<>();
    }
    
    public void push(int x) {
        queue.push(x);
    }
    
    public int pop() {
        return queue.pop();
    }
    
    public int top() {
        return queue.peekFirst();
    }
    
    public boolean empty() {
        return queue.isEmpty();
    }
    
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
