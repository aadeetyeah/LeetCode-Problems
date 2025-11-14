class Solution {
    public int minFallingPathSum(int[][] matrix) {
        return minPathIterative(matrix);

        // int min = (int) 1e9;
        // int row = matrix.length-1;
        // int dp[][] = new int[row+1][matrix[0].length];
        // for (int i = 0; i < dp.length; i++) {
        //     Arrays.fill(dp[i], -1); 
        // }

        // for(int itr1=0; itr1<matrix[0].length;itr1++){
        //     min = Math.min(min,minPath(row,itr1,matrix,dp));
        // }
        // return min;
    }

    private int minPathIterative(int[][] mat){
        int row = mat.length;
        int col = mat[0].length;
        int dp[][] = new int[row][col];
        
        for(int itr1=0; itr1< col; itr1++){
            dp[0][itr1] = mat[0][itr1];
        }
        
        for(int itr1=1; itr1<row;itr1++){
            for(int itr2=0;itr2<col;itr2++){
                int left = (int) 1e9;
                int right = (int) 1e9;
                if(itr2>0)
                    left = mat[itr1][itr2] + dp[itr1-1][itr2-1];
                int down = mat[itr1][itr2] + dp[itr1-1][itr2];
                if(itr2+1<col)
                    right = mat[itr1][itr2]+ dp[itr1-1][itr2+1];
                dp[itr1][itr2] = Math.min(Math.min(left,down),right);
            }
        }
        int min = (int) 1e9;
        for(int itr1 =0;itr1<col;itr1++){
            min = Math.min(min,dp[row-1][itr1]);
        }
        return min;   
    }
    
    private int minPath(int row, int col, int[][] matrix,int dp[][]){
        if(col < 0 || col>= matrix[0].length){
            return (int) 1e9;
        }
        if(row == 0){
            return matrix[row][col];
        }
        if(dp[row][col]!=-1){
            return dp[row][col];
        }
        
        int left = matrix[row][col] + minPath(row-1,col-1,matrix,dp);
        int up = matrix[row][col] + minPath(row-1,col,matrix,dp);
        int right = matrix[row][col] + minPath(row-1,col+1,matrix,dp);
        dp[row][col] = Math.min(Math.min(left,up),right);
        return dp[row][col];
    }
}