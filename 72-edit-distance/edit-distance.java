class Solution {
    public int minDistance(String word1, String word2) {
        int l1 = word1.length();
        int l2 = word2.length();
        int dp[][] = new int[l1][l2];
        for(int d[] : dp){
            Arrays.fill(d,-1);
        }
        // return f(word1,word2,l1-1,l2-1,dp);
        return fIterative(word1,word2);
    }

    private int fIterative(String word1, String word2){
        int l1 = word1.length();
        int l2 = word2.length();
        int dp[][] = new int[l1+1][l2+1];
        for(int d[] : dp){
            Arrays.fill(d,-1);
        }
        for(int itr1=0;itr1<=l1;itr1++){
            dp[itr1][0] = itr1;
        }
        for(int itr2=0;itr2<=l2;itr2++){
            dp[0][itr2] = itr2;
        }
        for(int i1=1; i1<=l1; i1++){
            for(int i2=1; i2<=l2; i2++){
                if(word1.charAt(i1-1) == word2.charAt(i2-1)){
                    dp[i1][i2] = dp[i1-1][i2-1];
                    }else{
                        dp[i1][i2] = 1 + Math.min(dp[i1][i2-1], Math.min(dp[i1-1][i2],dp[i1-1][i2-1]));
                        }
                        }
        }
        return dp[l1][l2];
    }

    private int f(String word1, String word2, int i1, int i2,int dp[][]){
        if(i1<0){ 
            return i2+1;
        }
        if(i2<0){
            return i1+1;
        }
        if(dp[i1][i2]!=-1){
            return dp[i1][i2];
        }
        if(word1.charAt(i1) == word2.charAt(i2)){
            dp[i1][i2] = f(word1,word2,i1-1,i2-1,dp);
        }else{
            dp[i1][i2] = 1 + Math.min(f(word1,word2,i1,i2-1,dp),
        Math.min(f(word1,word2,i1-1,i2,dp),f(word1,word2,i1-1,i2-1,dp)));
        }
        return dp[i1][i2];
    }
}