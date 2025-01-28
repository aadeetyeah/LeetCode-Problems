class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
       return numSubArrayLessOrEqualToGoal(nums,goal) - numSubArrayLessOrEqualToGoal(nums,goal-1);
    }

    private int numSubArrayLessOrEqualToGoal(int nums[],int goal){
        if(goal<0){
            return 0;
        }
        int sum = 0, num = 0;
        int left = 0, right = 0;

        while( right < nums.length){
            sum += nums[right];

            while( sum > goal ){
                sum -= nums[left];
                left++;
            }

            if(sum <= goal){
                num = num + right - left +1 ;
            }
            right++;
        }
        return num;
    }
}