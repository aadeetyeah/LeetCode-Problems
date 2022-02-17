class Solution {
    public boolean isBipartite(int[][] graph) {
        int noOfNodes=graph.length;
        int colorArr[]=new int[noOfNodes];
        Arrays.fill(colorArr,-1);
        
        for(int itr1=0;itr1<noOfNodes;itr1++){
            if(colorArr[itr1]==-1){
                boolean flag=checkBipartite(itr1,graph,0,colorArr);
                if(!flag){
                    return false;
                }
            }
        }
        return true;
    }
    
    private boolean checkBipartite(int src,int[][] graph,int color,int colorArr[]){
        colorArr[src]=color;
        for(int itr1 : graph[src]){
            if(colorArr[itr1]==-1){
                int clr=color==0?1:0;
                if(!checkBipartite(itr1,graph,clr,colorArr)){
                    return false;
                }
            }else{
                if(colorArr[itr1]==colorArr[src]){
                    return false;
                }
            }
        }
        return true;
    }
}