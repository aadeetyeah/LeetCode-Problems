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
        int recstack[]=new int[V];
        for(int itr1=0;itr1<V;itr1++){
            if(visited[itr1]==0){
                if(checkCycle(itr1,visited,recstack,adj)){
                    return true;
                }
            }
        }
        return false;
    }
    private boolean checkCycle(int start,int[] visited,int recstack[],ArrayList<ArrayList<Integer>> graph){
        visited[start]=1;
        recstack[start]=1;
        for(Integer itr1 : graph.get(start)){
            if(visited[itr1]==0){
                if(checkCycle(itr1,visited,recstack,graph)){
                    return true;
                }
            }else if(recstack[itr1]==1){
                return true;
            }
        }
        recstack[start]=0;
        return false;
    }
}