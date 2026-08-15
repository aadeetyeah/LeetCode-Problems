class Solution {
    public int rob(int[] nums) {
        // int dp[] = new int[nums.length];
        // Arrays.fill(dp,-1);
        // return robF(nums,nums.length-1,dp);
        return robI(nums);
    }

    private int robI(int nums[]){
        int dp[] = new int[nums.length];
        Arrays.fill(dp,-1);
        dp[0] = nums[0];
        for(int itr1=1;itr1<nums.length;itr1++){
            int rob = nums[itr1];
            if(itr1>=2){
                rob = nums[itr1] + dp[itr1-2];
            }
            int drob = dp[itr1-1];
            dp[itr1] = Math.max(rob,drob);
        }
        return dp[nums.length-1];
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