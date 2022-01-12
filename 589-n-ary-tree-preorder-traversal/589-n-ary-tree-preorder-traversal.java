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
        List<Integer> l1=new ArrayList<>();
        preOrder(root,l1);
        return l1;
    }
    
    public void preOrder(Node root,List<Integer> l1){
        if(root==null){
            return ;
        }
        l1.add(root.val);
        for(int itr1=0;itr1<root.children.size();itr1++){
            preOrder(root.children.get(itr1),l1);
        }
        return;
    }
}