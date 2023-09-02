//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            String input_line[] = in.readLine().trim().split("\\s+");
            int Matrix[][] = new int[N][N];
            for(int i = 0; i < N*N; i++)
                Matrix[(i/N)][i%N] = Integer.parseInt(input_line[i]);
            
            Solution ob = new Solution();
            System.out.println(ob.maximumPath(N, Matrix));
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution{
    static int maximumPath(int N, int Matrix[][])
    {
        // code here
        int max= Integer.MIN_VALUE;
        int dp[][] = new int[Matrix.length][Matrix[0].length];
        
        for(int itr1=0;itr1<Matrix[0].length;itr1++){
            max= Math.max(max,maxPathSum(Matrix,Matrix.length-1,itr1,dp));
        }
        return max;
    }
    static int maxPathSum(int matrix[][],int row,int col,int dp[][]){
        
        if(col<0 || col>=matrix[0].length){
            return Integer.MIN_VALUE;
        }
        if(row==0){
            return matrix[row][col];
        }
        
        if(dp[row][col]!=0){
            return dp[row][col];
        }
        
        int left = maxPathSum(matrix,row-1,col-1,dp);
        int up   = maxPathSum(matrix,row-1,col,dp);
        int right= maxPathSum(matrix,row-1,col+1,dp);
        
        int result = matrix[row][col];
        result+=Math.max(Math.max(left,up),right);
        dp[row][col]=result;
        return result;
        
    }
}