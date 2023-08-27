class Solution {
    public int uniquePaths(int m, int n) {
        
        Map<String,Integer> memo = new HashMap<>();
        return countPaths(m-1,n-1,memo);
    }
    
    private int countPaths(int row,int col,Map<String,Integer> memo){
        
        if(row==0 && col==0){
            return 1;
        }
        if(row<0 || col<0){
            return 0;
        }
        String key = Integer.toString(row)+"_"+Integer.toString(col);
        if(memo.containsKey(key)){
            return memo.get(key);
        }
        int up = countPaths(row-1,col,memo);
        int left = countPaths(row,col-1,memo);
        memo.put(key,up+left);
        return up+left;
    }
}