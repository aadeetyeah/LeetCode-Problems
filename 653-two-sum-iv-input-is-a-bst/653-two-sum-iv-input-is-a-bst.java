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
    public boolean findTarget(TreeNode root, int k) {
        Map<Integer,Integer> m1=new HashMap<>();
        traverseTree(root,m1);
        if(m1.size()==1){
            return false;
        }
        int temp=0;
        for(Map.Entry<Integer,Integer> e1 : m1.entrySet()){
            temp=k-e1.getKey();
            if(m1.containsKey(temp) && e1.getKey()!=temp){
                return true;
            }
        }
        return false;
    }
    private void traverseTree(TreeNode root,Map<Integer,Integer> m1){
        if(root==null){
            return;
        }
        m1.put(root.val,1);
        traverseTree(root.left,m1);
        traverseTree(root.right,m1);
        return;
    }
}