// { Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for (int i = 0; i < V; i++) adj.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            boolean ans = obj.isCycle(V, adj);
            if (ans)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}// } Driver Code Ends


class Solution {
    // Function to detect cycle in an undirected graph.
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        HashSet<Integer> visited=new HashSet<>();
        for(int itr1=0;itr1<V;itr1++){
         if(checkCyclic(itr1,adj,-1,visited)){
             return true;
         }
         
        }
        return false;
    }
    
    private boolean checkCyclic(int src,ArrayList<ArrayList<Integer>> graph,int parent,HashSet<Integer> vis ){
        vis.add(src);
        ArrayList<Integer> l1=graph.get(src);
        
        for(Integer itr1 : l1){
            if(!vis.contains(itr1)){
                if(checkCyclic(itr1,graph,src,vis)){
                    return true;
                }
            }else{
                if(parent!=itr1){
                    return true;
                }
            }
        }
        vis.remove(src);
        return false;
    }
}