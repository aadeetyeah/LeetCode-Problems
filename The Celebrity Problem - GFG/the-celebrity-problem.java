// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*; 

class GFG{
    public static void main(String args[]) throws IOException { 
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t>0)
        {
            int N = sc.nextInt();
            int M[][] = new int[N][N];
            for(int i=0; i<N; i++)
            {
                for(int j=0; j<N; j++)
                {
                    M[i][j] = sc.nextInt();
                }
            }
            System.out.println(new Solution().celebrity(M,N));
            t--;
        }
    } 
} // } Driver Code Ends


//User function Template for Java


class Solution
{ 
    //Function to find if there is a celebrity in the party or not.
    int celebrity(int M[][], int n)
    {
    	// code here 
    	int inDeg[]=new int[n];
    	int outDeg[]=new int[n];
    	for(int itr1=0;itr1<n;itr1++){
    	    for(int itr2=0;itr2<n;itr2++){
    	        if(M[itr1][itr2]==1){
    	            inDeg[itr2]++;
    	            outDeg[itr1]++;
    	        }
    	    }
    	}
    	for(int itr1=0;itr1<n;itr1++){
    	    if(inDeg[itr1]==n-1 && outDeg[itr1]==0){
    	        return itr1;
    	    }
    	}
    	return -1;
    }
}