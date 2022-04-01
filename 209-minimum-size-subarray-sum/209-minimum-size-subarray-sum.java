class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int start=0;
        int end=0;
        int len1=0;
        int len2=Integer.MAX_VALUE;
        
        int sum=0;
        while(end<nums.length){
            
            
            if(sum<target){
                sum+=nums[end];
                end++;
            }else{
                len1=(end-start);
                len2=Math.min(len2,len1);
                
                sum-=nums[start];
                
                start++;
                
            }
        }
        while(start<nums.length){
            
            if(sum<target){
                break;
            }
            len1=(end-start);
            len2=Math.min(len2,len1);
            sum-=nums[start];
                
                start++;
        }
        if(len2==Integer.MAX_VALUE){
            return 0;
        }
        return len2;
    }
}