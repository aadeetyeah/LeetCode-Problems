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
    public List<Integer> rightSideView(TreeNode root) {
        Map<Integer,Integer> m1=new HashMap<>();
        rightView(root,0,m1);
        return new ArrayList<Integer>(m1.values());
    }
    private void rightView(TreeNode root,int ht,Map<Integer,Integer> m1){
           if(root==null){
            return;
        }
        if(!m1.containsKey(ht)){
            m1.put(ht,root.val);
        }
        rightView(root.right,ht+1,m1);
        rightView(root.left,ht+1,m1);
        
    }
}