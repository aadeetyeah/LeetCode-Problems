class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return helper(nums,k) - helper(nums,k-1);
    }

    private int helper(int nums[],int k){
        int left = 0, right = 0;
        int count = 0;
        Map<Integer,Integer> memo = new HashMap<>();

        while(right<nums.length){
            memo.put(nums[right],memo.getOrDefault(nums[right],0)+1);
            while(memo.size()>k){
                memo.put(nums[left],memo.get(nums[left])-1);
                if(memo.get(nums[left])==0){
                    memo.remove(nums[left]);
                }
                left++;
            }
            if(memo.size()<=k){
                count+=right-left+1;
            }
            right++;
        }
        return count;
    }
}