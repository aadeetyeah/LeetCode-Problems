class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int start=0;
        int end=letters.length-1;
        
        int mid;
        char answer=letters[start];
        
        while(start<=end){
            mid=(start+end)/2;
            
            if(letters[mid]==target){
                start=mid+1;
            }else if(letters[mid]>target){
                answer=letters[mid];
                end=mid-1;
            }else{
                start=mid+1;
            }
            
        }
        return answer;
    }
}