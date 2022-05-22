class Pair implements Comparable<Pair>{
    int v;
    int w;
    Pair(int v,int w){
        this.v=v;
        this.w=w;
    }
    public int getKey(){
        return v;
    }
    public int getValue(){
        return w;
    }
    public int compareTo(Pair p1){
        return this.w-p1.w;
    }
}
class Solution {
    public int minCostConnectPoints(int[][] points) {
        ArrayList<ArrayList<ArrayList<Integer>>> graph=createGraph(points);
        
        
          /*  for(ArrayList<ArrayList<Integer>> list : graph){
                for(ArrayList<Integer> itr2 : list){
                    System.out.println("("+itr2.get(0)+"-"+itr2.get(1)+")" );
                }
                  System.out.println();
            }*/
          
        
        
        int res=minCost(graph,0,points.length);
        return res;
    }
    
    private int minCost(ArrayList<ArrayList<ArrayList<Integer>>> graph,int src1,int v){
        PriorityQueue<Pair> pq=new PriorityQueue<>();
        
        pq.add(new Pair(src1,0));
        int sum=0;
        int visited[]=new int[v];
        while(!pq.isEmpty()){
            Pair temp=pq.remove();
            int src=temp.getKey();
            int wt=temp.getValue();
            if(visited[src]==1){
                continue;
            }
            visited[src]=1;
            sum+=wt;
            ArrayList<ArrayList<Integer>> itrList=graph.get(src);
            for(ArrayList<Integer> itr1 : itrList){
                if(visited[itr1.get(0)]==0){
                    pq.add(new Pair(itr1.get(0),itr1.get(1)));
                }
            }
        }
        
              
        return sum;
    }
    
    private ArrayList<ArrayList<ArrayList<Integer>>> createGraph(int points[][]){
        ArrayList<ArrayList<ArrayList<Integer>>> arr=new ArrayList<>();
        
        for(int itr1=0;itr1<points.length;itr1++){
            arr.add(new ArrayList<ArrayList<Integer>>());
        }
        for(int itr1=0;itr1<points.length;itr1++){
            for(int itr2=itr1+1;itr2<points.length;itr2++){
                int x1=points[itr1][0];
                int y1=points[itr1][1];
                int x2=points[itr2][0];
                int y2=points[itr2][1];
              //  System.out.println("x1,y1: "+x1+" "+y1);
               // System.out.println("x2,y2: "+x2+" "+y2);
                
                int man_dist=Math.abs(x1-x2)+Math.abs(y1-y2);
               // System.out.println(man_dist);
                ArrayList<Integer> pairList1=new ArrayList<>();
                ArrayList<Integer> pairList2=new ArrayList<>();
                
                pairList1.add(itr2);
                pairList1.add(man_dist);
                
                pairList2.add(itr1);
                pairList2.add(man_dist);
                
                arr.get(itr1).add(pairList1);
                arr.get(itr2).add(pairList2);
            }
        }
        return arr;
    }
}