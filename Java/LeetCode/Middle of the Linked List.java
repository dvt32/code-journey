// https://leetcode.com/problems/middle-of-the-linked-list/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
 
class Solution {

    public ListNode middleNode(ListNode head) {
        // Get length of list
        ListNode copy = head;
        int listSize = 0;
        while (copy != null) {
            listSize++;
            copy = copy.next;
        }
        
        // Get middle node of list
        int middleNodeIndex = listSize / 2;
        for (int i = 0; i != middleNodeIndex; ++i) {
            head = head.next;
        }
        
        return head;
    }
    
}
