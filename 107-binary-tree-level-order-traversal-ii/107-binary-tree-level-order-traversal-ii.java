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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
         List<List<Integer>> l1=new ArrayList<List<Integer>>();
         if(root==null){
            
             return l1;
        }
        ArrayList<Integer> arr1=null;
        Queue<TreeNode> q1=new LinkedList<>();
        q1.add(root);
        while(!q1.isEmpty()){
            int size=q1.size();
            arr1=new ArrayList<>();
            
            while(size>0){
                TreeNode temp=q1.remove();
                arr1.add(temp.val);
                if(temp.left!=null){
                    q1.add(temp.left);
                }
                if(temp.right!=null){
                    q1.add(temp.right);
                }
               
                size--;
            }
            l1.add(arr1);
            arr1=null;
        }
        Collections.reverse(l1);
        return l1;
    }
}