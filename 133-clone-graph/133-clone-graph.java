/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        
       // Node temp=new Node(node.val,new ArrayList<Node>());
        //temp.neighbors.addAll(node.neighbors);
        Node visited[]=new Node[101];
        
        return copyGraph(node,visited);
        
    }
    
    private Node copyGraph(Node node,Node visited[]){
        if(node==null){
            return null;
        }
        if(visited[node.val]!=null){
            return visited[node.val];
        }
        
        Node copy=new Node(node.val,new ArrayList<Node>());
        visited[node.val]=copy;
        
        for(Node itr1 : node.neighbors){
                Node t1=copyGraph(itr1,visited);
                if(t1!=null){
                    copy.neighbors.add(t1);
                }
        }
        return copy;
    }
}