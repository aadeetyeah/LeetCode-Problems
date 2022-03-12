class Solution {
    public double champagneTower(int poured1, int query_row, int query_glass) {
        double dp[][]=new double[query_row+2][query_row+2];
    
        dp[0][0]=(double)poured1;
        double poured=0;
        for(int itr1=0;itr1<query_row+1;itr1++){
            System.out.println(itr1);
            for(int itr2=0;itr2<=itr1;itr2++){
                if(dp[itr1][itr2]>1){
                    poured=dp[itr1][itr2];
                    dp[itr1][itr2]=1;
                    poured=poured-dp[itr1][itr2];
                    dp[itr1+1][itr2]+=poured/2;
                    dp[itr1+1][itr2+1]+=poured/2;
                }
            }
        }
        return dp[query_row][query_glass];
    }
}