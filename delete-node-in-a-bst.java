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
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root==null){
            return null;  // base case
        }
        if(root.val>key){
            root.left=deleteNode(root.left,key); // if key is maller than we will go left side
        }
        else if(root.val<key){
            root.right=deleteNode(root.right,key); // if key is greater than right side we will interate
        }
        else{
            if(root.left==null && root.right==null){    // if both left right --> null simply we will return null
                return null;
            }
            else if(root.left==null && root.right!=null){
                return root.right;
            }                                                                            //   if one of the children is there then we will return that
            else if(root.left!=null && root.right==null){
                return root.left;
            }
            else{
                TreeNode newNode=root.right;
                while(newNode.left!=null){
                    newNode=newNode.left;
                }                                                   // in this case if two children are there for that node than we will update with the right side leftmost node and after that we will delete the node from which we have updated the node
                int value=newNode.val;
                root.right=deleteNode(root.right,newNode.val);
                root.val=value;
                return root;
            }
        }
        return root;  
    }
}