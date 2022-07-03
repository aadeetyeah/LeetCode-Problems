class Solution {
    public int change(int amount, int[] coins) {
        Map<String,Integer> map1=new HashMap<>();
        
        return numOfCombo(0,coins,amount,map1);
    }
    
    private int numOfCombo(int start,int[] coins,int amount,Map<String,Integer> map1){
        if(amount==0){
            return 1;
        }
        if(start>=coins.length){
            return 0;
        }
        String key=Integer.toString(start)+"_"+Integer.toString(amount);
        if(map1.containsKey(key)){
            return map1.get(key);
        }
        int consider=0;
        
        if(coins[start]<=amount){
            consider=numOfCombo(start,coins,amount-coins[start],map1);
        }
        int notConsider=numOfCombo(start+1,coins,amount,map1);
        map1.put(key,consider+notConsider);
        return map1.get(key);
    }
}