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
            return null;
        }
        if(root.val>key){
            root.left=deleteNode(root.left,key);
        }else if(root.val<key){
            root.right=deleteNode(root.right,key);
        }else{
            if(root.left==null && root.right==null){
                return null;
            }else if(root.left!=null && root.right==null){
                return root.left;
            }else if(root.left==null && root.right!=null){
                return root.right;
            }
            TreeNode temp=findMinLeft(root.right);
            int t1=temp.val;
            temp.val=root.val;
            root.val=t1;
            root.right=deleteNode(root.right,temp.val);
        }
        return root;
    }
    private TreeNode findMinLeft(TreeNode root){
        while(root.left!=null){
            root=root.left;
        }
        return root;
    }
}