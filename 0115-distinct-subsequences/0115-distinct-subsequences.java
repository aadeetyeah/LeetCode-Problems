class Solution {
    public int numDistinct(String s, String t) {
        int l1 = s.length();
        int l2 = t.length();
        int dp[][] = new int[l1][l2];
        for(int d[] : dp){
            Arrays.fill(d,-1);
        }
        return f(s,t,l1-1,l2-1,dp);
    }

    private int f(String s1, String s2, int i1, int i2,int dp[][]){

        if(i2 < 0){
            return 1;
        }
        if(i1 < 0){
            return 0;
        }

        if(dp[i1][i2] != -1){
            return dp[i1][i2];
        }
        if(s1.charAt(i1) == s2.charAt(i2)){
            dp[i1][i2] = f(s1,s2,i1-1,i2-1,dp) + f(s1,s2,i1-1,i2,dp);
        }else{
            dp[i1][i2] = f(s1,s2,i1-1,i2,dp); 
        }
        return dp[i1][i2];
    }
}