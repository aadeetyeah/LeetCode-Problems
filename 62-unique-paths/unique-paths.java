class Solution {
    public int uniquePaths(int m, int n) {
        Map<String,Integer> memo = new HashMap<>();
        // return uniqueWays(m-1,n-1,memo);

        return uniquePathsIterative(m,n);
    }

    private int uniquePathsIterative(int rows,int columns){

        int dp[][]= new int[rows][columns];
        dp[0][0]=1;
        for(int itr1 = 0;itr1<rows;itr1++){
            for(int itr2=0; itr2<columns; itr2++){
                int down = 0;
                int right = 0;
                if(itr1==0 && itr2==0){
                    dp[0][0] = 1;
                }else{
                    if(itr1>0){
                        down = dp[itr1-1][itr2];
                    }
                    if(itr2>0){
                        right = dp[itr1][itr2-1];
                    }
                    dp[itr1][itr2] = down + right;
                }
            }
        }
        return dp[rows-1][columns-1];
    }

    private int uniqueWays(int itr1, int itr2, Map<String,Integer> memo){
        if(itr1<0 || itr2<0){
            return 0;
        }

        if(itr1==0 && itr2==0){
            return 1;
        }

        String key = Integer.toString(itr1)+"_"+Integer.toString(itr2);
        if(memo.containsKey(key)){
            return memo.get(key);
        }
        int up = uniqueWays(itr1-1,itr2,memo);
        int left = uniqueWays(itr1,itr2-1,memo);
        memo.put(key, up+left);
        return memo.get(key);
    }         
}