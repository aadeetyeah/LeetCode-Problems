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
    public boolean isUnivalTree(TreeNode root) {
        return isUnival(root,root.val);
    }
    private boolean isUnival(TreeNode root,int data){
        if(root==null){
            return true;
        }
        if(root.val!=data){
            return false;
        }
        return isUnival(root.left,data) && isUnival(root.right,data);
    }
}