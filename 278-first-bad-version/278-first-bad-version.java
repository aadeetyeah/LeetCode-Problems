/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int start=1;
        int end=n;
        
        int mid;
        int answer=0;
        while(start<=end){
            mid=start+(end-start)/2;
            if(!isBadVersion(mid)){
                
                start=mid+1;
            }else{
                answer=mid;
                end=mid-1;
            }
        }
        return answer;
    }
}