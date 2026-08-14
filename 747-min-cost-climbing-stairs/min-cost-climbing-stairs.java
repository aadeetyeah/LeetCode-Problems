class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int dp[] = new int[cost.length];
        Arrays.fill(dp,-1);
        return Math.min(minCost(cost,cost.length-1,dp),minCost(cost,cost.length-2,dp)); 
    }

    private int minCost(int[] cost, int index,int dp[]){
        if(index == 0 || index == 1 ){
            return cost[index];
        }
        if(index<0){
            return 0;
        }
        if(dp[index]!=-1){
            return dp[index];
        }

        int oneStep = minCost(cost,index-1,dp);
        int twoStep = minCost(cost,index-2,dp);

        dp[index] = cost[index] + Math.min(oneStep,twoStep);
        return dp[index];
    }
}