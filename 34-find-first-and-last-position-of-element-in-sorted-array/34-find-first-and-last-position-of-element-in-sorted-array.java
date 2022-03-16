class Solution {
    public int[] searchRange(int[] nums, int target) {
        int res[]={-1,-1};
        res[0]=findFirst(nums,target);
        if(res[0]==-1){
            return res;
        }
        res[1]=findLast(nums,target);
        
        return res;
    }
    
    private int findFirst(int nums[],int target){
        int start=0;
        int end=nums.length-1;
        
        
        int ans=-1;
        int mid;
    
        while(start<=end){
            mid=(start+end)/2;
            
            if(nums[mid]==target){
                ans=mid;
                end=mid-1;
            }else{
            if(nums[mid]<target){
                start=mid+1;
            }else{
                end=mid-1;
            }
            }
        }
        return ans;
    }
    
    private int findLast(int nums[],int target){
        int start=0;
        int end=nums.length-1;
        
        int ans=-1;
        int mid;
    
        while(start<=end){
            mid=(start+end)/2;
            
            if(nums[mid]==target){
                ans=mid;
                
                start=mid+1;
                
            }else {
            if(nums[mid]<target){
                start=mid+1;
            }else{
                end=mid-1;
            }
            }
        }
        return ans;
    }
}