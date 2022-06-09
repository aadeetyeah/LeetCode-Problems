class Solution {
    public int rob(int[] nums) {
        Map<Integer,Integer> store=new HashMap<>();
        return steal(nums,0,store);
    }
    
    private int steal(int nums[],int start,Map<Integer,Integer> store){
        
        if(store.containsKey(start)){
            return store.get(start);
        }
        if(start>=nums.length){
            return 0;
        }
        
        
        int canRob=nums[start]+steal(nums,start+2,store);
        int noRob=steal(nums,start+1,store);
        store.put(start,Math.max(canRob,noRob));
        return store.get(start);
    }
    
}