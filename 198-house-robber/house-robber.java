class Solution {
    public int rob(int[] nums) {
        int dp[] = new int[nums.length];
        Arrays.fill(dp,-1);
        // return rob(nums,nums.length-1,dp);
        return robIter(nums);
    }

    private int robIter(int nums[]){
        int dp[] = new int[nums.length];
        dp[0] = nums[0];
        for(int itr1=1; itr1<nums.length; itr1++){
            int pick = nums[itr1];
            if(itr1>1){
                pick +=  dp[itr1-2];
            }
            int notpick = dp[itr1-1];
            dp[itr1] = Math.max(pick, notpick);
        }

        return dp[nums.length-1];
    }

    private int rob(int[] nums, int index,int dp[]){

        if(index == 0){
            return nums[0];
        }
        if(index < 0){
            return 0;
        }        
        if(dp[index]!=-1){
            return dp[index];
        }
        int pick = nums[index] + rob(nums,index-2,dp);
        int notpick = rob(nums,index-1,dp);

        dp[index] = Math.max(pick,notpick);
        return dp[index];
    }
}