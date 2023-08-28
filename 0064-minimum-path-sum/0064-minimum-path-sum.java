class Solution {
    public int minPathSum(int[][] grid) {
        
        
        Map<String,Integer> memo = new HashMap<>();
        return minPath(grid,grid.length-1,grid[0].length-1,memo);
    }
    
    private int minPath(int grid[][],int row,int col,Map<String,Integer> memo){
        
        if(row==0 && col==0){
            return grid[0][0];
        }
        if(row<0 || col<0){
            return Integer.MAX_VALUE;
        }
        String key = Integer.toString(row)+"_"+Integer.toString(col);
        
        if(memo.containsKey(key)){
            return memo.get(key);
        }
        
        int up = minPath(grid,row-1,col,memo);
        int left = minPath(grid,row,col-1,memo);
        memo.put(key,grid[row][col]+Math.min(up,left));
        return memo.get(key);
    }
}