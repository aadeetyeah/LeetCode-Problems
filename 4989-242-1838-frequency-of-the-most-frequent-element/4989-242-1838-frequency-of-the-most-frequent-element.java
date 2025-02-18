class Solution {
    public int maxFrequency(int[] nums, int k) {
        
        long sum = 0;
        int left = 0, right = 0;
        int maxLen = 0;

        Arrays.sort(nums);
        
        while(right < nums.length){
            sum+= nums[right];

            while((long)nums[right]*(right-left+1) > sum+k){
                sum-=nums[left];
                left++;
            }
            maxLen = Math.max(maxLen, right-left+1);
            right++;
        }
        return maxLen;
    }
}