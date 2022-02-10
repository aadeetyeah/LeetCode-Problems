// { Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class DriverClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            int V = sc.nextInt();
            int E = sc.nextInt();
            for (int i = 0; i < V + 1; i++)
                list.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                list.get(u).add(v);
            }
            if (new Solution().isCyclic(V, list) == true)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}// } Driver Code Ends


/*Complete the function below*/

class Solution {
    // Function to detect cycle in a directed graph.
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        // code here
        int visited[]=new int[V];
        int recStack[]=new int[V];
        for(int itr1=0;itr1<V;itr1++){
            if(checkCyclic(visited,recStack,itr1,adj)){
                return true;
            }
        }
        return false;
    }
    
    public boolean checkCyclic(int[] visited,int recStack[],int src,ArrayList<ArrayList<Integer>> adj){
        visited[src]=1;
        recStack[src]=1;
        List<Integer> l1 =adj.get(src);
        for(Integer i1 : l1){
            if(visited[i1]==0){
                if(checkCyclic(visited,recStack,i1,adj)){
                    return true;
                }
            }else{
                 if(recStack[i1]==1){
                    return true;
                 }
            }
        }
        
        
        recStack[src]=0;
        return false;
    }
}
