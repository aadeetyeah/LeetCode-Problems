class Solution {
    public int numIslands(char[][] grid) {
         int count=0;
        for(int itr1=0;itr1<grid.length;itr1++){
            for(int itr2=0;itr2<grid[0].length;itr2++){
                if(getNumOfIslands(itr1,itr2,grid)){
                    count++;
                }
            }
        }
        return count;
    }
    
    private boolean getNumOfIslands(int sr,int sc,char[][] grid){
        Queue<Pair<Integer,Integer>> q1=new LinkedList<>();
        boolean flag=false;
        q1.add(new Pair<>(sr,sc));
        
        while(!q1.isEmpty()){
            Pair<Integer,Integer> p1=q1.remove();
            int temp_sr=p1.getKey();
            int temp_sc=p1.getValue();
            if(temp_sr>=grid.length || temp_sc>=grid[0].length || temp_sr<0 || temp_sc<0 || grid[temp_sr][temp_sc]=='0'){
                continue;
            }
            
            grid[temp_sr][temp_sc]='0';
            flag=true;
            q1.add(new Pair(temp_sr-1,temp_sc));
            q1.add(new Pair(temp_sr+1,temp_sc));
            q1.add(new Pair(temp_sr,temp_sc-1));
            q1.add(new Pair(temp_sr,temp_sc+1));
        }
        return flag;
    }
}