class Solution {
    public int minPathSum(int[][] grid) {
        // int row = grid.length;
        // int col = grid[0].length;
        // Map<String,Integer> map = new HashMap<>();
        // return minPathSum(grid,row-1,col-1,map);
        return minPathSumIterative(grid);
    }

    private int minPathSumIterative(int[][] grid){
        int row = grid.length;
        int col = grid[0].length;
        int dp[][] = new int[row][col];

        for(int itr1 = 0; itr1<row; itr1++){
            for(int itr2 = 0; itr2<col; itr2++){
                if(itr1 == 0 && itr2 == 0){
                    dp[0][0] = grid[0][0];
                }else{
                    int up = (int) 1e9;
                    int left = (int) 1e9;
                    if(itr1>0)
                        up = grid[itr1][itr2] + dp[itr1-1][itr2];
                    if(itr2>0)
                        left = grid[itr1][itr2] + dp[itr1][itr2-1];
                    
                    dp[itr1][itr2] = Math.min(up,left);

                }
            }
        } 
        return dp[row-1][col-1];
    }

    private int minPathSum(int[][] grid,int row, int col,Map<String,Integer> map){
        if(row == 0 && col == 0){
            return grid[0][0];
        }
        if(row<0 || col<0){
            return (int) 1e9;
        }
        String key = Integer.toString(row)+"_"+Integer.toString(col);
        if(map.containsKey(key)){
            return map.get(key);
        }
        int up = grid[row][col] + minPathSum(grid,row-1,col,map);
        int left = grid[row][col] + minPathSum(grid,row,col-1,map);
        map.put(key,Math.min(up,left));
        return map.get(key);
    }
}