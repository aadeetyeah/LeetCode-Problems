class Solution {
    public int minPathSum(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        Map<String,Integer> map = new HashMap<>();
        return minPathSum(grid,row-1,col-1,map);
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