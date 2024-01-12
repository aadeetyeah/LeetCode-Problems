class Solution {
    public int[] getConcatenation(int[] nums) {
        int ans[] = new int[nums.length*2];
        
        for(int itr1=0;itr1<nums.length;itr1++){
            ans[itr1] = nums[itr1];
            ans[nums.length+itr1] = nums[itr1];
        }
        
        return ans;
    }
}