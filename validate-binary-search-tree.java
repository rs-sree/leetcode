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
     public boolean isValidBST(TreeNode root) {
        //corner case
        return isValidBST(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }
    public boolean isValidBST(TreeNode root,long downBound,long upBound){
        if(root==null) return true;
        if(root.val<=downBound||root.val>=upBound) return false;
        return isValidBST(root.left,downBound,root.val)&&isValidBST(root.right,root.val,upBound);
    }
    
}