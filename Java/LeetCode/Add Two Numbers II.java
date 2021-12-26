// https://leetcode.com/problems/add-two-numbers-ii/

import java.math.BigInteger;

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
    
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        String sum = getNumber(l1).add(getNumber(l2)).toString();

        ListNode result = null;
        for (int i = 0; i < sum.length(); ++i) {
            int digit = Character.getNumericValue( sum.charAt(i) );
            ListNode newNode = new ListNode(digit);
            
            if (result == null) {
                result = newNode;
                continue;
            }

            ListNode lastNode = result;
            while (lastNode.next != null) {
                lastNode = lastNode.next;
            }
            lastNode.next = newNode;
        }
        
        return result;
    }
                   
    public BigInteger getNumber(ListNode node) {
        StringBuilder numberStr = new StringBuilder();
        
        while (node != null) {
            numberStr.append("" + node.val);
            node = node.next;
        }
        
        return new BigInteger( numberStr.toString() );
    }
    
}
