class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> answer=new ArrayList<>();
        int visited[]=new int[graph.length];
        pathsToTarget(0,graph.length-1,graph,answer,new ArrayList<Integer>(),visited);
        return answer;
    }
    private void pathsToTarget(int start,int end,int[][] graph,List<List<Integer>> ans,List<Integer> temp,int[] visited){
        visited[start]=1;
        temp.add(start);
        if(start==end){
            ans.add(new ArrayList<Integer>(temp));
            temp.remove(temp.size()-1);
            visited[start]=0;
            return;
        }
        for(int itr1 : graph[start]){
            if(visited[itr1]==0){
                pathsToTarget(itr1,end,graph,ans,temp,visited);
            }
        }
        temp.remove(temp.size()-1);
        visited[start]=0;
        return;
    }
}