class Solution {
    public int longestOnes(int[] nums, int k) {
        int zeros = 0, left  =0, right = 0;

        int maxLen = 0;

        while(right<nums.length){
            if(nums[right] == 0){
                zeros++;
            }
            if(zeros>k){
                if(nums[left]==0){
                    zeros--;
                }
                left++;
            }else{
                maxLen = Math.max(maxLen,right-left+1);
            }
            right++;
        }
        return maxLen;
    }
}