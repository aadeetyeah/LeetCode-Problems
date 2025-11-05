class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // int m = obstacleGrid.length;
        // int n = obstacleGrid[0].length;
        // Map<String,Integer> memo = new HashMap<>();
        // return uniqueWays(obstacleGrid,m-1,n-1,memo);
        return uniqueWaysIterative(obstacleGrid);
    }

    private int uniqueWaysIterative(int[][] obstacleGrid){
        int rows = obstacleGrid.length;
        int cols = obstacleGrid[0].length;
        int dp[][] = new int[rows][cols];
        dp[0][0] = 1;
        for(int itr1=0;itr1<rows;itr1++){
            for(int itr2=0;itr2<cols;itr2++){
                if(itr1 == 0 && itr2 == 0 && obstacleGrid[itr1][itr2] == 0){
                    dp[0][0] = 1;
                }else if(obstacleGrid[itr1][itr2] == 1){
                    dp[itr1][itr2] = 0;
                }else{
                int up = 0;
                int left = 0;
                if(itr1>0)
                    up = dp[itr1-1][itr2];
                if(itr2>0)
                    left = dp[itr1][itr2-1];
                
                dp[itr1][itr2] = up+left;
                }
            }
        }
        return dp[rows-1][cols-1];
    }

    private int uniqueWays(int[][] obstacleGrid,int row,int col,Map<String,Integer> memo){
        if(row < 0 || col < 0 || obstacleGrid[row][col] == 1 ){
            return 0;
        }
        if(row == 0 && col == 0 && obstacleGrid[row][col] == 0){
            return 1;
        }
        String key = Integer.toString(row)+"_"+Integer.toString(col);
        if(memo.containsKey(key)){
            return memo.get(key);
        }
        int up = uniqueWays(obstacleGrid,row-1,col,memo);
        int down = uniqueWays(obstacleGrid,row,col-1,memo);
        memo.put(key,up+down);
        return memo.get(key);
    }
}