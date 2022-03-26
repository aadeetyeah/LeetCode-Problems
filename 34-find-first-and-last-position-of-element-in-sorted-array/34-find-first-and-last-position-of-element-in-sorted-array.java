class Solution {
    public int[] searchRange(int[] nums, int target) {
        
        int[] ans=new int[2];
        Arrays.fill(ans,-1);
        
        ans[0]=getFirstIndex(nums,target);
        if(ans[0]==-1){
            return ans;
        }
        ans[1]=getLastIndex(nums,target);
        return ans;
    }
    
    int getFirstIndex(int nums[],int target){
        int start=0;
        int end=nums.length-1;
        
        int mid;
        int answer=-1;
        while(start<=end){
            mid=(start+end)/2;
            if(nums[mid]==target){
                answer=mid;
                end=mid-1;
            }else if(nums[mid]<target){
                start=mid+1;
            }else{
                end=mid-1;
            }
        }
        return answer;
    }
    
    int getLastIndex(int nums[],int target){
        int start=0;
        int end=nums.length-1;
        
        int mid;
        int answer=-1;
        
        while(start<=end){
            mid=(start+end)/2;
            
            if(nums[mid]==target){
                answer=mid;
                start=mid+1;
            }else if(nums[mid]<target){
                start=mid+1;
            }else{
                end=mid-1;
            }
        }
        return answer;
    }
}