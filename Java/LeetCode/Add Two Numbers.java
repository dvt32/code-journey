// https://leetcode.com/problems/add-two-numbers/

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
        String sum = getReversedNumber(l1).add(getReversedNumber(l2)).toString();

        ListNode result = null;
        for (int i = sum.length()-1; i >= 0; --i) {
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
                   
    public BigInteger getReversedNumber(ListNode node) {
        StringBuilder numberStr = new StringBuilder();
        
        while (node != null) {
            numberStr.append("" + node.val);
            node = node.next;
        }
        
        return new BigInteger( numberStr.reverse().toString() );
    }
    
}
