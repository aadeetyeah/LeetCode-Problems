class Solution {
    public int uniquePaths(int m, int n) {
        // Map<String,Integer> memo = new HashMap<>();
        // return uniqueWays(m-1,n-1,memo);
        return uniqueWaysIterative(m,n);
    }

    private int uniqueWays(int m,int n,Map<String,Integer> memo){
        if(m < 0 || n < 0){
            return 0;
        }
        if(m == 0 && n == 0){
            return 1;
        }
        String key = Integer.toString(m)+"_"+Integer.toString(n);
        if(memo.containsKey(key)){
            return memo.get(key);
        }
        int up = uniqueWays(m-1,n,memo);
        int down = uniqueWays(m,n-1,memo);
        memo.put(key,up+down);
        return memo.get(key);
    }

    private int uniqueWaysIterative(int rows, int cols){
        int dp[][] = new int[rows][cols];
        dp[0][0] = 1;
        for(int itr1=0;itr1<rows;itr1++){
            for(int itr2=0;itr2<cols;itr2++){
                if(itr1 == 0 && itr2 == 0){
                    dp[0][0] = 1;
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
}