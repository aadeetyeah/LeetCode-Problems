// { Driver Code Starts
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
            String[] S = br.readLine().trim().split(" ");
            int V = Integer.parseInt(S[0]);
            int E = Integer.parseInt(S[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for(int i = 0; i < V; i++){
                adj.add(new ArrayList<Integer>());
            }
            for(int i = 0; i < E; i++){
                String[] s = br.readLine().trim().split(" ");
                int u = Integer.parseInt(s[0]);
                int v = Integer.parseInt(s[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            boolean ans = obj.isBipartite(V, adj);
            if(ans)
                System.out.println("1");
            else System.out.println("0");
       }
    }
}// } Driver Code Ends


class Solution
{
    public boolean isBipartite(int V, ArrayList<ArrayList<Integer>>adj)
    {
        // Code here
        int[] color=new int[V];
        Arrays.fill(color,-1);
        
        for(int itr1=0;itr1<V;itr1++){
            
            if(color[itr1]==-1){
                if(!checkBipartite(itr1,adj,color,0)){
                    return false;
                }
            }
        }
        return true;
    }
    
    private boolean checkBipartite(int src,ArrayList<ArrayList<Integer>> adj,int colorArr[],int color){
        Queue<Integer> q1=new LinkedList<>();
        q1.add(src);
        colorArr[src]=color;
        while(!q1.isEmpty()){
            int par=q1.remove();
            for(Integer itr1 : adj.get(par)){
                if(colorArr[itr1]==-1){
                    colorArr[itr1]=(colorArr[par]==0?1:0);
                    q1.add(itr1);
                }else{
                    if(colorArr[itr1]==colorArr[par]){
                        return false;
                    }
                }
            }
        }
        return true;
    }
}