class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer,List<Integer>> graph=new HashMap<>();
        for(int itr1=0;itr1<numCourses;itr1++){
            graph.put(itr1,new ArrayList<Integer>());
        }
        for(int itr1=0;itr1<prerequisites.length;itr1++){
            graph.get(prerequisites[itr1][1]).add(prerequisites[itr1][0]);
        }
        
        int visited[]=new int[numCourses];
        int recStack[]=new int[numCourses];
        
        for(int itr1=0;itr1<numCourses;itr1++){
            if(visited[itr1]==0){
                if(canFinishCourses(itr1,visited,recStack,graph)){
                    return false;
                }
            }
        }
        return true;
    }
    
    boolean canFinishCourses(int start,int visited[],int recStack[],Map<Integer,List<Integer>> graph){
        visited[start]=1;
        recStack[start]=1;
        for(Integer itr1 : graph.get(start)){
            if(visited[itr1]==0){
                if(canFinishCourses(itr1,visited,recStack,graph)){
                    return true;
                }
            }else if(recStack[itr1]==1){
                return true;
            }
        }
        recStack[start]=0;
        return false;
    }
}