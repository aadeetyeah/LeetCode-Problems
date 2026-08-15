class Solution {
    public int fib(int n) {
        int dp[] = new int[n+1];
        Arrays.fill(dp,-1);
        return fibonacci(n,dp);
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
}