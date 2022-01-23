/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> answer=new ArrayList<Integer>();
        Map<TreeNode,TreeNode> m1=new HashMap<>();
        populateHashMap(root,null,m1);
        Set<Integer> visited=new HashSet<>();
        getNodesAtDistanceK(target,m1,k,visited,answer);
        return answer;
    }
    
    private void getNodesAtDistanceK(TreeNode src,Map<TreeNode,TreeNode> m1,int k,Set<Integer> s1,List<Integer> answer){
        if(src==null || s1.contains(src.val)){
            return;
        }
        if(k==0){
            answer.add(src.val);
            return;
        }
        s1.add(src.val);
        getNodesAtDistanceK(src.left,m1,k-1,s1,answer);
        getNodesAtDistanceK(src.right,m1,k-1,s1,answer);
        getNodesAtDistanceK(m1.get(src),m1,k-1,s1,answer);
        return;
        
    }
    
    private void populateHashMap(TreeNode current,TreeNode parent,Map<TreeNode,TreeNode> m1){
        if(current==null){
            return;
        }
        m1.put(current,parent);
        populateHashMap(current.left,current,m1);
        populateHashMap(current.right,current,m1);
        return;
    }
}