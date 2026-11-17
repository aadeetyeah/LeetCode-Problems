class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int leftSum = 0;
        int rightSum = 0;
        int maxScore = 0;
        for(int itr1=0;itr1<k;itr1++){
            leftSum+=cardPoints[itr1];
        }
        maxScore = leftSum;

        int rightIndex = cardPoints.length-1;
        for(int itr2=k-1;itr2>=0;itr2--){
            leftSum-=cardPoints[itr2];
            rightSum+=cardPoints[rightIndex];
            maxScore = Math.max(maxScore, leftSum+rightSum);
            rightIndex--;
        }
        return maxScore;
    }
}