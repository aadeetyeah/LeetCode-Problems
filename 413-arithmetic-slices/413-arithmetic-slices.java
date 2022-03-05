class Solution {
     public int numberOfArithmeticSlices(int[] nums) {
        if(nums==null || nums.length==0)
        {
            return 0;
        }
        int dp[]=new int[nums.length];
        int res=0;
        for(int i=2;i<nums.length;i++)
        {
            if((nums[i]-nums[i-1])==(nums[i-1]-nums[i-2]))
            {
                dp[i]=dp[i-1]+1;
                res=res+dp[i];
            }
        }
        return res;
    }
}