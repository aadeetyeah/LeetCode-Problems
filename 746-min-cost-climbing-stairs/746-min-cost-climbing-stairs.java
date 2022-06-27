class Solution {
    public int minCostClimbingStairs(int[] cost) {
        
        Map<Integer,Integer> memo=new HashMap<>();
        
        memo.put(0,minCost(cost,0,memo));
        return Math.min(memo.get(0),memo.get(1));
    }
    
    private int minCost(int cost[],int index,Map<Integer,Integer> memo){
        if(memo.containsKey(index)){
            return memo.get(index);
        }
        if(index==cost.length){
            return 0;
        }
        if(index>cost.length){
            return 1000;
        }
        memo.put(index,cost[index]+Math.min(minCost(cost,index+1,memo),minCost(cost,index+2,memo)));
        return memo.get(index);
    }
}