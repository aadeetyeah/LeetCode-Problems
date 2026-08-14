class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int dp[] = new int[cost.length];
        Arrays.fill(dp,-1);
        return Math.min(minCost(cost,0,dp),minCost(cost,1,dp)); 
    }

    private int minCost(int[] cost, int index,int dp[]){
        if(index == cost.length-1 ){
            return cost[cost.length-1];
        }
        if(index>=cost.length){
            return 0;
        }
        if(dp[index]!=-1){
            return dp[index];
        }

        int oneStep = minCost(cost,index+1,dp);
        int twoStep = minCost(cost,index+2,dp);

        dp[index] = cost[index] + Math.min(oneStep,twoStep);
        return dp[index];
    }
}