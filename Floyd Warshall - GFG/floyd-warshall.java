// { Driver Code Starts
//Initial template for JAVA

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            int[][] matrix = new int[n][n];
            for(int i = 0; i < n; i++){
                String[] s = br.readLine().trim().split(" ");
                for(int j = 0; j < n; j++)
                    matrix[i][j]  =Integer.parseInt(s[j]);
            }
            Solution obj = new Solution();
            obj.shortest_distance(matrix);
            for(int i = 0; i < n; i++){
                for(int j  = 0; j < n; j++){
                    System.out.print(matrix[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}
// } Driver Code Ends


//User function template for JAVA

class Solution
{
    public void shortest_distance(int[][] matrix)
    {
        // Code here 
        for(int itr1=0;itr1<matrix.length;itr1++){
            for(int itr2=0;itr2<matrix.length;itr2++){
                if(matrix[itr1][itr2]==-1){
                    matrix[itr1][itr2]=Integer.MAX_VALUE;
                }
            }
        }
        
        for(int itr3=0;itr3<matrix.length;itr3++){
            for(int itr1=0;itr1<matrix.length;itr1++){
                for(int itr2=0;itr2<matrix.length;itr2++){
                    if(itr1==itr3 || itr2==itr3 || itr1==itr2){
                        continue;
                    }else{
                        if(matrix[itr1][itr3]==Integer.MAX_VALUE || matrix[itr3][itr2]==Integer.MAX_VALUE){
                            continue;
                        }else{
                            matrix[itr1][itr2]=Math.min(matrix[itr1][itr2],matrix[itr1][itr3]+matrix[itr3][itr2]);
                        }
                    }
                    
                }
            }
        }
        for(int itr1=0;itr1<matrix.length;itr1++){
            for(int itr2=0;itr2<matrix.length;itr2++){
                if(matrix[itr1][itr2]==Integer.MAX_VALUE){
                    matrix[itr1][itr2]=-1;
                }
            }
        }
    }
}