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
    public List<Integer> preorder(Node root) {
        Stack<Node> st=new Stack<>();
        ArrayList<Integer> arr=new ArrayList<>();
        
        if(root==null){
            return arr;
        }
        
        st.push(root);
        while(!st.isEmpty()){
            Node temp=st.pop();
            arr.add(temp.val);
            
            for(int itr1=temp.children.size()-1;itr1>=0;itr1--){
                st.push(temp.children.get(itr1));
            }
            
        }
        return arr;
    }
}