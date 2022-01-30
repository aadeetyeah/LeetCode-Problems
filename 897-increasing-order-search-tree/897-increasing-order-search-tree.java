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
    public TreeNode increasingBST(TreeNode root) {
        ArrayList<Integer> arr=new ArrayList<>();
        inorder(root,arr);
        return create(arr);
    }
    private TreeNode create(List<Integer> l1){
        
        if(l1.size()==0){
            return null;
        }
        TreeNode temp=new TreeNode(l1.get(0));
        TreeNode temp1=temp;
        for(int itr1=1;itr1<l1.size();itr1++){
            temp.right=new TreeNode(l1.get(itr1));
            temp=temp.right;
        }
        return temp1;
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