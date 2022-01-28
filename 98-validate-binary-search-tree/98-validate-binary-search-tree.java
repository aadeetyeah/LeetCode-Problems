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
        ArrayList<Integer> arr=new ArrayList<>();
        inorder(root,arr);
        for(int itr1=1;itr1<arr.size();itr1++){
            if(arr.get(itr1-1)>=arr.get(itr1)){
                return false;
            }
            
        }
        return true;
    }
    private void inorder(TreeNode root,List<Integer> l1){
        if(root==null){
            return;
        }
        inorder(root.left,l1);
        l1.add(root.val);
        inorder(root.right,l1);
        return;
    }
}