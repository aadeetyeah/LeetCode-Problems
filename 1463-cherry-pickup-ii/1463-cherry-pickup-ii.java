class Solution {
    public int cherryPickup(int[][] grid) {
        Map<String,Integer> memo = new HashMap<>();
        return maxCherries(0,0,grid[0].length-1,grid,memo);
    }
    
    private int maxCherries(int row,int col1,int col2,int grid[][],Map<String,Integer> memo){
        
        if(col1<0 || col2<0 || col1>=grid[0].length || col2>=grid[0].length){
            return Integer.MIN_VALUE;
        }
        
        if(row==grid.length-1){
            if(col1==col2){
                return grid[row][col1];
            }else{
                return grid[row][col1]+grid[row][col2];
            }   
        }
        
       String key = Integer.toString(row)+"_"+Integer.toString(col1)+"_"+Integer.toString(col2); 
       if(memo.containsKey(key)){
           return memo.get(key);
       }
        
        int max=Integer.MIN_VALUE;
        for(int j1=-1;j1<=+1;j1++){
            for(int j2=-1;j2<=+1;j2++){
                int val=0;
                 if(col1==col2){
                     val=grid[row][col1];
                 }else{
                     val=grid[row][col1]+grid[row][col2];
                 }
               val+=maxCherries(row+1,col1+j1,col2+j2,grid,memo);
                
                max=Math.max(max,val);
            }
        }
        memo.put(key,max);
        return max;
    }
}