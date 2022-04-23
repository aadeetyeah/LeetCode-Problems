class Pair implements Comparable<Pair>{
    int v;
    int w;
    Pair(int v,int w){
        this.v=v;
        this.w=w;
    }
    
    public int compareTo(Pair p1){
        return this.w-p1.w;
    }
}

class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<List<Integer>>> graph=createGraph(times,n);
        int cost[]=new int[n];
        Arrays.fill(cost,-1);
        int visited[]=new int[n];
        
        PriorityQueue<Pair> pq1=new PriorityQueue<>();
        pq1.add(new Pair(k,0));
        
        int u,w;
        while(!pq1.isEmpty()){
            Pair temp=pq1.remove();
            u=temp.v;
            w=temp.w;
            if(visited[u-1]==1){
                continue;
            }
            visited[u-1]=1;
            
            cost[u-1]=w;
            List<List<Integer>> itrList=graph.get(u-1);
            for(List<Integer> itr1 : itrList){
               if(visited[itr1.get(0)-1]==0){
                   pq1.add(new Pair(itr1.get(0),w+itr1.get(1)));
               } 
            }
        }
        int temp=0;
        for(int i : cost){
            if(i==-1){
                temp= -1;
                break;
            }
            if(i>temp){
                temp=i;
            }
        }
        return temp;
    }
    
    private List<List<List<Integer>>> createGraph(int[][] times,int n){
        List<List<List<Integer>>> graph=new ArrayList<>();
        for(int itr1=0;itr1<n;itr1++){
            graph.add(new ArrayList<List<Integer>>());
        }
        int u,v,w;
        for(int itr1=0;itr1<times.length;itr1++){
            u=times[itr1][0];
            v=times[itr1][1];
            w=times[itr1][2];
            ArrayList<Integer> list1=new ArrayList<>();
            list1.add(v);
            list1.add(w);
            graph.get(u-1).add(list1);
        }
        return graph;
    }
}