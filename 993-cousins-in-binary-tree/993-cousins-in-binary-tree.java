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
    public boolean isCousins(TreeNode root, int x, int y) {
        int arr1[]={0,0};
        int arr2[]={0,0};
        checkCousins(root,x,y,0,arr1,arr2,null);
        if(arr1[0]==arr2[0] && arr1[1]!=arr2[1]){
            return true;
        }
        return false;
    }
    
    private void checkCousins(TreeNode root,int x,int y,int ht,int arr1[],int arr2[],TreeNode parent){
        if(root==null){
            return;
        }
        if(root.val==x && parent!=null){
            arr1[0]=ht;
            arr1[1]=parent.val;
        }
        if(root.val==y && parent!=null){
            arr2[0]=ht;
            arr2[1]=parent.val;
        }
        checkCousins(root.left,x,y,ht+1,arr1,arr2,root);
        checkCousins(root.right,x,y,ht+1,arr1,arr2,root);
        return;
    }
}