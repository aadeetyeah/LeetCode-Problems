class Solution {
    public int minCostClimbingStairs(int[] cost) {
        Map<Integer,Integer> m1=new HashMap<Integer,Integer>();
        int finalresult = minCost(0,cost,m1);
        return Math.min(finalresult,m1.get(1));
    }
    
    private int minCost(int index,int cost[],Map<Integer,Integer> m1){
        
        if(index>=cost.length){
            return 0;
        }
        if(m1.containsKey(index)){
            return m1.get(index);
        }
        
        int result=cost[index]+Math.min(minCost(index+1,cost,m1),minCost(index+2,cost,m1));
        m1.put(index,result);
        return result;
    }
}