// https://leetcode.com/problems/binary-tree-preorder-traversal/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

   public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> nodes = new ArrayList<>();
        preorder(root, nodes);
        return nodes;
    }
    
    private void preorder(TreeNode root, List<Integer> nodes) {
        if (root == null) {
            return;
        }
        
        nodes.add(root.val);
        preorder(root.left, nodes);
        preorder(root.right, nodes);
    }
    
}
