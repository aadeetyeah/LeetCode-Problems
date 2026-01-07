class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        // int dp[][] = new int[text1.length()][text2.length()];
        // for(int d[]: dp){
        //     Arrays.fill(d,-1);
        // }
        // return f(text1,text2,text1.length()-1,text2.length()-1,dp);
        return fIter(text1,text2);
    }

    private int fIter(String s1,String s2){
    int dp[][] = new int[s1.length()+1][s2.length()+1];
    for(int d[]: dp){
        Arrays.fill(d,-1);
    }
        for(int itr1 = 0;itr1<=s1.length();itr1++){
            dp[itr1][0] = 0;
        }
        for(int itr2 = 0;itr2<=s2.length();itr2++){
            dp[0][itr2] = 0;
        }

        for(int itr1 = 1;itr1<=s1.length();itr1++){
            for(int itr2 = 1;itr2<=s2.length();itr2++){
                if(s1.charAt(itr1-1) == s2.charAt(itr2-1)){
                    dp[itr1][itr2] = 1 + dp[itr1-1][itr2-1]; 
                }else{
                    dp[itr1][itr2] = Math.max(dp[itr1-1][itr2],dp[itr1][itr2-1]);
                }
            }
        }
        return dp[s1.length()][s2.length()];
    }

    private int f(String s1, String s2, int i1, int i2,int dp[][]){
        if(i1<0 || i2<0){
            return 0;
        }
        if(dp[i1][i2] != -1){
            return dp[i1][i2];
        }
        if(s1.charAt(i1) == s2.charAt(i2)){
            dp[i1][i2] = 1 + f(s1,s2,i1-1,i2-1,dp);
        }else{
            dp[i1][i2] = Math.max(f(s1,s2,i1-1,i2,dp),f(s1,s2,i1,i2-1,dp));
        }
        return dp[i1][i2];
    }
}