class Solution {
    public int change(int amount, int[] coins) {
        int dp[][] = new int[coins.length][amount+1];
        for(int d[] : dp){
            Arrays.fill(d,-1);
        }
        return f(coins.length-1,amount,coins,dp);
    }

    private int f(int index, int amount, int[] coins, int dp[][]){
        if(index == 0){
            if(amount%coins[index] == 0){
                return 1;
            }
            return 0;
        }

        if(dp[index][amount]!=-1){
            return dp[index][amount];
        }
        
        int notTake = f(index-1, amount, coins,dp);
        int take = 0;
        if(coins[index]<=amount){
            take = f(index, amount-coins[index], coins,dp);
        }
        dp[index][amount] = take+notTake;
        return dp[index][amount];
    }
}