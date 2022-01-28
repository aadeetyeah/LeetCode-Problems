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
       long prev[]={Long.MIN_VALUE};        
        return inorder(root,prev);
    }
    private boolean inorder(TreeNode root,long prev[]){
        if(root==null){
            return true;
        }
        
        boolean left=inorder(root.left,prev);
        if(root.val<=prev[0] ){
            return false;
        }
        prev[0]=root.val;
        boolean right=inorder(root.right,prev);
        return left && right;
    }
}