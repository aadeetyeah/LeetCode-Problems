class Solution {
    public int maxScore(int[] cardPoints, int k) {
        
        int maxSum = 0;
        int left = 0;
        int right = cardPoints.length-1;
        
        int lsum = 0;
        int rsum = 0;
        
        for(int itr1 = 0;itr1<k;itr1++){
            lsum+=cardPoints[itr1];
        }
        maxSum = lsum;
        
        int itr2 = right;
        for(int itr1 = k-1;itr1>=0;itr1--){
            lsum-=cardPoints[itr1];
            rsum+=cardPoints[itr2];
            
            if(lsum+rsum>maxSum){
                maxSum = lsum+rsum;
            }
            
            itr2--;
        }
        return maxSum;
    }
}