class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        return helper(nums,k) - helper(nums,k-1);
    }

    private int helper(int[] nums, int goal) {
        if(goal<0){
         return 0;
        }
       int count = 0, sum = 0;
       int left = 0, right = 0;

       while(right < nums.length){
        sum+=nums[right]%2;

        while(sum > goal){
            sum-=nums[left]%2;
            left++;
        }

        if(sum<=goal){
            count = count + right -left +1;
        }
        right++;
       }
       return count; 
    }
}