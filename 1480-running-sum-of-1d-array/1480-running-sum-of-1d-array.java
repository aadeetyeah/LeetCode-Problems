class Solution {
    public int[] runningSum(int[] nums) {
        int sum = 0;
        
        for(int itr1 = 0;itr1<nums.length;itr1++){
            sum = nums[itr1] + sum;
            nums[itr1] = sum;
        }
        return nums;
    }
}