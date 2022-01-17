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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> l1=new ArrayList<>();
        getPaths(root,l1,"");
        return l1;
    }
    
    private void getPaths(TreeNode root,List<String> l1,String str1){
        if(root==null){
            return;
        }
        if(root.left==null && root.right==null){
            str1+=Integer.toString(root.val);
            l1.add(str1);
            return;
        }
        String currPath=str1+Integer.toString(root.val)+"->";
        getPaths(root.left,l1,currPath);
        getPaths(root.right,l1,currPath);
        return;
    }
}