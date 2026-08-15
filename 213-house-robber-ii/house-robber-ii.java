class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }
        int nums1[] = new int[nums.length-1];
        int nums2[] = new int[nums.length-1];
        for(int itr1 = 0;itr1<nums.length-1;itr1++){
            nums1[itr1] = nums[itr1];
            nums2[itr1] = nums[itr1+1];
        }

        int first = robI(nums1);
        int second = robI(nums2);
        return Math.max(first,second);
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
}