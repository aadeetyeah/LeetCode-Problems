class Solution {
    public int knapSack(int val[], int wt[], int capacity) {
        // code here
        int dp[][] = new int[wt.length][capacity+1];
        for(int d[]: dp){
            Arrays.fill(d,-1);
        }
        return f(wt.length-1,capacity,val,wt,dp);
    }
    
    private int f(int index,int target, int val[],int wt[],int dp[][]){
        
        if(index == 0){
            int n = target/wt[0];
            return n*val[0];
        }
        if(dp[index][target]!=-1){
            return dp[index][target];
        }
        int notTake = f(index-1,target,val,wt,dp);
        int take = 0;
        if(wt[index]<=target){
            take = val[index] + f(index,target-wt[index],val,wt,dp);
        }
        dp[index][target] = Math.max(notTake,take);
        return dp[index][target];
    }
}