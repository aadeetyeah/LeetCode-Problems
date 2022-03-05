class Solution {
     /*public int numberOfArithmeticSlices(int[] nums) {
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
    } */
    
    public int numberOfArithmeticSlices(int[] nums) {
        if(nums.length<3 || nums==null){
            return 0;
        }
        int arr[]=new int[nums.length];
        for(int itr1=2;itr1<nums.length;itr1++){
            
            if(nums[itr1]-nums[itr1-1]==nums[itr1-1]-nums[itr1-2]){
                arr[itr1]=arr[itr1-1]+1;
            }
        }
        int count=0;
        for(int itr1=2;itr1<arr.length;itr1++){
            count+=arr[itr1];
        }
        return count;
        
    }

}