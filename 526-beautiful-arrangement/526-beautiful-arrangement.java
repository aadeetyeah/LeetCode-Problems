class Solution {
    public int countArrangement(int n) {
        int count[]=new int[1];
        count[0]=0;
        boolean visited[]=new boolean[n+1];
        
        countArrgmnt(1,visited,count);
        return count[0];
    }
    
    private void countArrgmnt(int pos,boolean visited[],int count[]){
        
        if(pos>=visited.length){
            count[0]+=1;
            return;
        }
        
        for(int itr1=1;itr1<visited.length;itr1++){
            if(!visited[itr1] && (itr1%pos==0 || pos%itr1==0)){
                visited[itr1]=true;
                countArrgmnt(pos+1,visited,count);
                visited[itr1]=false;
            }
        }
    }
}