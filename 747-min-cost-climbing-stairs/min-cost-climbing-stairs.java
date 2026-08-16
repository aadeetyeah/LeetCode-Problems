class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int dp[] = new int[cost.length];
        Arrays.fill(dp,-1);
        dp[cost.length-1] = minCost(cost,cost.length-1,dp);
        for(int itr : dp){
            System.out.println(itr);
        }
        return Math.min(dp[cost.length-1],dp[cost.length-2]);
    }

    private int minCost(int[] cost, int index,int dp[]){
        if(index == 0){
            dp[index] = cost[index];
            return cost[index];
        }
        if(index < 0){
            return 0;
        }
        if(dp[index]!=-1){
            return dp[index];
        }

        int os = minCost(cost, index-1,dp);
        int ts = minCost(cost, index-2,dp);
        int res = cost[index] + Math.min(os,ts);
        dp[index] = res;
        return dp[index];
    }
}