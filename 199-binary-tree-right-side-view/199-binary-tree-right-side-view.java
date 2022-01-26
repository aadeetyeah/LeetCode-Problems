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

/* Iterative Solution */
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        if(root==null){
            return new ArrayList<Integer>();
        }
        int ht=0;
        Map<Integer,Integer> m1=new HashMap<>();
        Queue<TreeNode> q1=new LinkedList<>();
        q1.add(root);
        while(!q1.isEmpty()){
            int size=q1.size();
            while(size>0){
                TreeNode temp=q1.remove();
                if(!m1.containsKey(ht)){
                    m1.put(ht,temp.val);
                }
                if(temp.right!=null){
                    q1.add(temp.right);
                }
                if(temp.left!=null){
                    q1.add(temp.left);
                }
                size--;
            }
            ht++;
        }
        return new ArrayList<Integer>(m1.values());
    }
}