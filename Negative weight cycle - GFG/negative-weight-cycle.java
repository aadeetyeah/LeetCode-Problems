// { Driver Code Starts
//Initial Template for Java

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
            String[] S1 = br.readLine().trim().split(" ");
            int n = Integer.parseInt(S1[0]);
            int m = Integer.parseInt(S1[1]);
            int[][] edges = new int[m][3];
            for(int i = 0; i < m; i++){
                String S2[] = br.readLine().trim().split(" ");
                for(int j = 0; j < 3; j++)
                    edges[i][j] = Integer.parseInt(S2[j]);
            }
            Solution obj = new Solution();
            int ans = obj.isNegativeWeightCycle(n, edges);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int isNegativeWeightCycle(int n, int[][] edges)
    {
        //code here
        int dist[]=new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[0]=0;
        
        int u,v,w;
        for(int itr1=0;itr1<n-1;itr1++){
            for(int i=0;i<edges.length;i++){
                u=edges[i][0];
                v=edges[i][1];
                w=edges[i][2];
                if(dist[u]!=Integer.MAX_VALUE && dist[v]>dist[u]+w ){
                    dist[v]=dist[u]+w;
                }
            }
        }
        for(int i=0;i<edges.length;i++){
                u=edges[i][0];
                v=edges[i][1];
                w=edges[i][2];
                if(dist[u]!=Integer.MAX_VALUE && dist[v]>dist[u]+w){
                    dist[v]=dist[u]+w;
                    return 1;
                }
            }
            return 0;
    }
}