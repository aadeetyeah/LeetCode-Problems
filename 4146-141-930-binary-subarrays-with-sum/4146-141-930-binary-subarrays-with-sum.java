class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        
        return numOfSubarray(nums,goal)-numOfSubarray(nums,goal-1);
    }
    
    private int numOfSubarray(int[] nums, int goal){
        int l = 0, r = 0;
        int cnt = 0;
        int sum = 0;
        
        if(goal<0)
            return 0;
        
        while(r < nums.length){
            sum+=nums[r];
            
            while(sum > goal){
                sum-=nums[l];
                l++;
            }
            
            cnt += r-l+1;
            r++;
        }
        return cnt;
    }
}