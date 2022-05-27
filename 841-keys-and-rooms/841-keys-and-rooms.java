class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int visited[]=new int[rooms.size()];
        visitedRooms(rooms,0,visited);
        for(int itr1=0;itr1<rooms.size();itr1++){
            if(visited[itr1]==0){
                return false;
            }
        }
        return true;
    }
    
    private void visitedRooms(List<List<Integer>> rooms,int src,int visited[]){
        visited[src]=1;
        for(Integer itr1 : rooms.get(src)){
            if(itr1==src || visited[itr1]!=0){
                continue;
            }
            visitedRooms(rooms,itr1,visited);
        }
        return;
    }
}