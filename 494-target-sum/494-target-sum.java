class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        return numOfWays(0,0,nums,target);
    }
    
    private int numOfWays(int start,int sum,int nums[],int target){
        if(sum==target && start>=nums.length){
            return 1;
        }
        if(start>=nums.length){
            return 0;
        }
        
        return numOfWays(start+1,sum+nums[start],nums,target)+numOfWays(start+1,sum-nums[start],nums,target);
    }
}