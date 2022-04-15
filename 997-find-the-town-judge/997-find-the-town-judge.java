class Solution {
    public int findJudge(int n, int[][] trust) {
        
        
        int inDeg[]=new int[n];
        int outDeg[]=new int[n];
        
        for(int itr1=0;itr1<trust.length;itr1++){
            int v1=trust[itr1][0];
            int v2=trust[itr1][1];
            inDeg[v2-1]++;
            outDeg[v1-1]++;
        }
        
        for(int itr1=0;itr1<n;itr1++){
            if(inDeg[itr1]==n-1 && outDeg[itr1]==0){
                return itr1+1;
            }
        }
        return -1;
    }
}