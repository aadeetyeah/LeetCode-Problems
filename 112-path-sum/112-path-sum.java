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
    public boolean hasPathSum(TreeNode root, int targetSum) {
      
        return hasPath(root,targetSum,0);
    }
    private boolean hasPath(TreeNode root,int target,int current){
        if(root==null){
            return false;
        }
        if(root.left==null && root.right==null){
            current+=root.val;
            if(current==target){
                return true;
            }
        }
        
        //System.out.println(current+"---"+root.val);
        return hasPath(root.left,target,current+root.val) || hasPath(root.right,target,current+root.val);
        
    }
}