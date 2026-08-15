class Solution {
    public int tribonacci(int n) {
        int dp[] = new int[n+1];
        Arrays.fill(dp,-1);
        return trib(n,dp);
    }

    private int trib(int n,int dp[]){
        if(n == 0){
            return n;
        }
        if(n <=2){
            return 1;
        }
        if(dp[n] != -1){
            return dp[n];
        }
        dp[n] = trib(n-1,dp) + trib(n-2,dp) + trib(n-3,dp);
        return dp[n];
    }
}