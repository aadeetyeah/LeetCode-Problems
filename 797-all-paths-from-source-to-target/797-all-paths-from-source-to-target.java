class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> answer=new ArrayList<>();
        traverseSrcToTarget(0,graph.length-1,answer,new ArrayList<Integer>(),graph);
        return answer;
    }
    
    private void traverseSrcToTarget(int src,int target,List<List<Integer>> ans,List<Integer> res,int graph[][]){
        res.add(src);
        if(src==target){
            ans.add(new ArrayList<Integer>(res));
            return;
        }
        for(int itr1=0;itr1<graph[src].length;itr1++){
            traverseSrcToTarget(graph[src][itr1],target,ans,res,graph);
            res.remove(res.size()-1);
        }
        
        return;
    }
    
}