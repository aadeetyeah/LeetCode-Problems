class Solution {
    public int minFallingPathSum(int[][] matrix) {
        return minPathIter(matrix);
    }


    private int minPathIter(int mat[][]){
        int r =  mat.length;
        int c = mat[0].length;
        int dp[][] = new int[r][c];
        for(int d[]: dp){
            Arrays.fill(d,0);
        }
        for(int itr1=0;itr1<c;itr1++){
            dp[0][itr1] = mat[0][itr1];
        }
        
        for(int itr1=1;itr1<r;itr1++){
            for(int itr2=0;itr2<c;itr2++){
                int left  = (int) 1e9;
                int right = (int) 1e9;
                int up = 0;
                
                if(itr2>0){
                    left = dp[itr1-1][itr2-1];
                }
                up = dp[itr1-1][itr2];
                if(itr2<c-1){
                    right = dp[itr1-1][itr2+1];
                }
                dp[itr1][itr2] = mat[itr1][itr2] 
                                    + Math.min(up,Math.min(left,right));
            }
        }
        int min = (int) 1e9;
        for (int j = 0; j < c; j++) {
                min = Math.min(min, dp[r - 1][j]);
            }
            return min;
    }
}