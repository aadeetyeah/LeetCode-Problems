// { Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class DriverClass
{
    public static void main(String args[]) throws IOException {

        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String str[] = read.readLine().trim().split(" ");
            int V = Integer.parseInt(str[0]);
            int E = Integer.parseInt(str[1]);
    
            ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<ArrayList<ArrayList<Integer>>>();
            for(int i=0;i<V;i++)
            {
                adj.add(new ArrayList<ArrayList<Integer>>());
            }
            
            int i=0;
            while (i++<E) {
                String S[] = read.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                int w = Integer.parseInt(S[2]);
                ArrayList<Integer> t1 = new ArrayList<Integer>();
                ArrayList<Integer> t2 = new ArrayList<Integer>();
                t1.add(v);
                t1.add(w);
                t2.add(u);
                t2.add(w);
                adj.get(u).add(t1);
                adj.get(v).add(t2);
            }
            
            int S = Integer.parseInt(read.readLine());
            
            Solution ob = new Solution();
            
            int[] ptr = ob.dijkstra(V, adj, S);
            
            for(i=0; i<V; i++)
                System.out.print(ptr[i] + " ");
            System.out.println();
        }
    }
}// } Driver Code Ends


//User function Template for Java
class Pair implements Comparable<Pair>{
    int u;
    int w;
    
    Pair(int u,int w){
        this.u=u;
        this.w=w;
    }
    public int compareTo(Pair p1){
        return this.w-p1.w;
    }
}

class Solution
{
    //Function to find the shortest distance of all the vertices
    //from the source vertex S.
    static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S)
    {
        // Write your code here
        int cost[]=new int[V];
        int visited[]=new int[V];
        PriorityQueue<Pair> q1=new PriorityQueue<>();
        q1.add(new Pair(S,0));
        
        int u;
        int w;
        while(!q1.isEmpty()){
            Pair temp=q1.remove();
            
            u=temp.u;
            w=temp.w;
            //System.out.println(u+" "+w);
            if(visited[u]!=0){
                continue;
            }
            visited[u]=1;
            cost[u]=w;
            
            ArrayList<ArrayList<Integer>> tempList=adj.get(u);
            for(ArrayList<Integer> itr1 : tempList){
                if(visited[itr1.get(0)]==0){
                    q1.add(new Pair(itr1.get(0),w+itr1.get(1)));
                }
            }
        }
        return cost;
    }
}

