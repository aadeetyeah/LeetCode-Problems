class Solution {
    public boolean isBipartite(int[][] graph) {
        int visited[]=new int[graph.length];
        Arrays.fill(visited,-1);
        for(int itr1=0;itr1<graph.length;itr1++){
            if(visited[itr1]==-1){
                if(!checkBipartite(itr1,0,visited,graph)){
                    return false;
                }
            }
        }
        return true;
    }
    
    private boolean checkBipartite(int src,int color,int visited[],int graph[][]){
        
        if(visited[src]!=-1){
            if(visited[src]==color){
                return true;
            }else{
                return false;
            }
        }
        visited[src]=color;
        color=color==0?1:0;
        for(int itr1=0;itr1<graph[src].length;itr1++){
            if(!checkBipartite(graph[src][itr1],color,visited,graph)){
                return false;
            }
        }
        return true;
    }
}