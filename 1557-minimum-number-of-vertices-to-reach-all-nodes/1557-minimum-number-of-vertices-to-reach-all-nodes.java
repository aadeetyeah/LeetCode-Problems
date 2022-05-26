class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        int indegree[]=new int[n];
        for(int itr1=0;itr1<edges.size();itr1++){
            indegree[edges.get(itr1).get(1)]++;
        }
        
        List<Integer> answer=new ArrayList<>();
        for(int itr1=0;itr1<n;itr1++){
            if(indegree[itr1]==0){
                answer.add(itr1);
            }   
        }        
        return answer;
    }
}