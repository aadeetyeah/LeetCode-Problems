class Solution {
    public int uniquePaths(int m, int n) {
        Map<String,Integer> memo = new HashMap<>();
        return uniqueWays(m-1,n-1,memo);
    }

    private int uniqueWays(int itr1, int itr2, Map<String,Integer> memo){
        if(itr1<0 || itr2<0){
            return 0;
        }

        if(itr1==0 && itr2==0){
            return 1;
        }

        String key = Integer.toString(itr1)+"_"+Integer.toString(itr2);
        if(memo.containsKey(key)){
            return memo.get(key);
        }
        int up = uniqueWays(itr1-1,itr2,memo);
        int left = uniqueWays(itr1,itr2-1,memo);
        memo.put(key, up+left);
        return memo.get(key);
    }         
}