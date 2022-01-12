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
    public int maxDepth(Node root) {
        if(root==null){
            return 0;
        }
        int len=0;
        for(int itr1=0;itr1<root.children.size();itr1++){
            len=Math.max(len,maxDepth(root.children.get(itr1)));
        }
        return len+1;
    }
}