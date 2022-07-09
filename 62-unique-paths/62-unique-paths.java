class Solution {
    public int uniquePaths(int m, int n) {
        HashMap<String,Integer> map1=new HashMap<>();
        return diffPaths(0,0,m-1,n-1,map1);  
    }
    
    private int diffPaths(int start_r,int start_c,int m,int n,HashMap<String,Integer> map1){
        if(start_r>m || start_c>n){
            return 0;
        }
        if(start_r==m && start_c==n){
            return 1;
        }
        String key=Integer.toString(start_r)+"_"+Integer.toString(start_c);
        if(map1.containsKey(key)){
            return map1.get(key);
        }
        
        map1.put(key,diffPaths(start_r,start_c+1,m,n,map1)+diffPaths(start_r+1,start_c,m,n,map1));
        return map1.get(key);
    }
}