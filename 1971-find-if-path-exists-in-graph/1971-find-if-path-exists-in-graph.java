class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        ArrayList<ArrayList<Integer>> arr=new ArrayList<>();
        
        for(int itr1=0;itr1<n;itr1++){
            arr.add(new ArrayList<Integer>());
        }
        for(int itr1=0;itr1<edges.length;itr1++){
            arr.get(edges[itr1][0]).add(edges[itr1][1]);
            arr.get(edges[itr1][1]).add(edges[itr1][0]);
        }
        int visited[]=new int[n];
        Queue<Integer> q1=new LinkedList<>();
        q1.add(source);
        while(!q1.isEmpty()){
            int temp=q1.remove();
            visited[temp]=1;
            if(temp==destination){
                return true;
            }
            for(Integer i : arr.get(temp)){
                if(visited[i]==0)
                    q1.add(i);
            }
        }
        return false;
    }
}