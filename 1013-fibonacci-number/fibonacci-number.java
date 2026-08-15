class Solution {
    public int fib(int n) {
        int dp[] = new int[n+1];
        // Arrays.fill(dp,-1);
        // return fibonacci(n,dp);
        return fibIter(n);
    }

    private int fibonacci(int n,int dp[]){
        if(n== 0 || n == 1){
            return n;
        }
        if(dp[n]!=-1){
            return dp[n];
        }

        dp[n] = fibonacci(n-1,dp) + fibonacci(n-2,dp);
        return dp[n];
    }

    private int fibIter(int n){
        if(n==0 || n ==1){
            return n;
        }
        int dp[] = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;

        for(int itr1 = 2;itr1<=n; itr1++){
            dp[itr1] = dp[itr1-1] + dp[itr1-2];
        }
        return dp[n];
    }
}