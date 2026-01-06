class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int dp[][] = new int[text1.length()][text2.length()];
        for(int d[]: dp){
            Arrays.fill(d,-1);
        }
        return f(text1,text2,text1.length()-1,text2.length()-1,dp);
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