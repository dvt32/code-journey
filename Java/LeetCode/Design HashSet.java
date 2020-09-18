// https://leetcode.com/problems/design-hashset/

class MyHashSet {

    boolean[] contains;
    
    /** Initialize your data structure here. */
    public MyHashSet() {
        contains = new boolean[1000000+1];
    }
    
    public void add(int key) {
        contains[key] = true;
    }
    
    public void remove(int key) {
        contains[key] = false;
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        return contains[key];
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
