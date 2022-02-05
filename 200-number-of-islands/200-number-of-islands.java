class Solution {
    public int numIslands(char[][] grid) {
        int count=0;
        boolean flag=false;
        for(int itr1=0;itr1<grid.length;itr1++){
            for(int itr2=0;itr2<grid[0].length;itr2++){
                if(getNumOfIslands(itr1,itr2,grid,flag)){
                    count++;
                }
            }
        }
        return count;
    }
    
    private boolean getNumOfIslands(int sr,int sc,char grid[][],boolean flag){
        if(sr>=grid.length || sc>=grid[0].length || sr<0 || sc<0 || grid[sr][sc]=='0'){
            return false;
        }
        grid[sr][sc]='0';
        flag=true;
        getNumOfIslands(sr-1,sc,grid,flag);
        getNumOfIslands(sr+1,sc,grid,flag);
        getNumOfIslands(sr,sc-1,grid,flag);
        getNumOfIslands(sr,sc+1,grid,flag);
        
        return flag;
    }
}