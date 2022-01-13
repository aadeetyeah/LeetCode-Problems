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
    public int sumRootToLeaf(TreeNode root) {
        String str="";
        return sumRoot(root,str);
    }
    
    public int sumRoot(TreeNode root,String str){
        if(root==null){
            return 0;
        }
        if(root.left==null && root.right==null){
            str+=Integer.toString(root.val);
            return Integer.parseInt(str,2);
        }
        int res=0;
        
        res+=sumRoot(root.left,str+Integer.toString(root.val));
        res+=sumRoot(root.right,str+Integer.toString(root.val));
        return res;
    }
}