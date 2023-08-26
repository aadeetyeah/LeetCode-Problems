class Solution {
    public int rob(int[] nums) {
        
        if(nums.length==1){
            return nums[0];
        }
        
        int dp[]=new int[nums.length];
        
        Arrays.fill(dp,-1);
        int withoutLast = robAdj(nums,nums.length-2,dp,true);
        
        Arrays.fill(dp,-1);
        int withoutFirst = robAdj(nums,nums.length-1,dp,false);
        
        return Math.max(withoutLast,withoutFirst);
    }
    
    private int robAdj(int nums[],int index,int dp[],boolean flag){
        
        if(flag){
         if(index<0){
            return 0;
        }
        if(index==0){
            return nums[0];
        }   
        }else{
         if(index<1){
             System.out.println(index);
            return 0;
        }
        if(index==1){
            System.out.println("index:"+index);
            return nums[1];
        }   
        }
        
        if(dp[index]!=-1){
            return dp[index];
        }
        
        int rob = nums[index] + robAdj(nums,index-2,dp,flag);
        int norob = robAdj(nums,index-1,dp,flag);
        
        dp[index]=Math.max(rob,norob);
        return dp[index];
    }
}