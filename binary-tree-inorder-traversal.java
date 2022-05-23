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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> inOrder = new ArrayList<>();
        if(root != null) {
            add(root, inOrder);
        }
        return inOrder;
    }
    
    public void add(TreeNode node, List<Integer> list) {
        if(node != null) {
            add(node.left, list);
            list.add(node.val);
            add(node.right, list);
        }          
    }
}