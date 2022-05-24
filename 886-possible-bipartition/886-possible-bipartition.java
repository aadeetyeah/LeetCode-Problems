class Solution {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        HashMap<Integer,List<Integer>> graph=new HashMap<>();
        for(int itr1=1;itr1<=n;itr1++){
            graph.put(itr1,new ArrayList<Integer>());
        }
        for(int itr1=0;itr1<dislikes.length;itr1++){
            graph.get(dislikes[itr1][0]).add(dislikes[itr1][1]);
            graph.get(dislikes[itr1][1]).add(dislikes[itr1][0]);
        }
        
        
        int visited[]=new int[n+1];
        Arrays.fill(visited,-1);
        
        for(int itr1=1;itr1<=n;itr1++){
            if(visited[itr1]==-1){
                if(!checkBipartite(itr1,0,visited,graph)){
                    return false;
                }
            }    
        }
        return true;
    }
    
    private boolean checkBipartite(int src,int color,int visited[],HashMap<Integer,List<Integer>> graph){
        
        if(visited[src]!=-1){
            if(visited[src]==color){
                return true;
            }else{
                return false;
            }
        }
        
        visited[src]=color;
        color=color==0?1:0;
        for(Integer v : graph.get(src)){
            if(!checkBipartite(v,color,visited,graph)){
                return false;
            }
        }
        return true;
    }
}