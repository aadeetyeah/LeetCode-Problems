class Solution {
    public int rob(int[] nums) {
        int dp[]=new int[nums.length+1];
        Arrays.fill(dp,-1);
        return robAdj(nums,nums.length-1,dp);
    }
    
    private int robAdj(int nums[],int index,int dp[]){
        
        if(index<0){
            return 0;
        }
        if(index==0){
            return nums[0];
        }
        if(dp[index]!=-1){
            return dp[index];
        }
        
        int rob = nums[index] + robAdj(nums,index-2,dp);
        int norob = robAdj(nums,index-1,dp);
        
        dp[index]=Math.max(rob,norob);
        return dp[index];
    }
}