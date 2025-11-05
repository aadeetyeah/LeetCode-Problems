class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        Map<String,Integer> memo = new HashMap<>();
        return uniqueWays(obstacleGrid,m-1,n-1,memo);
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