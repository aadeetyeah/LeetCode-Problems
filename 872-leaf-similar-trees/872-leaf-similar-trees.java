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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> l1=new ArrayList<>();
        List<Integer> l2=new ArrayList<>();
        
        leafSame(root1,l1);
        leafSame(root2,l2);
        
        if(l1.size()!=l2.size()){
            return false;
        }
        for(int itr1=0;itr1<l1.size();itr1++){
            System.out.println(l1.get(itr1)+"----"+l2.get(itr1));
            if(l1.get(itr1)!=l2.get(itr1)){
                return false;
            }
        }
        return true;
    }
    
    private void leafSame(TreeNode root,List<Integer> l1){
        if(root==null){
            return;
        }
        if(root.left==null && root.right==null){
            l1.add(root.val);
        }
        leafSame(root.left,l1);
        leafSame(root.right,l1);
    }
}