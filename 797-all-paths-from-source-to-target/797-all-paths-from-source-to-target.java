class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> answer=new ArrayList<>();
        
        getAllPaths(0,graph.length-1,graph,answer,new ArrayList<Integer>());
        return answer;
    }
    
    private void getAllPaths(int src,int target,int graph[][],List<List<Integer>> ans,ArrayList<Integer> res){
        res.add(src);
        if(src==target){
            ans.add(new ArrayList(res));
            res.remove(res.size()-1);
            return;
        }
        
        
        for(int itr1 : graph[src]){
            getAllPaths(itr1,target,graph,ans,res);
        }
        res.remove(res.size()-1);
        return;
    }
}