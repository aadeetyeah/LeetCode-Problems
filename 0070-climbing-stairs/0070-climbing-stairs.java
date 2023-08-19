class Solution {
    public int climbStairs(int n) {
        Map<Integer,Integer> memo=new HashMap<>();
        return numberOfWays(n,memo);
    }
    
    private int numberOfWays(int n,Map<Integer,Integer> memo){
        if(n==0){
            return 1;
        }
        if(n<0){
            return 0;
        }
        if(memo.containsKey(n)){
            return memo.get(n);
        }
        
        int result = numberOfWays(n-1,memo) + numberOfWays(n-2,memo);
        memo.put(n,result);
        return result;
        
    }
}