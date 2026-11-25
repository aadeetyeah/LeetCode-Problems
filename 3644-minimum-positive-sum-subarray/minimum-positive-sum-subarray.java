class Solution {
    public int minimumSumSubarray(List<Integer> nums, int l, int r) {
        return helper(nums,l,r);
    }

    private int helper(List<Integer> nums,int l, int r){
        int minsum = Integer.MAX_VALUE;

        for(int k = l;k<=r;k++){
            int sum = 0;
            for(int itr2 = 0; itr2<nums.size();itr2++){
                sum+=nums.get(itr2);

                if(itr2>=k){
                    sum-=nums.get(itr2-k);
                }

                if(itr2>=k-1 && sum>0){
                    minsum = Math.min(sum,minsum);
                }
            }
        }
        return minsum == Integer.MAX_VALUE ? -1:minsum;
    }
}