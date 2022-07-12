class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        Map<String,Integer> map1=new HashMap<>();
        
        return uniquePath(0,0,obstacleGrid.length-1,obstacleGrid[0].length-1,obstacleGrid,map1);
    }
    private int uniquePath(int startRow,int startCol,int destRow,int destCol,int[][] obstacleGrid,Map<String,Integer> map1){
        if(startRow>destRow || startCol > destCol || obstacleGrid[startRow][startCol]==1){
            return 0;
        }
        if(startRow==destRow && startCol==destCol){
            return 1;
        }
        String key=Integer.toString(startRow)+"_"+Integer.toString(startCol);
        if(map1.containsKey(key)){
            return map1.get(key);
        }
        map1.put(key,uniquePath(startRow+1,startCol,destRow,destCol,obstacleGrid,map1)+uniquePath(startRow,startCol+1,destRow,destCol,obstacleGrid,map1));
        return map1.get(key);
        
    }
}