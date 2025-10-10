class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int row = obstacleGrid.length-1;
        int col = obstacleGrid[0].length-1;
        Map<String,Integer> memo = new HashMap<>();
        return uniquePath2(row,col,obstacleGrid,memo);
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