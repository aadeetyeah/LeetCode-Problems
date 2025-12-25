class Solution {
    public int change(int amount, int[] coins) {
        // int dp[][] = new int[coins.length][amount+1];
        // for(int d[] : dp){
        //     Arrays.fill(d,-1);
        // }
        // return f(coins.length-1,amount,coins,dp);
        return f(amount,coins);
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

    private int f(int amount, int[] coins){
        int dp[][] = new int[coins.length][amount+1];
        for(int d[] : dp){
            Arrays.fill(d,-1);
        }
        for(int target = 0;target<=amount;target++){
            dp[0][target] = (target%coins[0] == 0)?1:0 ;
        }

        for(int index=1;index<coins.length;index++){
            for(int itr2=0;itr2<=amount;itr2++){
                int notTake = dp[index-1][itr2];
                int take = 0;
                if(coins[index]<=itr2){
                    take = dp[index][itr2-coins[index]];
                }
                dp[index][itr2] = take+notTake;
            }
        }
        return dp[coins.length-1][amount];
    }
}