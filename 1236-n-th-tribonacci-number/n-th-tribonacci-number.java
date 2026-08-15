class Solution {
    public int tribonacci(int n) {
        int dp[] = new int[n+1];
        // Arrays.fill(dp,-1);
        // return trib(n,dp);
        return tribIter(n);
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

    private int tribIter(int n){
        int dp[] = new int[n+1];
        Arrays.fill(dp,-1);
        if(n == 0){
            return n;
        }
        if(n <=2){
            return 1;
        }
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;
        for(int itr1 = 3;itr1<=n;itr1++){
            dp[itr1] = dp[itr1-1] + dp[itr1-2] + dp[itr1-3];
        }
        return dp[n];
    }
}