class Solution {
    public int maxSubArray(int[] nums) {
        int max=Integer.MIN_VALUE;
        int sum=0;
        
        for(int itr1=0;itr1<nums.length;itr1++){
            sum+=nums[itr1];
            if(max<sum){
                max=sum;
            }
            if(sum<0){
                sum=0;
            }
        }
        return max;        
    }
}