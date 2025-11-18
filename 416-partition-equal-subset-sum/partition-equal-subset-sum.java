class Solution {
    public boolean canPartition(int[] nums) {
        int totalSum = 0;
        for(int num : nums){
            totalSum+=num;
        }
        if(totalSum%2==1){
            return false;
        }
        return subsetSumIterative(nums,totalSum/2);
    }

    boolean subsetSumIterative(int arr[], int target){
        boolean[][] dp = new boolean[arr.length][target+1];
        for(int itr1=0; itr1<arr.length; itr1++){
            dp[itr1][0] = true;
        }
       if (arr[0] <= target) {
        dp[0][arr[0]] = true;
        }
        
        for(int itr1= 1;itr1<arr.length;itr1++){
            for(int itr2=1;itr2<=target;itr2++){
                boolean take = false;
                if(arr[itr1]<=itr2){
                    take = dp[itr1-1][itr2-arr[itr1]];
                }
                boolean notTake = dp[itr1-1][itr2];
                
                dp[itr1][itr2] = take || notTake;
            }
        }
        return dp[arr.length-1][target];
    }
}