class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> result=new ArrayList<>();
        List<Integer> l1=new ArrayList<>();
        traverseGraph(0,graph.length-1,graph,result,l1);
        return result;
    }
    
    private void traverseGraph(int start,int dest,int[][] graph,List<List<Integer>> result,List<Integer> l1){
        if(start==dest){
            l1.add(start);
            result.add(new ArrayList<>(l1));
            l1.remove(new Integer(start));
            return;
        }
        l1.add(start);
        for(int itr1=0;itr1<graph[start].length;itr1++){
            traverseGraph(graph[start][itr1],dest,graph,result,l1);
        }
        l1.remove(new Integer(start));
        return;
    }
}