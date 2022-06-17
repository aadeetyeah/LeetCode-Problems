class Solution {
    public boolean canPartition(int[] nums) {
        
        int sum=0;
        for(int itr1=0;itr1<nums.length;itr1++){
            sum+=nums[itr1];
        }
        if(sum%2==1){
            return false;
        }
        HashMap<String,Boolean> map=new HashMap<>();
        return checkSubset(0,0,sum/2,nums,map);
    }
    
    private boolean checkSubset(int index,int sum,int amount,int nums[],HashMap<String,Boolean> map){
        
        String key=Integer.toString(index)+"_"+Integer.toString(sum);
        if(map.containsKey(key)){
            return map.get(key);
        }
        if(sum==amount){
            return true;
        }
        if(sum>amount || index>=nums.length){
            return false;
        }
        int sum2=sum;
        
        map.put(key,checkSubset(index+1,sum+=nums[index],amount,nums,map) || checkSubset(index+1,sum2,amount,nums,map));
        return map.get(key);
    }
}