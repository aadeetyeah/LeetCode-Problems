class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        
        Map<String,Integer> memo = new HashMap<>();
        return minTotal(triangle,0,0,memo);
    }
    
    private int minTotal(List<List<Integer>> triangle,int row,int col,Map<String,Integer> memo){
        
        if(row==triangle.size()-1){
            return triangle.get(row).get(col);
        }
        String key = Integer.toString(row)+"_"+Integer.toString(col);
        if(memo.containsKey(key)){
            return memo.get(key);
        }
        
        int down = minTotal(triangle,row+1,col,memo);
        int diag = minTotal(triangle,row+1,col+1,memo);
        
        int result = triangle.get(row).get(col) + Math.min(down,diag);
        memo.put(key,result);
        return result;
    }
}