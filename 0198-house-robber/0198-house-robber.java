class Solution {
    public int rob(int[] arr) {
        // int dp[]=new int[nums.length+1];
        // Arrays.fill(dp,-1);
        // return robAdj(nums,nums.length-1,dp);
        
        int dp[]=new int[arr.length];
        dp[0]= arr[0];
        int n = arr.length;
        for(int itr1=1;itr1<arr.length;itr1++){
            
            int pick = arr[itr1];
            if(itr1-2>=0){
                pick += dp[itr1-2];
            }
            int notPick = dp[itr1-1];
            
            dp[itr1] = Math.max(pick,notPick);
        }
        return dp[n-1];
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