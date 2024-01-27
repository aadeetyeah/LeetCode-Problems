class Solution {
    public int maximumWealth(int[][] accounts) {
        int max = 0;
        int sum = 0;
        for(int itr1=0;itr1<accounts.length;itr1++){
            sum = 0;
            for(int itr2=0;itr2<accounts[0].length;itr2++){
                sum+=accounts[itr1][itr2];
            }
            if(max<sum){
                max = sum;
            }
        }
        return max;
    }
}