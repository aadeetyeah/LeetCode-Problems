class Solution {
    public int minPathSum(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        Map<String,Integer> m1=new HashMap<>();
        return minPath(grid,0,0,m-1,n-1,m1);
    }
    
    private int minPath(int grid[][],int startRow,int startCol,int endRow,int endCol,Map<String,Integer> m1){
        if(startRow>endRow || startCol>endCol){
            return Integer.MAX_VALUE;
        }
        if(startRow==endRow && startCol==endCol){
            return grid[startRow][startCol];
        }
        String key=Integer.toString(startRow)+"_"+Integer.toString(startCol);
        if(m1.containsKey(key)){
            return m1.get(key);
        }
        int downCall=minPath(grid,startRow+1,startCol,endRow,endCol,m1);
        int rightCall=minPath(grid,startRow,startCol+1,endRow,endCol,m1);
        int result=Math.min(downCall,rightCall);
        m1.put(key, result+grid[startRow][startCol]);
        return m1.get(key);
        
    }
}