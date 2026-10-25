class Solution {
    public boolean canCross(int[] stones) {
        Map<Integer,Integer> memo = new HashMap<>();
        for(int itr1=0;itr1<stones.length;itr1++){
            memo.put(stones[itr1],itr1);
        }
        Map<String,Boolean> cache = new HashMap<>();
        return checkCross(stones,memo,0,1,cache);
    }

    private boolean checkCross(int[] stones,Map<Integer,Integer> memo, int index,int k,Map<String,Boolean> cache){
        int result = stones[index] + k;
        if(result == stones[stones.length-1]){
            return true;
        }
        int newIndex = -1;
        String key = Integer.toString(index)+"_"+Integer.toString(k);
        if(cache.containsKey(key)){
            return cache.get(key);
        }
        if(memo.containsKey(result)){
            newIndex = memo.get(result);
        }else{
            return false;
        }

        boolean flag = checkCross(stones,memo,newIndex,k+1,cache) ||
        checkCross(stones,memo,newIndex,k,cache);
        if(k-1 > 0){
            flag = flag || checkCross(stones,memo,newIndex,k-1,cache);
        }

        cache.put(key,flag);
        return flag;
    }
}