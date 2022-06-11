class Solution {
    public int rob(int[] nums) {
        
        if(nums.length==1){
            return nums[0];
        }
        if(nums.length==2){
            return Math.max(nums[0],nums[1]);
        }
        Map<Integer,Integer> map1=new HashMap<>();
        int max=steal(0,nums,nums.length-1,map1);
        map1.clear();
        int max2=steal(1,nums,nums.length,map1);
        
        return Math.max(max,max2);
    }
    
    private int steal(int start,int nums[],int end,Map<Integer,Integer> m1){
        
        if(m1.containsKey(start)){
            return m1.get(start);
        }
        if(start>=end){
            return 0;
        }
    
        int rob=nums[start]+steal(start+2,nums,end,m1);
        int notRob=steal(start+1,nums,end,m1);
        
        m1.put(start,Math.max(rob,notRob));
        return m1.get(start);
    }
}
