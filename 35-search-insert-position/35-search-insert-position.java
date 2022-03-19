class Solution {
    public int searchInsert(int[] arr, int x) {
        int start=0;
        int end=arr.length-1;
        int ans=-1;
        int mid;
        
        while(start<=end){
            mid=(start+end)/2;
            if(arr[mid]==x){
                return mid;
            }else if(arr[mid]<x){
                
                start=mid+1;
            }else{
                ans=mid;
                end=mid-1;
            }
        }
        return ans==-1?arr.length:ans;
    }
}