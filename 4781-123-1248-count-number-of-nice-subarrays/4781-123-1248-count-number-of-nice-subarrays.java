class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        return numSubArrayLessOrEqualToGoal(nums,k) - numSubArrayLessOrEqualToGoal(nums,k-1);
    }

    private int numSubArrayLessOrEqualToGoal(int nums[],int goal){
        if(goal<0){
            return 0;
        }
        int sum = 0, num = 0;
        int left = 0, right = 0;

        while( right < nums.length){
            sum += (nums[right]%2);

            while( sum > goal ){
                sum -= (nums[left]%2);
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