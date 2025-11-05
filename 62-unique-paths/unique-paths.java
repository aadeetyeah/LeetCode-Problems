class Solution {
    public int uniquePaths(int m, int n) {
        Map<String,Integer> memo = new HashMap<>();
        return uniqueWays(m-1,n-1,memo);
    }

    private int uniqueWays(int m,int n,Map<String,Integer> memo){
        if(m < 0 || n < 0){
            return 0;
        }
        if(m == 0 && n == 0){
            return 1;
        }
        String key = Integer.toString(m)+"_"+Integer.toString(n);
        if(memo.containsKey(key)){
            return memo.get(key);
        }
        int up = uniqueWays(m-1,n,memo);
        int down = uniqueWays(m,n-1,memo);
        memo.put(key,up+down);
        return memo.get(key);
    }
}