class Solution {
    public int coinChange(int[] coins, int amount) {
        Map<String,Integer> m1=new HashMap<>();
        int res=coin_Change(coins,amount,0,m1);
        if(res==Integer.MAX_VALUE){
            return -1;
        }
        return res;
    }
    
    private int coin_Change(int coins[],int amount,int ind,Map<String,Integer> m1){
        
        if(amount==0){
            return 0;
        }
        
        if(ind>=coins.length){
            return Integer.MAX_VALUE;
        }
        String key=Integer.toString(amount)+"_"+Integer.toString(ind);
        if(m1.containsKey(key)){
            return m1.get(key);
        }
        
        int consider=Integer.MAX_VALUE;
        if(amount>=coins[ind]){
            consider=coin_Change(coins,amount-coins[ind],ind,m1);
            if(consider!=Integer.MAX_VALUE){
                consider++;
            }
        }
        int notConsider=coin_Change(coins,amount,ind+1,m1);
        
        
        
        m1.put(key, Math.min(consider,notConsider));
        return m1.get(key);
    }
}