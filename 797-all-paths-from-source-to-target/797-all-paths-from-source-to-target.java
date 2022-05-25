class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        Queue<List<Integer>> q1=new LinkedList<>();
        
        List<Integer> l1=new ArrayList<>();
        l1.add(0);
        
        q1.add(l1);
        
        List<List<Integer>> answer=new ArrayList<>();
        
        while(!q1.isEmpty()){
            
            List<Integer> t1=q1.remove();
            int u=t1.get(t1.size()-1);
            if(u==graph.length-1){
                answer.add(t1);
                continue;
            }
            for(int i : graph[u]){
                List<Integer> temp=new ArrayList<>(t1);
                temp.add(i);
                q1.add(temp);
            }
        }
        return answer;
    }
}