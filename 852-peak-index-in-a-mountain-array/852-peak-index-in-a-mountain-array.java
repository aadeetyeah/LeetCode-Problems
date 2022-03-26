class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int start=1;
        int end=arr.length-2;
        
        int mid;
        int ans=-1;
        while(start<=end){
            mid=(start+end)/2;
           /* if(start==0){
                start++;
                continue;
            }
            if(end==arr.length-1){
                end--;
                continue;
            }*/
            
            if(arr[mid]>arr[mid-1] && arr[mid]>arr[mid+1]){
                ans= mid;
                break;
            }else if(arr[mid]<arr[mid-1]){
                end=mid-1;
            }else{
                start=mid+1;
            }
        }
        return ans;
    }
}