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
        List<Integer> l1=new ArrayList<>();
        preorder(root,l1);
        return l1;
    }
    
    private void preorder(TreeNode root,List<Integer> l1){
        if(root==null){
            return;
        }
        l1.add(root.val);
        preorder(root.left,l1);
        preorder(root.right,l1);
        return;
    }
}