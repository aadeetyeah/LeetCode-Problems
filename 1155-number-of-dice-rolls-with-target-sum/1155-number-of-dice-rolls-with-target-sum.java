class Solution {
    final int mod = (int)1e9+7;
    public int numRollsToTarget(int n, int k, int target) {
        Map<String,Integer> map1=new HashMap<>();
        return countToTarget(n,k,target,0,map1);
    }
    
    private int countToTarget(int n,int k,int target,int sum,Map<String,Integer> map1){
        if(n==0 && sum==target){
            return 1;
        }
        if(n<=0 || sum>target){
            return 0;
        }
        String key=Integer.toString(n)+"_"+Integer.toString(sum);
        if(map1.containsKey(key)){
            return map1.get(key);
        }
        int ans=0;
        for(int itr1=1;itr1<=k;itr1++){
            
            ans=(ans + countToTarget(n-1,k,target,sum+itr1,map1))%mod;
        }
        
        map1.put(key,ans%mod);
        return map1.get(key);
    }
}