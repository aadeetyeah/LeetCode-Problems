class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // int row = obstacleGrid.length-1;
        // int col = obstacleGrid[0].length-1;
        // Map<String,Integer> memo = new HashMap<>();
        // return uniquePath2(row,col,obstacleGrid,memo);
        return uniquePathIterative(obstacleGrid);
    }

    private int uniquePathIterative(int[][] obstacleGrid){
        int row = obstacleGrid.length;
        int col = obstacleGrid[0].length;
        int dp[][] = new int[row][col];

        dp[0][0] = 1;
        for(int itr1=0; itr1< row;itr1++){
            for(int itr2=0; itr2<col; itr2++){
                if(itr1==0 && itr2==0 && obstacleGrid[itr1][itr2]==0){
                    dp[itr1][itr2] = 1;
                }else if(obstacleGrid[itr1][itr2]==1){
                    dp[itr1][itr2] = 0;
                }else{
                int up = 0;
                int left = 0;
                if(itr1>0){
                    up = dp[itr1-1][itr2];
                }
                if(itr2>0){
                    left = dp[itr1][itr2-1];
                }
                dp[itr1][itr2] = up+left;
                }
            }

        }
        return dp[row-1][col-1];
    }

    private int uniquePath2(int row, int col,int[][] obstacleGrid,Map<String,Integer> memo){
        if(row < 0 || col < 0){
            return 0;
        }
        if(row == 0 && col == 0 && obstacleGrid[row][col] == 0){
            return 1;
        }
        if(obstacleGrid[row][col] == 1){
            return 0;
        }
        String key = Integer.toString(row)+"_"+Integer.toString(col);
        if(memo.containsKey(key)){
            return memo.get(key);
        }
        int up = uniquePath2(row-1,col,obstacleGrid,memo);
        int left = uniquePath2(row,col-1,obstacleGrid,memo);
        memo.put(key,up+left);
        return memo.get(key);
    }
}