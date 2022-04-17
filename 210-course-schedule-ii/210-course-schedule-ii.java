class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
 
        HashMap<Integer,List<Integer>> graph=new HashMap<>();
        for(int itr1=0;itr1<numCourses;itr1++){
            graph.put(itr1,new ArrayList<Integer>());
        }
        for(int itr1=0;itr1<prerequisites.length;itr1++){
            graph.get(prerequisites[itr1][1]).add(prerequisites[itr1][0]);
        }
        
        int visited[]=new int[numCourses];
        int recStack[]=new int[numCourses];
        ArrayList<Integer> order=new ArrayList<>();
        
        for(int itr1=0;itr1<numCourses;itr1++){
            if(visited[itr1]==0){
                if(canFinishCourses(itr1,visited,recStack,graph,order)){
                    return new int[0];
                }
            }
        }
        Collections.reverse(order);
        int finalAnswer[]=order.stream().mapToInt(i -> i).toArray();
        
        return finalAnswer;
    }
    
    boolean canFinishCourses(int start,int visited[],int recStack[],Map<Integer,List<Integer>> graph,List<Integer> order){
        visited[start]=1;
        recStack[start]=1;
        for(Integer itr1 : graph.get(start)){
            if(visited[itr1]==0){
                if(canFinishCourses(itr1,visited,recStack,graph,order)){
                    return true;
                }
            }else if(recStack[itr1]==1){
                return true;
            }
        }
        recStack[start]=0;
        order.add(start);
        return false;
    }
}
