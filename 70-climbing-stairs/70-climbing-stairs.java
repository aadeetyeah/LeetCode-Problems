class Solution {
    public int climbStairs(int n) {
        Map<Integer,Integer> m1=new HashMap<>();
        return climb(0,n,m1);
    }
    
    int climb(int src,int dest,Map<Integer,Integer> m1){
        if(m1.containsKey(src)){
            return m1.get(src);
        }
        if(src==dest){
            return 1;
        }
        if(src>dest){
            return 0;
        }
        
        m1.put(src,climb(src+1,dest,m1)+climb(src+2,dest,m1));
        return m1.get(src);
    }
}