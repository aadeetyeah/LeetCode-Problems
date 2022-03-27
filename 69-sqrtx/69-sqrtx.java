class Solution {
    public int mySqrt(int x) {
         long start=0;
         long end=x/2;
        
         long mid;
         long ans=1;
        if(x==1){
            return (int)ans;
        }
        while(start<=end){
            mid=(end-start)/2 +start;
            
            if(mid*mid==x){
                ans= mid;
                return (int)ans;
            }else if(mid*mid<x){
                ans=mid;
                start=mid+1;
            }else{
                
                end=mid-1;
            }
        }
        return (int)ans;
    }
}