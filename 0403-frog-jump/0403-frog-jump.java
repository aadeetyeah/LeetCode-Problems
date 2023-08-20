class Solution {
    public boolean canCross(int[] stones) {
        Map<String,Boolean> memo = new HashMap<>();
        return willCross(stones,0,1,memo);
    }
    
    private boolean willCross(int[] stones,int index,int k,Map<String,Boolean> memo){
        int result = stones[index]+k;
        
        if(result==stones[stones.length-1]){
            return true;
        }
        String key=Integer.toString(index)+"_"+Integer.toString(k);
        
        if(memo.containsKey(key)){
            return memo.get(key);
        }
        
        boolean flagResult  =   false;
        
        for(int itr1=index+1;itr1<stones.length;itr1++){
            if(result==stones[itr1]){
                flagResult = (willCross(stones,itr1,k+1,memo) || willCross(stones,itr1,k,memo) || willCross(stones,itr1,k-1,memo));
                break;
            }
        }
        memo.put(key,flagResult);
        return flagResult;
    }
}