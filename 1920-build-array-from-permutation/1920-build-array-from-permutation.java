class Solution {
    public int[] buildArray(int[] nums) {
        int ans[] = new int[nums.length];
        for(int itr1 = 0; itr1<nums.length;itr1++){
            ans[itr1] = nums[nums[itr1]];
        }
        return ans;
    }
}