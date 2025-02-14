class Solution {
    public long continuousSubarrays(int[] nums) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        int left = 0, right = 0;
        long count = 0;

        while(right < nums.length){
            min = Math.min(nums[right],min);
            max = Math.max(nums[right],max);

            if(max - min > 2){
                left = right;
                min = nums[left];
                max = nums[left];

                while(left - 1 >= 0 && Math.abs(nums[left - 1] - nums[right]) <=2){
                    left--;
                    min = Math.min(nums[left],min);
                    max = Math.max(nums[left],max);
                }
            }
            count += (right - left +1);
            right++;
        }
        return count;
    }
}