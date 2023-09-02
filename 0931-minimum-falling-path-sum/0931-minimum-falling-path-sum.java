class Solution {
    public int minFallingPathSum(int[][] matrix) {
        
        //Memoization Approach logic
//         int min=Integer.MAX_VALUE;
//         int dp[][] = new int[matrix.length][matrix[0].length];
//         for(int i[] : dp){
//             Arrays.fill(i,-1);
//         }
        
        
//         for(int itr1=0;itr1<matrix[0].length;itr1++){
//             min = Math.min(min,maxPathSum(matrix,matrix.length-1,itr1,dp));
//         }
//         return min;
        
        return minPathSum(matrix);
    }
    
    //Tabulation Approach
    private int minPathSum(int[][] matrix){
        int dp[][]= new int[matrix.length][matrix[0].length];
        for(int i[] : dp){
            Arrays.fill(i,-1);
        }
        
        for(int itr1=0;itr1<matrix[0].length;itr1++){
            dp[0][itr1] = matrix[0][itr1];
        }
        
        
        for(int itr1=1;itr1<matrix.length;itr1++){
            int left=Integer.MAX_VALUE,right=Integer.MAX_VALUE,up=Integer.MAX_VALUE;
            
            for(int itr2=0;itr2<matrix[0].length;itr2++){
                if(itr2>0)
                    left = dp[itr1-1][itr2-1];
                up = dp[itr1-1][itr2];
                if(itr2<matrix[0].length-1)
                    right = dp[itr1-1][itr2+1];
                
                dp[itr1][itr2]= matrix[itr1][itr2]+Math.min(Math.min(left,up),right);
            }
            
        }
        
        int min= Integer.MAX_VALUE;
        for(int itr1=0;itr1<matrix[0].length;itr1++){
            min = Math.min(min,dp[matrix.length-1][itr1]);
        }
        return min;
    }
    
    
    
    //Memoization Approach
//     private int maxPathSum(int matrix[][],int row,int col,int dp[][]){
        
//         if(col<0 || col>=matrix[0].length){
//             return Integer.MAX_VALUE;
//         }
//         if(row==0){
//             return matrix[row][col];
//         }
        
//         if(dp[row][col]!=-1){
//             return dp[row][col];
//         }
        
//         int left = maxPathSum(matrix,row-1,col-1,dp);
//         int up   = maxPathSum(matrix,row-1,col,dp);
//         int right= maxPathSum(matrix,row-1,col+1,dp);
        
//         int result = matrix[row][col];
//         result+=Math.min(Math.min(left,up),right);
//         dp[row][col]=result;
//         return result;
        
//     }
}