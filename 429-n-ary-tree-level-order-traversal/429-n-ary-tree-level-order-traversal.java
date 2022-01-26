/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> l1=new ArrayList<>();
         if(root==null){
            return l1;
        }
        
        
        Queue<Node> q1=new LinkedList<>();
        q1.add(root);
        
        ArrayList<Integer> arr1=null;
        while(!q1.isEmpty()){
            int size=q1.size();
            arr1=new ArrayList<Integer>();
            
            while(size>0){
                Node temp=q1.remove();
                arr1.add(temp.val);
                
                for(int itr1=0;itr1<temp.children.size();itr1++){
                    q1.add(temp.children.get(itr1));
                }
                size--;
            }
            l1.add(arr1);
            arr1=null;
        }
        return l1;
    }
    
}