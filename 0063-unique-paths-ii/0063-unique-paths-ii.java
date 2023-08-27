class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        
        Map<String,Integer> memo = new HashMap<>();
        return uniquePaths(obstacleGrid,obstacleGrid.length-1,obstacleGrid[0].length-1,memo);
    }
    
    private int uniquePaths(int[][] grid,int row,int col,Map<String,Integer> memo){
        
        if(row==0 && col==0 && grid[0][0]==0){
            return 1;
        }
        if(row<0 || col<0){
            return 0;
        }
        if(grid[row][col]==1){
            return 0;
        }
        
        String key = Integer.toString(row)+"_"+Integer.toString(col);
        if(memo.containsKey(key)){
            return memo.get(key); 
        }
        
        int up =  uniquePaths(grid,row-1,col,memo);
        int left = uniquePaths(grid,row,col-1,memo);
        memo.put(key,up+left);
        return up+left;
    }
}