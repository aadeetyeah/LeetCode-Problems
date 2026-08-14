class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int dp[] = new int[cost.length];
        Arrays.fill(dp,-1);
        // return Math.min(minCost(cost,cost.length-1,dp),minCost(cost,cost.length-2,dp)); 
        return minCostIterative(cost);
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

    private int minCostIterative(int cost[]){
        int dp[] = new int[cost.length];

        for(int itr1 = 0;itr1<cost.length;itr1++){
            if(itr1<2)
                dp[itr1] = cost[itr1];
            else
                dp[itr1] = cost[itr1] + Math.min(dp[itr1-1],dp[itr1-2]);
        }
        return Math.min(dp[cost.length-1],dp[cost.length-2]);
    }
}