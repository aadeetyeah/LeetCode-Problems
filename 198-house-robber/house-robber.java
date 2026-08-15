class Solution {
    public int rob(int[] nums) {
        int dp[] = new int[nums.length];
        Arrays.fill(dp,-1);
        return robF(nums,nums.length-1,dp);
    }

    private int robF(int nums[], int index,int dp[]){
        if(index < 0){
            return 0;
        }
        if(dp[index]!=-1){
            return dp[index];
        }
        int rob = nums[index] + robF(nums,index-2,dp);
        int drob = robF(nums,index-1,dp);
        dp[index] = Math.max(rob,drob);
        return dp[index];
    }
}