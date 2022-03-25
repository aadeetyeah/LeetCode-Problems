class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        Arrays.sort(nums);
        
        
        
        List<Integer> l1=new ArrayList<>();
        
        int first=firstHalf(nums,target);
        if(first==-1){
            return l1;
        }
        
        int last=secondHalf(nums,target);
        
        for(int itr1=first;itr1<=last;itr1++){
            l1.add(itr1);
        }
        return l1;
    }
    
    private int firstHalf(int[] nums,int target){
        int start=0;
        int end=nums.length-1;
        int mid;
        
        int firstIndex=-1;
        while(start<=end){
            mid=(start+end)/2;
            
            if(nums[mid]==target){
                firstIndex=mid;
                end=mid-1;
            }else if(nums[mid]>target){
               end=mid-1;
            }else{
                start=mid+1;
            }
        }
        return firstIndex;
    }
    private int secondHalf(int[] nums,int target){
        int start=0;
        int end=nums.length-1;
        int mid;
        
        int secondIndex=-1;
        while(start<=end){
            mid=(start+end)/2;
            
            if(nums[mid]==target){
                secondIndex=mid;
                start=mid+1;
            }else if(nums[mid]>target){
               end=mid-1;
            }else{
                start=mid+1;
            }
        }
        return secondIndex;
    }
}