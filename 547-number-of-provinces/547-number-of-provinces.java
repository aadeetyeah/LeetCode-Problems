class Solution {
    public int findCircleNum(int[][] isConnected) {
        int num=0;
        int visited[]=new int[isConnected.length];
        for(int itr1=0;itr1<isConnected.length;itr1++){
            if(visited[itr1]==0){
                num++;
                visitVertex(itr1,isConnected,visited);
            }
        }
        return num;
    }
    
    private void visitVertex(int src,int isConnected[][],int visited[]){
        visited[src]=1;
        for(int itr1=0;itr1<isConnected[src].length;itr1++){
            if(isConnected[src][itr1]==1 && visited[itr1]==0){
                visitVertex(itr1,isConnected,visited);
            }
        }
        return;
    }
}