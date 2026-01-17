// User function Template for Java

class Solution {
    public int longestCommonSubstr(String s1, String s2) {
        // code here
        return fIter(s1,s2);
    }
    
    private static int fIter(String s1,String s2){
        int dp[][] = new int[s1.length()+1][s2.length()+1];
        int ans = 0;
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
                    ans = Math.max(ans,dp[itr1][itr2]);
                }else{
                    dp[itr1][itr2] = 0;
                }
            }
        }
        return ans;
    }

    private static int f(String s1, String s2, int i1, int i2,int dp[][]){
        if(i1<0 || i2<0){
            return 0;
        }
        if(dp[i1][i2] != -1){
            return dp[i1][i2];
        }
        if(s1.charAt(i1) == s2.charAt(i2)){
            dp[i1][i2] = 1 + f(s1,s2,i1-1,i2-1,dp);
        }else{
            dp[i1][i2] = 0;
        }
        return dp[i1][i2];
    }
}