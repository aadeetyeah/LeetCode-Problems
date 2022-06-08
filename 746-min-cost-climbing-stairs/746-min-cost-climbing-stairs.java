class Solution {
    public int minCostClimbingStairs(int[] cost) {
        Map<Integer,Integer> map1=new HashMap<>();
        return Math.min(climb(0,cost.length,cost,map1),climb(1,cost.length,cost,map1));
        
    }
    
    private int climb(int src,int target,int cost[],Map<Integer,Integer> map1){
        
        if(map1.containsKey(src)){
            return map1.get(src);
        }
        if(src==target){
            return 0;
        }
        if(src>target){
            return Integer.MAX_VALUE;
        }
        
        int price=cost[src]+Math.min(climb(src+1,target,cost,map1),climb(src+2,target,cost,map1));
        
        map1.put(src,price);
        return price;
    }
}