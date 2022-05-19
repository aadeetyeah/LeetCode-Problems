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
            
            Solution ob = new Solution();
            
            System.out.println(ob.spanningTree(V, adj));
        }
    }
}// } Driver Code Ends


// User function Template for Java
class Pair implements Comparable<Pair>{
    private Integer i1;
    private Integer i2;
    Pair(Integer i1,Integer i2){
        this.i1=i1;
        this.i2=i2;
    }
    public Integer getKey(){
        return i1;
    }
    
    public Integer getValue(){
        return i2;
    }
    
    public int compareTo(Pair p){
        return this.i2-p.i2;
    }
    
}


class Solution
{
    //Function to find sum of weights of edges of the Minimum Spanning Tree.
    static int spanningTree(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj) 
    {
        // Add your code here
        int sum=0;
        PriorityQueue<Pair> pq=new PriorityQueue<>();
        pq.add(new Pair(0,0));
        int visited[]=new int[V];
        
        while(!pq.isEmpty()){
            Pair temp=pq.remove();
            int src=temp.getKey();
            int cost=temp.getValue();
            
            if(visited[src]==1){
                continue;
            }
            
            sum+=cost;
            visited[src]=1;
            
            ArrayList<ArrayList<Integer>> arr=adj.get(src);
            
            for(ArrayList<Integer> itr1 : arr){
                int v=itr1.get(0);
                int w=itr1.get(1);
                if(visited[v]==0){
                    pq.add(new Pair(v,w));
                }
            }
        }
        return sum;
    }
}
