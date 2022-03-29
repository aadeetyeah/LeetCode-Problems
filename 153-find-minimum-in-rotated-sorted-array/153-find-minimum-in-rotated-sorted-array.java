class Solution {
    public int findMin(int[] nums) {
        int start=0;
        int end=nums.length-1;
        
        int mid;
        int ans=0;
        if(nums[start]<=nums[end]){
            return nums[start];
        }
        
        while(start<=end){
            mid=(start+end)/2;
            
            if(nums[mid+1]<nums[mid]){
                ans= mid+1;
                break;
            }
            if(nums[mid]<nums[mid-1]){
                ans= mid;
                break;
            }
            if(nums[start]<nums[mid]){
                start=mid+1;
            }else{
                end=mid-1;
            }
        }
        return nums[ans];
    }
}