class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        HashMap<Integer,List<Integer>> graph=new HashMap<>();
        for(int itr1=0;itr1<n;itr1++){
            graph.put(itr1,new ArrayList<Integer>());
        }
        createGraph(graph,edges);
        int visited[]=new int[n];
        return checkPath(source,destination,visited,graph);
    }
    
    //Recursive Approach
    private boolean checkPath(int src,int dest,int visited[],Map<Integer,List<Integer>> graph){
        visited[src]=1;
        if(src==dest){
            return true;
        }
        
        
        for(Integer itr1 : graph.get(src)){
            if(visited[itr1]==0){
                if(checkPath(itr1,dest,visited,graph)){
                    return true;
                }
            }
        }
       
        return false;
    }
    
    
    //Iterative Approach
    /*private boolean checkPath(int source,int destination,Map<Integer,List<Integer>> graph){
        Queue<Integer> q1=new LinkedList<>();
        q1.add(source);
        int visited[]=new int[graph.size()];
        
        while(!q1.isEmpty()){
            int currentNode=q1.remove();
            
            if(currentNode==destination){
                return true;
            }
            visited[currentNode]=1;
            for(Integer itr1 : graph.get(currentNode)){
                if(visited[itr1]==0){
                    q1.add(itr1);
                }
            }
            
        }
        return false;
    }*/
    
    private void createGraph(Map<Integer,List<Integer>> graph,int[][] edges){
        for(int itr1=0;itr1<edges.length;itr1++){
            int u=edges[itr1][0];
            int v=edges[itr1][1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
    }
}