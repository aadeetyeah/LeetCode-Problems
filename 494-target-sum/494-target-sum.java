class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        
        Map<String,Integer> map1=new HashMap<>();
        return numOfWays(0,0,nums,target,map1);
    }
    
    private int numOfWays(int start,int sum,int nums[],int target,Map<String,Integer> map1){
        String key=Integer.toString(start)+"_"+Integer.toString(sum);
        if(map1.containsKey(key)){
            return map1.get(key);
        }
        if(sum==target && start>=nums.length){
            return 1;
        }
        if(start>=nums.length){
            return 0;
        }
        
        map1.put(key,numOfWays(start+1,sum+nums[start],nums,target,map1)+numOfWays(start+1,sum-nums[start],nums,target,map1));
        return map1.get(key);
    }
}