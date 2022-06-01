class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        List<List<Integer>> graph=createGraph(edges,n);
        
        int visited[]=new int[n];
        return findValidPath(graph,n,source,destination,visited);
    }
    
    private boolean findValidPath(List<List<Integer>> graph,int n,int src,int dest,int visited[]){
        
        if(src==dest){
            return true;
        }
        visited[src]=1;
        
        for(Integer itr1 : graph.get(src)){
            if(visited[itr1]==0 && findValidPath(graph,n,itr1,dest,visited)){
                return true;
            }
        }
        return false;
    }
    
    private List<List<Integer>> createGraph(int edges[][],int n){
        List<List<Integer>> graph=new ArrayList<>();
        for(int itr1=0;itr1<n;itr1++){
            graph.add(new ArrayList<Integer>());
        }
        for(int itr1=0;itr1<edges.length;itr1++){
            int u=edges[itr1][0];
            int v=edges[itr1][1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        return graph;
    }
}